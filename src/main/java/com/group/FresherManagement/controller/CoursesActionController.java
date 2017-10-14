package com.group.FresherManagement.controller;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Courses_Subject;
import com.group.FresherManagement.entities.Subject;
import com.group.FresherManagement.services.CoursesServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CourseAction", urlPatterns = "/CourseAction")
public class CoursesActionController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("btnAction");
        CoursesServices coursesServices = new CoursesServices();
        int courseId = Integer.parseInt(req.getParameter("txtCourseId"));
        if(action.equalsIgnoreCase("AddSubject")){
            int subjectId = Integer.parseInt(req.getParameter("txtSubjectId"));
            Courses_Subject coursesSubject = new Courses_Subject();
            Courses courses = new Courses();
            courses.setId(courseId);
            Subject subject = new Subject();
            subject.setId(subjectId);
            coursesSubject.setCourses(courses);
            coursesSubject.setSubject(subject);
            coursesServices.addSubjectToCourse(coursesSubject);
        } else if(action.equalsIgnoreCase("RemoveSubject")){
            int id = Integer.parseInt(req.getParameter("txtId"));
            Courses_Subject coursesSubject = new Courses_Subject();
            coursesSubject.setId(id);
            coursesServices.removeSubjectFromCourses(coursesSubject);
        } else {

        }
        resp.sendRedirect("viewCourse?id=" + courseId);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("Invalid request");
        out.flush();
    }
}

package com.group.FresherManagement.controller.course;

import com.group.FresherManagement.entities.*;
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
    CoursesServices coursesServices;

    @Override
    public void init() throws ServletException {
        coursesServices = new CoursesServices();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("btnAction");
        int courseId = Integer.parseInt(req.getParameter("txtCourseId"));
        if (action.equalsIgnoreCase("AddSubject")) {
            int subjectId = Integer.parseInt(req.getParameter("txtSubjectId"));
            CoursesSubject coursesSubject = new CoursesSubject();
            Courses courses = coursesServices.findCourseById(courseId);
            Subject subject = coursesServices.findSubjectById(subjectId);
            coursesSubject.setCourses(courses);
            coursesSubject.setSubject(subject);
            coursesServices.addSubjectToCourse(coursesSubject);
        } else if (action.equalsIgnoreCase("RemoveSubject")) {
            int id = Integer.parseInt(req.getParameter("txtId"));
            CoursesSubject coursesSubject = coursesServices.findCourseSubjectById(id);
            coursesServices.removeSubjectFromCourses(coursesSubject);
        }
        if (action.equalsIgnoreCase("AddFresher")) {
            int fresherId = Integer.parseInt(req.getParameter("txtFresherId"));
            CoursesFresher coursesFresher = new CoursesFresher();
            Courses courses = new Courses();
            courses.setId(courseId);
            Fresher fresher = new Fresher();
            fresher.setId(fresherId);
            coursesFresher.setCourses(courses);
            coursesFresher.setFresher(fresher);
            coursesServices.addFresherToCourse(coursesFresher);
        } else if (action.equalsIgnoreCase("RemoveFresher")) {
            int id = Integer.parseInt(req.getParameter("txtId"));
            CoursesFresher courses_fresher = new CoursesFresher();
            courses_fresher.setId(id);
            coursesServices.removeFresherFromCourses(courses_fresher);
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

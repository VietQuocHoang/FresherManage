package com.group.FresherManagement.controller.course;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Fresher;
import com.group.FresherManagement.entities.Subject;
import com.group.FresherManagement.services.CoursesServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "viewCourse", urlPatterns = "/viewCourse")
public class ViewCourseController extends HttpServlet {
    private CoursesServices coursesServices;

    @Override
    public void init() throws ServletException {
        coursesServices = new CoursesServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            PrintWriter out = resp.getWriter();
            out.println("Invalid request");
            out.close();
        }
        Courses courses = coursesServices.findCourseById(id);
        if (courses == null) {
            resp.sendRedirect("courses");
        } else {
            List<Subject> notIncludedSubjectList = coursesServices.findSubjectNotIncludedInCourse(courses);
            List<Fresher> notIncludedFresherList = coursesServices.findFresherNotIncludedInCourse(courses);
            req.setAttribute("course", courses);
            req.setAttribute("notIncluded", notIncludedSubjectList);
            req.setAttribute("notIncludedFresher", notIncludedFresherList);
            req.getRequestDispatcher("course-detail.jsp").forward(req, resp);
        }
    }
}

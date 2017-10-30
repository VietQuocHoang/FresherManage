package com.group.FresherManagement.controller.course;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.services.CoursesServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "courses", urlPatterns = "/courses")
public class CourseController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CoursesServices coursesServices = new CoursesServices();
        List<Courses> coursesList = coursesServices.findAllCourses();
        req.setAttribute("coursesList", coursesList);
        req.getRequestDispatcher("course-page.jsp").forward(req, resp);
    }
}

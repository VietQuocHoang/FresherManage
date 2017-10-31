package com.group.FresherManagement.controller.course;

import com.group.FresherManagement.services.CoursesServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteCourse", urlPatterns = "/DeleteCourse")
public class DeleteCourseController extends HttpServlet {
    private CoursesServices coursesServices;

    @Override
    public void init() throws ServletException {
        coursesServices = new CoursesServices();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = -1;
        try {
            id = Integer.parseInt(req.getParameter("txtId"));
        } catch (NumberFormatException e){
            PrintWriter out = resp.getWriter();
            out.println("Invalid request");
            out.close();
        }
        coursesServices.deleteCourses(id);
        resp.sendRedirect("courses");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Invalid request");
        out.flush();
    }
}

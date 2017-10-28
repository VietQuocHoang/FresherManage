package com.group.FresherManagement.api;

import com.google.gson.Gson;
import com.group.FresherManagement.entities.Courses;
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

@WebServlet(urlPatterns = "/api/courses/not-included")
public class GetNotIncludedSubjectAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        try {
            int courseId = Integer.parseInt("courseId");
            CoursesServices coursesServices = new CoursesServices();
            Courses courses = new Courses();
            courses.setId(courseId);
            List<Subject> list = coursesServices.findSubjectNotIncludedInCourse(courses);
            String jsonObject = new Gson().toJson(list);
            out.print(jsonObject);
            out.flush();
            out.close();
        } catch (NumberFormatException e) {
            resp.sendRedirect("courses");
        }
    }
}

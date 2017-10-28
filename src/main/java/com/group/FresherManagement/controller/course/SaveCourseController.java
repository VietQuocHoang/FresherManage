package com.group.FresherManagement.controller.course;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.services.CoursesServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "SaveCourse", urlPatterns = "/SaveCourse")
public class SaveCourseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Get does not support");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int state = Integer.parseInt(req.getParameter("btnAction"));
        String courseName = req.getParameter("txtCourseName");
        String courseDescription = req.getParameter("txtCourseDescription");
        String txtStartDate = req.getParameter("txtStartDate");
        String txtEndDate = req.getParameter("txtEndDate");
        boolean available = req.getParameter("available") != null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = new Date(sdf.parse(txtStartDate).getTime());
            endDate = new Date(sdf.parse(txtEndDate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Courses courses = new Courses();
        courses.setAvailable(available);
        courses.setCourseDescription(courseDescription);
        courses.setCourseName(courseName);
        courses.setStartDate(startDate);
        courses.setEndDate(endDate);
        if (state == 2) {//update
            int id = Integer.parseInt(req.getParameter("txtId"));
            courses.setId(id);
        }
        CoursesServices coursesServices = new CoursesServices();
        coursesServices.saveCourse(courses, state);
        if (state == 1) {
            resp.sendRedirect("courses");
        } else {
            resp.sendRedirect("viewCourse?id=" + courses.getId());
        }

    }
}

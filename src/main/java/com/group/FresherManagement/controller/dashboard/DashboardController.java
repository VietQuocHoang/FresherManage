package com.group.FresherManagement.controller.dashboard;

import com.group.FresherManagement.services.DashboardServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Dashboard", urlPatterns = "/Dashboard")
public class DashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DashboardServices dashboardServices = new DashboardServices();
        long numOfCourse = dashboardServices.getNumOfCourses();
        long numOfSubject = dashboardServices.getNumOfSubject();
        req.setAttribute("numOfSubject", numOfSubject);
        req.setAttribute("numOfCourse", numOfCourse);
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }
}

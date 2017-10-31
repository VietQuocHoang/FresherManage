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
    private DashboardServices dashboardServices;

    @Override
    public void init() throws ServletException {
        dashboardServices = new DashboardServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long numOfCourse = dashboardServices.getNumOfCourses();
        long numOfSubject = dashboardServices.getNumOfSubject();
        long numOfFresher = dashboardServices.getNumOfFresher();
        long numOfTest = dashboardServices.getNumOfTest();
        req.setAttribute("numOfSubject", numOfSubject);
        req.setAttribute("numOfCourse", numOfCourse);
        req.setAttribute("numOfFresher", numOfFresher);
        req.setAttribute("numOfTest", numOfTest);
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }
}

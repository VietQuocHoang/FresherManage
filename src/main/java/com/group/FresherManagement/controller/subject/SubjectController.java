package com.group.FresherManagement.controller.subject;

import com.group.FresherManagement.entities.Subject;
import com.group.FresherManagement.services.SubjectServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "subjects", urlPatterns = "/subjects")
public class SubjectController extends HttpServlet {
    private SubjectServices subjectServices;

    @Override
    public void init() throws ServletException {
        subjectServices = new SubjectServices();
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
        List<Subject> subjectList = subjectServices.findAllSubject();
        req.setAttribute("subjectList", subjectList);
        req.getRequestDispatcher("subject-page.jsp").forward(req, resp);
    }
}

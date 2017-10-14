package com.group.FresherManagement.controller;

import com.group.FresherManagement.entities.Courses_Subject;
import com.group.FresherManagement.entities.Subject;
import com.group.FresherManagement.services.SubjectServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewSubject", urlPatterns = "/viewSubject")
public class ViewSubjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SubjectServices subjectServices = new SubjectServices();
        Subject subject = subjectServices.findSubjectById(id);
        if (subject == null) {
            resp.sendRedirect("subjects");
        } else {
            List<Courses_Subject> coursesSubjectList = subjectServices.getEquivalentCourses(subject);
            req.setAttribute("subject", subject);
            req.setAttribute("coursesEqui", coursesSubjectList);
            req.getRequestDispatcher("subject-detail.jsp").forward(req, resp);
        }

    }
}

package com.group.FresherManagement.controller.subject;

import com.group.FresherManagement.entities.Subject;
import com.group.FresherManagement.services.SubjectServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SaveSubject", urlPatterns = "/SaveSubject")
public class SaveSubjectController extends HttpServlet {
    private SubjectServices subjectServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Invalid request");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("txtName");
        String acronym = req.getParameter("txtAcronym");
        String description = req.getParameter("txtDescription");
        boolean available = req.getParameter("available") != null;
        int state = Integer.parseInt(req.getParameter("btnAction"));
        Subject subject = new Subject();
        subject.setName(name);
        subject.setAcronym(acronym);
        subject.setDescription(description);
        subject.setAvailable(available);
        if (state == 2) {//Update
            int id = Integer.parseInt(req.getParameter("txtId"));
            subject.setId(id);
        }
        subjectServices.saveSubject(subject, state);
        if (state == 1) {
            resp.sendRedirect("subjects");
        } else {
            resp.sendRedirect("viewSubject?id=" + subject.getId());
        }
    }
}

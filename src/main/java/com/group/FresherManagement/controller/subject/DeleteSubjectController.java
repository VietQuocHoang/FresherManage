package com.group.FresherManagement.controller.subject;

import com.group.FresherManagement.services.SubjectServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteSubject", urlPatterns = "/DeleteSubject")
public class DeleteSubjectController extends HttpServlet {
    private SubjectServices subjectServices;

    @Override
    public void init() throws ServletException {
        subjectServices = new SubjectServices();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = -1;
        try{
            id = Integer.parseInt(req.getParameter("txtId"));
        } catch (NumberFormatException e){
            PrintWriter out = resp.getWriter();
            out.print("Invalid request");
            out.close();
        }
        subjectServices.delete(id);
        resp.sendRedirect("subjects");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("Invalid request");
    }
}

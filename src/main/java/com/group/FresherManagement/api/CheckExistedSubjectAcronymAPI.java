package com.group.FresherManagement.api;

import com.google.gson.JsonObject;
import com.group.FresherManagement.services.SubjectServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/api/subjects/acronym")
public class CheckExistedSubjectAcronymAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        String acronym = req.getParameter("txtAcronym");
        SubjectServices subjectServices = new SubjectServices();
        boolean isExisted = subjectServices.checkAcronymExisted(acronym);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", isExisted);
        out.print(jsonObject.toString());
        out.flush();
        out.close();
    }
}

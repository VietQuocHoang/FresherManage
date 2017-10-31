package com.group.FresherManagement.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;
import com.group.FresherManagement.dao.SubjectDAO;
import com.group.FresherManagement.entities.CoursesFresher;
import com.group.FresherManagement.entities.CoursesSubject;
import com.group.FresherManagement.entities.Subject;
import com.group.FresherManagement.utils.HibernateProxyTypeAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/api/subjects")
public class SubjectAPI extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        List<Subject> list = new SubjectDAO(Subject.class).findAll();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        new GraphAdapterBuilder().addType(CoursesSubject.class).addType(CoursesFresher.class).registerOn(gsonBuilder);
        Gson gson = gsonBuilder.create();
        String jsonObject = gson.toJson(list);
        PrintWriter out = resp.getWriter();
        out.print(jsonObject);
        out.flush();
    }
}

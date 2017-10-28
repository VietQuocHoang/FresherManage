package com.group.FresherManagement.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;
import com.group.FresherManagement.dao.CourseDAO;
import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Courses_Fresher;
import com.group.FresherManagement.entities.Courses_Subject;
import com.group.FresherManagement.utils.HibernateProxyTypeAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/api/courses")
public class CourseAPI extends HttpServlet {

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
        List list = new CourseDAO(Courses.class).findAll();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        new GraphAdapterBuilder().addType(Courses_Subject.class).addType(Courses_Fresher.class).registerOn(gsonBuilder);
        Gson gson = gsonBuilder.create();
        String jsonObj = gson.toJson(list);
        PrintWriter out = resp.getWriter();
        out.print(jsonObj);
        out.flush();
    }
}

package com.group.FresherManagement.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group.FresherManagement.dao.FresherDAO;
import com.group.FresherManagement.entities.Fresher;
import com.group.FresherManagement.utils.HibernateProxyTypeAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "api/freshers", urlPatterns = "/api/freshers")
public class FresherAPI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        List list = new FresherDAO(Fresher.class).findAll();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        String jsonObj = gson.toJson(list);
        PrintWriter out = response.getWriter();
        out.println(jsonObj);
        out.flush();
    }
}

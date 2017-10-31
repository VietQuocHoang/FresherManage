package com.group.FresherManagement.api;

import com.google.gson.JsonObject;
import com.group.FresherManagement.services.FresherServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckEmailAPI", urlPatterns = "/api/check-email")
public class CheckEmailAPI extends HttpServlet {
    FresherServices fresherServices;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    @Override
    public void init() throws ServletException {
        fresherServices = new FresherServices();
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("txtEmail");
        boolean check = fresherServices.checkFresherRegisterByEmail(email);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("result", check);
        out.println(jsonObject.toString());
        out.flush();
        out.close();
    }
}

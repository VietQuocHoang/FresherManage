package com.group.FresherManagement.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.group.FresherManagement.services.FresherServices;
import com.group.FresherManagement.utils.HibernateProxyTypeAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckEmailAPI", urlPatterns = "/api/check-email")
public class CheckEmailAPI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");
        String email = request.getParameter("email");
        FresherServices fresherServices = new FresherServices();
        boolean check = fresherServices.checkFresherRegisterByEmail(email);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
        Gson gson = gsonBuilder.create();
        if(check == true){
            gson.toJson("1");
        }else{
            gson.toJson("0");
        }
        PrintWriter out = response.getWriter();
        out.println(gson);
        out.flush();

    }
}

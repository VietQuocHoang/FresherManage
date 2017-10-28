package com.group.FresherManagement.controller.fresher;

import com.group.FresherManagement.dao.FresherDAO;
import com.group.FresherManagement.entities.Fresher;
import com.group.FresherManagement.services.FresherServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FresherController", urlPatterns = "/FresherController")
public class FresherController extends HttpServlet {
    private static final String FRESHER_PAGE = "fresher-page.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processServlet(request, response);
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        FresherServices fresherServices = new FresherServices();
        List<Fresher> listFresher = fresherServices.findAll();
        request.setAttribute("listFresher", listFresher);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(FRESHER_PAGE);
        requestDispatcher.forward(request, response);
    }
}

package com.group.FresherManagement.controller.fresher;

import com.group.FresherManagement.entities.Fresher;
import com.group.FresherManagement.services.FresherServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewFresherController", urlPatterns = "/viewFresher")
public class ViewFresherController extends HttpServlet {
    private FresherServices fresherServices;
    private static final String FRESHER_CONTROLLER = "FresherController";
    private static final String FRESHER_DETAIL = "fresher-detail.jsp";

    @Override
    public void init() throws ServletException {
        fresherServices = new FresherServices();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fresherId = Integer.parseInt(request.getParameter("id"));
        Fresher fresher = fresherServices.findById(fresherId);
        if (fresher == null) {
            response.sendRedirect(FRESHER_CONTROLLER);
        } else {
            request.setAttribute("fresher", fresher);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(FRESHER_DETAIL);
            requestDispatcher.forward(request, response);
        }
    }
}

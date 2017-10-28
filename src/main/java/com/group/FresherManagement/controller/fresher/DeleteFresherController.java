package com.group.FresherManagement.controller.fresher;

import com.group.FresherManagement.services.FresherServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteFresherController", urlPatterns = "/DeleteFresher")
public class DeleteFresherController extends HttpServlet {
    private static final String FRESHER_CONTROLLER = "FresherController";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FresherServices fresherServices = new FresherServices();
        try {
            int fresherId = Integer.parseInt(request.getParameter("txtId"));
            fresherServices.deleteFresher(fresherId);

        } catch (NumberFormatException ex) {
            Logger.getLogger(DeleteFresherController.class.getName()).log(Level.SEVERE, "Exception at DeleteFresherController");
        }
        response.sendRedirect(FRESHER_CONTROLLER);
    }
}

package com.group.FresherManagement.controller.fresher;

import com.group.FresherManagement.services.FresherServices;
import com.group.FresherManagement.services.TestServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteFresherController", urlPatterns = "/DeleteFresher")
public class DeleteFresherController extends HttpServlet {
    private FresherServices fresherServices;
    private TestServices testServices;
    private static final String FRESHER_CONTROLLER = "FresherController";

    @Override
    public void init() throws ServletException {
        fresherServices = new FresherServices();
        testServices = new TestServices();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Method doGet doesn't support");
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int fresherId = Integer.parseInt(request.getParameter("txtId"));
            testServices.deleteAllTestFresherOfFresher(fresherId);
            fresherServices.deleteFresher(fresherId);
        } catch (NumberFormatException ex) {
            Logger.getLogger(DeleteFresherController.class.getName()).log(Level.SEVERE, "Exception at DeleteFresherController");
        }
        response.sendRedirect(FRESHER_CONTROLLER);
    }
}

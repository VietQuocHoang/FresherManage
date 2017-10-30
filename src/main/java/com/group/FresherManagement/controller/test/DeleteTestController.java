package com.group.FresherManagement.controller.test;

import com.group.FresherManagement.services.TestServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteTestController", urlPatterns = "/DeleteTest")
public class DeleteTestController extends HttpServlet {
    private static final String TEST_CONTROLLER = "TestController";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestServices testServices = new TestServices();
        try {
            int testId = Integer.parseInt(request.getParameter("txtId"));
            testServices.deleteTest(testId);
        } catch (NumberFormatException ex) {
            Logger.getLogger(DeleteTestController.class.getName()).log(Level.SEVERE, "Exception at DeleteTestController", ex);
        }
        response.sendRedirect(TEST_CONTROLLER);
    }
}

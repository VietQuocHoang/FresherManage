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
    private TestServices testServices;
    private static final String TEST_CONTROLLER = "TestController";

    @Override
    public void init() throws ServletException {
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
            int testId = Integer.parseInt(request.getParameter("txtId"));
            testServices.deleteAllTestFresherOfTest(testId);
            testServices.deleteTest(testId);
        } catch (NumberFormatException ex) {
            Logger.getLogger(DeleteTestController.class.getName()).log(Level.SEVERE, "Exception at DeleteTestController", ex);
        }
        response.sendRedirect(TEST_CONTROLLER);
    }
}

package com.group.FresherManagement.controller.test_fresher;

import com.group.FresherManagement.entities.TestFresher;
import com.group.FresherManagement.services.TestServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "TestFresherController", urlPatterns = "/TestFresherController")
public class TestFresherController extends HttpServlet {
    private static final String TEST_FRESHER_DETAIL = "test-fresher-detail.jsp";

    private TestServices testServices;
    //    private static final String
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int testFresherId = Integer.parseInt(request.getParameter("txtTestFresherId"));
//            int state = Integer.parseInt(request.getParameter("btnAction"));
            TestFresher test_fresher = testServices.findTestFresherById(testFresherId);
//            testServices.saveTestFresher(test_fresher, state);
            request.setAttribute("test_fresher", test_fresher);
            request.getRequestDispatcher(TEST_FRESHER_DETAIL).forward(request, response);
        } catch (NumberFormatException ex) {
            Logger.getLogger(MarkController.class.getName()).log(Level.SEVERE, "Exception at MarkController" + ex);
        }
    }
}

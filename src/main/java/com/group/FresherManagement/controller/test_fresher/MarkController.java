package com.group.FresherManagement.controller.test_fresher;

import com.group.FresherManagement.entities.Test_Fresher;
import com.group.FresherManagement.services.TestServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "MarkController", urlPatterns = "/MarkController")
public class MarkController extends HttpServlet {
    private static final String TEST_FRESHER_DETAIL = "test-fresher-detail.jsp";

    //    private static final String
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestServices testServices = new TestServices();
        try {
            int testFresherId = Integer.parseInt(request.getParameter("txtId"));
            int state = Integer.parseInt(request.getParameter("btnAction"));
            float mark = Float.parseFloat(request.getParameter("txtMark"));
            Test_Fresher test_fresher = testServices.findTestFresherById(testFresherId);
            test_fresher.setMark(mark);
            testServices.saveTestFresher(test_fresher, state);
            request.setAttribute("test_fresher", test_fresher);
            request.getRequestDispatcher(TEST_FRESHER_DETAIL).forward(request, response);
        } catch (NumberFormatException ex) {
            Logger.getLogger(MarkController.class.getName()).log(Level.SEVERE, "Exception at MarkController" + ex);
        }
    }
}

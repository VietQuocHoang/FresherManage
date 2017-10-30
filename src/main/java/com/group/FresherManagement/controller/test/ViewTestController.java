package com.group.FresherManagement.controller.test;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Fresher;
import com.group.FresherManagement.entities.Test;
import com.group.FresherManagement.entities.Test_Fresher;
import com.group.FresherManagement.services.CoursesServices;
import com.group.FresherManagement.services.TestServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ViewTestController", urlPatterns = "/viewTest")
public class ViewTestController extends HttpServlet {
    private static final String TEST_DETAIL = "test-detail.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestServices testServices = new TestServices();
        CoursesServices coursesServices = new CoursesServices();
        String testId = request.getParameter("id");
        try {
            int id = Integer.parseInt(testId);
            Test test = testServices.findById(id);
            List<Courses> listCourse = coursesServices.findAllCourses();
            Courses courses = test.getCoursesSubject().getCourses();
            List<Fresher> notIncludedFresherList = coursesServices.findFresherNotIncludedInCourse(courses);
            List<Test_Fresher> listTestFresherNotMark = testServices.findAllTestFresherOfTestNotMark(test);
            List<Test_Fresher> listTestFresherMarked = testServices.findAllTestFresherOfTestMarked(test);
            request.setAttribute("testObj", test);
            request.setAttribute("listCourse", listCourse);
//            request.setAttribute("course", courses);
            request.setAttribute("listTestFresherNotMark", listTestFresherNotMark);
            request.setAttribute("listTestFresherMarked", listTestFresherMarked);
            request.setAttribute("notIncludedFresher", notIncludedFresherList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(TEST_DETAIL);
            requestDispatcher.forward(request, response);
        } catch (NumberFormatException ex) {
            Logger.getLogger(ViewTestController.class.getName()).log(Level.SEVERE, "Exception at ViewTestController", ex);
        }
    }
}

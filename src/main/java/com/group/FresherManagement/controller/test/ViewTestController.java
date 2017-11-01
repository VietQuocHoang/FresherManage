package com.group.FresherManagement.controller.test;

import com.group.FresherManagement.entities.*;
import com.group.FresherManagement.services.CourseSubjectServices;
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
    private TestServices testServices;
    private CoursesServices coursesServices;
    private CourseSubjectServices courseSubjectServices;

    @Override
    public void init() throws ServletException {
        testServices = new TestServices();
        coursesServices = new CoursesServices();
        courseSubjectServices = new CourseSubjectServices();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Method doPost doesn't support");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String testId = request.getParameter("id");
        try {
            int id = Integer.parseInt(testId);
            Test test = testServices.findById(id);
            List<Courses> listCourse = coursesServices.findAllCourses();
            Courses courses = test.getCoursesSubject().getCourses();
            List<Fresher> notIncludedFresherList = coursesServices.findFresherNotIncludedInCourse(courses);
            List<TestFresher> listTestFresherNotMark = testServices.findAllTestFresherOfTestNotMark(test);
            List<TestFresher> listTestFresherMarked = testServices.findAllTestFresherOfTestMarked(test);
            List<CoursesSubject> listCoursesSubject = courseSubjectServices.findAll();
            request.setAttribute("testObj", test);
            request.setAttribute("listCourse", listCourse);
            request.setAttribute("listCourseSubject", listCoursesSubject);
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

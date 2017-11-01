package com.group.FresherManagement.controller.test;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.CoursesSubject;
import com.group.FresherManagement.entities.Test;
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

@WebServlet(name = "TestController", urlPatterns = "/TestController")
public class TestController extends HttpServlet {
    private static final String TEST_PAGE = "test-page.jsp";

    private TestServices testServices;
    private CourseSubjectServices courseSubjectServices;
    private CoursesServices coursesServices;

    @Override
    public void init() throws ServletException {
        testServices = new TestServices();
        courseSubjectServices = new CourseSubjectServices();
        coursesServices = new CoursesServices();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Method doPost doesn't support");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CoursesSubject> listCourseSubject = courseSubjectServices.findAll();
        List<Test> listTest = testServices.findAll();
        List<Courses> listCourse = coursesServices.findAllCourses();
        request.setAttribute("listTest", listTest);
        request.setAttribute("listCourseSubject", listCourseSubject);
        request.setAttribute("listCourse", listCourse);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(TEST_PAGE);
        requestDispatcher.forward(request, response);
    }
}

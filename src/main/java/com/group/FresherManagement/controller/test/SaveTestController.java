package com.group.FresherManagement.controller.test;

import com.group.FresherManagement.entities.CoursesSubject;
import com.group.FresherManagement.entities.Test;
import com.group.FresherManagement.services.CourseSubjectServices;
import com.group.FresherManagement.services.FresherServices;
import com.group.FresherManagement.services.TestFresherServices;
import com.group.FresherManagement.services.TestServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SaveTestController", urlPatterns = "/SaveTest")
public class SaveTestController extends HttpServlet {
    private static final String TEST_CONTROLLER = "TestController";

    private TestServices testServices;

    @Override
    public void init() throws ServletException {
        testServices = new TestServices();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processServlet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void processServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CourseSubjectServices courseSubjectServices = new CourseSubjectServices();
        String testName = request.getParameter("txtTestName");
        String question = request.getParameter("txtQuestion");
        String courseSubjectId = request.getParameter("selectCourseSubject");
        String btnAction = request.getParameter("btnAction");
        try {
            int course_subject_id = Integer.parseInt(courseSubjectId);
            int state = Integer.parseInt(btnAction);
            CoursesSubject courses_subject = courseSubjectServices.findById(course_subject_id);
            if (courses_subject != null) {
                Test test = new Test();
                if (state == 2) {
                    int testId = Integer.parseInt(request.getParameter("txtId"));
                    test.setId(testId);
                }
                test.setName(testName);
                test.setQuestions(question);
                test.setCoursesSubject(courses_subject);
                testServices.saveTest(test, state);
                testServices.createTestFresher(test, state);
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(SaveTestController.class.getName()).log(Level.SEVERE, "Exception at SaveTestController", ex);
        }
        response.sendRedirect(TEST_CONTROLLER);
    }
}

package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.CourseDAO;
import com.group.FresherManagement.dao.CoursesFresherDAO;
import com.group.FresherManagement.dao.CoursesSubjectDAO;
import com.group.FresherManagement.dao.TestFresherDAO;
import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Courses_Fresher;
import com.group.FresherManagement.entities.Courses_Subject;
import com.group.FresherManagement.entities.Test_Fresher;

public class TestFresherServices {
    private CoursesSubjectDAO coursesSubjectDAO;
    private CourseDAO courseDAO;
    private TestFresherDAO testFresherDAO;
    private CoursesFresherDAO coursesFresherDAO;
    private TestServices testServices;

    public TestFresherServices() {
        this.testFresherDAO = new TestFresherDAO(Test_Fresher.class);
        this.coursesSubjectDAO = new CoursesSubjectDAO(Courses_Subject.class);
        this.testFresherDAO = new TestFresherDAO(Test_Fresher.class);
        this.courseDAO = new CourseDAO(Courses.class);
        this.coursesFresherDAO = new CoursesFresherDAO(Courses_Fresher.class);
        this.testServices = new TestServices();
    }
//
//
//    public void saveTestFresher(Test_Fresher test_fresher, int state) {
//        if (state == 1) {
//            testFresherDAO.insert(test_fresher);
//        } else if (state == 2) {
//            Date today = new Date(System.currentTimeMillis());
//            java.sql.Date date = new java.sql.Date(today.getTime());
//            testFresherDAO.update(test_fresher, date);
//        }
//    }
//
//    public List<Test_Fresher> findAllTestFresher() {
//        return testFresherDAO.findAll();
//    }
//
//    public void deleteTestFresher(int id) {
//        testFresherDAO.delete(id);
//    }
//
//
//    public Test_Fresher findByTestFresherId(int id) {
//        return testFresherDAO.findById(id);
//    }
//
//    public void createTestFresher(Test test, int state){
//        Courses courses = testServices.findCourseOfTest(test);
//        List<Courses_Fresher> list = coursesFresherDAO.findAllByCourse(courses);
//        for (Courses_Fresher courseFresher: list) {
//            Test_Fresher test_fresher = new Test_Fresher();
//            test_fresher.setTest(test);
//            test_fresher.setFresher(courseFresher.getFresher());
//            saveTestFresher(test_fresher, state);
//        }
//    }

}

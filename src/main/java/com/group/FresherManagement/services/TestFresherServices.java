package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.CourseDAO;
import com.group.FresherManagement.dao.CoursesFresherDAO;
import com.group.FresherManagement.dao.CoursesSubjectDAO;
import com.group.FresherManagement.dao.TestFresherDAO;
import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.CoursesFresher;
import com.group.FresherManagement.entities.CoursesSubject;
import com.group.FresherManagement.entities.TestFresher;

public class TestFresherServices {
    private CoursesSubjectDAO coursesSubjectDAO;
    private CourseDAO courseDAO;
    private TestFresherDAO testFresherDAO;
    private CoursesFresherDAO coursesFresherDAO;
    private TestServices testServices;

    public TestFresherServices() {
        this.testFresherDAO = new TestFresherDAO(TestFresher.class);
        this.coursesSubjectDAO = new CoursesSubjectDAO(CoursesSubject.class);
        this.testFresherDAO = new TestFresherDAO(TestFresher.class);
        this.courseDAO = new CourseDAO(Courses.class);
        this.coursesFresherDAO = new CoursesFresherDAO(CoursesFresher.class);
        this.testServices = new TestServices();
    }
//
//
//    public void saveTestFresher(TestFresher test_fresher, int state) {
//        if (state == 1) {
//            testFresherDAO.insert(test_fresher);
//        } else if (state == 2) {
//            Date today = new Date(System.currentTimeMillis());
//            java.sql.Date date = new java.sql.Date(today.getTime());
//            testFresherDAO.update(test_fresher, date);
//        }
//    }
//
//    public List<TestFresher> findAllTestFresher() {
//        return testFresherDAO.findAll();
//    }
//
//    public void deleteTestFresher(int id) {
//        testFresherDAO.delete(id);
//    }
//
//
//    public TestFresher findByTestFresherId(int id) {
//        return testFresherDAO.findById(id);
//    }
//
//    public void createTestFresher(Test test, int state){
//        Courses courses = testServices.findCourseOfTest(test);
//        List<CoursesFresher> list = coursesFresherDAO.findAllByCourse(courses);
//        for (CoursesFresher courseFresher: list) {
//            TestFresher test_fresher = new TestFresher();
//            test_fresher.setTest(test);
//            test_fresher.setFresher(courseFresher.getFresher());
//            saveTestFresher(test_fresher, state);
//        }
//    }

}

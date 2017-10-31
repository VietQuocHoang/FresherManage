package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.*;
import com.group.FresherManagement.entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestServices {
    private CoursesSubjectDAO coursesSubjectDAO;
    private CourseDAO courseDAO;
    private TestDAO testDAO;
    private TestFresherDAO testFresherDAO;
    private CoursesFresherDAO coursesFresherDAO;

    public TestServices() {
        this.coursesSubjectDAO = new CoursesSubjectDAO(CoursesSubject.class);
        this.testDAO = new TestDAO(Test.class);
        this.testFresherDAO = new TestFresherDAO(TestFresher.class);
        this.courseDAO = new CourseDAO(Courses.class);
        this.testFresherDAO = new TestFresherDAO(TestFresher.class);
        this.coursesFresherDAO = new CoursesFresherDAO(CoursesFresher.class);
    }

    public List<Test> findAll() {
        return testDAO.findAll();
    }

    public Test findById(int id) {
        return testDAO.findById(id);
    }

    public void deleteTest(int id) {
        testDAO.delete(id);
    }

    public void saveTest(Test test, int state) {
        if (state == 1) {
            testDAO.insert(test);
        } else if (state == 2) {
            testDAO.update(test);
        }
    }

    public Courses findCourseOfTest(Test test) {
        CoursesSubject courses_subject = test.getCoursesSubject();
        int id = courses_subject.getCourses().getId();
        return courseDAO.findById(id);
    }


    public void saveTestFresher(TestFresher test_fresher, int state) {
        if (state == 1) {
            testFresherDAO.insert(test_fresher);
        } else if (state == 2) {
            Date today = new Date(System.currentTimeMillis());
            java.sql.Date date = new java.sql.Date(today.getTime());
            testFresherDAO.update(test_fresher, date);
        }
    }

    public List<TestFresher> findAllTestFresher() {
        return testFresherDAO.findAll();
    }

    public void deleteTestFresher(int id) {
        testFresherDAO.delete(id);
    }


    public TestFresher findTestFresherById(int id) {
        return testFresherDAO.findById(id);
    }

    public void createTestFresher(Test test, int state) {
        Courses courses = findCourseOfTest(test);
        List<CoursesFresher> list = coursesFresherDAO.findAllByCourse(courses);
        for (CoursesFresher courseFresher : list) {
            TestFresher test_fresher = new TestFresher();
            test_fresher.setTest(test);
            test_fresher.setFresher(courseFresher.getFresher());
            if (state == 1) {
                test_fresher.setMark(11);
                saveTestFresher(test_fresher, state);
            }
        }
    }

    public List<TestFresher> findAllTestFresherOfTestNotMark(Test test) {
        List<TestFresher> list = new ArrayList<TestFresher>();
        List<TestFresher> currList = findAllTestFresher();
        for (TestFresher testFresher : currList) {
            if (testFresher.getTest().getId() == test.getId()) {
                if (testFresher.getMark() == 11.00) {
                    list.add(testFresher);
                }
            }
        }
        return list;
    }

    public List<TestFresher> findAllTestFresherOfTestMarked(Test test) {
        List<TestFresher> list = new ArrayList<TestFresher>();
        List<TestFresher> currList = findAllTestFresher();
        for (TestFresher testFresher : currList) {
            if (testFresher.getTest().getId() == test.getId()) {
                if (testFresher.getMark() != 11.00) {
                    list.add(testFresher);
                }
            }
        }
        return list;
    }

    public void deleteAllTestFresherOfFresher(int fresherId) {
        List<TestFresher> currList = findAllTestFresher();
        for (TestFresher test_fresher : currList) {
            if (test_fresher.getFresher().getId() == fresherId) {
                deleteTestFresher(test_fresher.getId());
            }
        }
    }

    public void deleteAllTestFresherOfTest(int testId) {
        List<TestFresher> list = findAllTestFresher();
        for (TestFresher testFresher : list) {
            if (testFresher.getTest().getId() == testId) {
                deleteTestFresher(testFresher.getId());
            }
        }
    }

}

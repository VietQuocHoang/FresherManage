package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.*;
import com.group.FresherManagement.entities.*;

import java.util.ArrayList;
import java.util.List;

public class CoursesServices {
    private CoursesSubjectDAO coursesSubjectDAO;
    private CourseDAO courseDAO;
    private SubjectDAO subjectDAO;
    private FresherDAO fresherDAO;
    private CoursesFresherDAO coursesFresherDAO;
    private TestFresherDAO testFresherDAO;

    public CoursesServices() {
        coursesSubjectDAO = new CoursesSubjectDAO(CoursesSubject.class);
        courseDAO = new CourseDAO(Courses.class);
        subjectDAO = new SubjectDAO(Subject.class);
        fresherDAO = new FresherDAO(Fresher.class);
        coursesFresherDAO = new CoursesFresherDAO(CoursesFresher.class);
        testFresherDAO = new TestFresherDAO(TestFresher.class);
    }

    public List<Courses> findAllCourses() {
        return courseDAO.findAll();
    }

    public void deleteCourses(int id) {
        courseDAO.delete(id);
    }

    public void saveCourse(Courses courses, int state) {
        if (state == 1) {
            courseDAO.insert(courses);
        } else if (state == 2) {
            courseDAO.updateCourses(courses);
        } else {
            return;
        }
    }

    public Courses findCourseById(int id) {
        return courseDAO.findById(id);
    }

    public void addSubjectToCourse(CoursesSubject courses_subject) {
        coursesSubjectDAO.insert(courses_subject);
    }

    public void addFresherToCourse(CoursesFresher courses_fresher) {
        coursesFresherDAO.insert(courses_fresher);
    }

    public List<Subject> findSubjectNotIncludedInCourse(Courses courses) {
        List<CoursesSubject> list = courses.getCoursesSubjectList();
        if (list == null || list.isEmpty()) {
            return subjectDAO.findAll();
        } else {
            List<Integer> includedSubjectList = new ArrayList();
            for (CoursesSubject c : list) {
                includedSubjectList.add(c.getSubject().getId());
            }
            List<Subject> notIncludedSubjectList = subjectDAO.findByNotSubjectId(includedSubjectList);
            return notIncludedSubjectList;
        }
    }

    public void removeSubjectFromCourses(CoursesSubject coursesSubject) {
        coursesSubjectDAO.delete(coursesSubject.getId());
    }

    public void removeFresherFromCourses(CoursesFresher courses_fresher) {
        coursesFresherDAO.delete(courses_fresher.getId());
    }

    public List<Fresher> findFresherNotIncludedInCourse(Courses courses) {
        List<CoursesFresher> list = courses.getCoursesFresherList();
        if (list == null || list.isEmpty()) {
            return fresherDAO.findAll();
        } else {
            List<Integer> includedFresherList = new ArrayList();
            for (CoursesFresher c : list) {
                includedFresherList.add(c.getFresher().getId());
            }
            List<Fresher> notIncludedFresherList = fresherDAO.findByNotFresherId(includedFresherList);
            return notIncludedFresherList;
        }
    }

    public Subject findSubjectById(int id) {
        return subjectDAO.findById(id);
    }

    public CoursesSubject findCourseSubjectById(int id) {
        return coursesSubjectDAO.findById(id);
    }
}

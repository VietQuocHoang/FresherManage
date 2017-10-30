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
        coursesSubjectDAO = new CoursesSubjectDAO(Courses_Subject.class);
        courseDAO = new CourseDAO(Courses.class);
        subjectDAO = new SubjectDAO(Subject.class);
        fresherDAO = new FresherDAO(Fresher.class);
        coursesFresherDAO = new CoursesFresherDAO(Courses_Fresher.class);
        testFresherDAO = new TestFresherDAO(Test_Fresher.class);
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

        }
    }

    public Courses findCourseById(int id) {
        return courseDAO.findById(id);
    }

    public void addSubjectToCourse(Courses_Subject courses_subject) {
        coursesSubjectDAO.insert(courses_subject);
    }

    public void addFresherToCourse(Courses_Fresher courses_fresher) {
        coursesFresherDAO.insert(courses_fresher);
    }

    public List<Subject> findSubjectNotIncludedInCourse(Courses courses) {
        List<Courses_Subject> list = courses.getCoursesSubjectList();
        if (list == null || list.isEmpty()) {
            return subjectDAO.findAll();
        } else {
            List<Integer> includedSubjectList = new ArrayList();
            for (Courses_Subject c : list) {
                includedSubjectList.add(c.getSubject().getId());
            }
            List<Subject> notIncludedSubjectList = subjectDAO.findByNotSubjectId(includedSubjectList);
            return notIncludedSubjectList;
        }
    }

    public void removeSubjectFromCourses(Courses_Subject coursesSubject) {
        coursesSubjectDAO.delete(coursesSubject.getId());
    }

    public void removeFresherFromCourses(Courses_Fresher courses_fresher) {
        coursesFresherDAO.delete(courses_fresher.getId());
    }

    public List<Fresher> findFresherNotIncludedInCourse(Courses courses) {
        List<Courses_Fresher> list = courses.getCoursesFresherList();
        if (list == null || list.isEmpty()) {
            return fresherDAO.findAll();
        } else {
            List<Integer> includedFresherList = new ArrayList();
            for (Courses_Fresher c : list) {
                includedFresherList.add(c.getFresher().getId());
            }
            List<Fresher> notIncludedFresherList = fresherDAO.findByNotFresherId(includedFresherList);
            return notIncludedFresherList;
        }
    }
}

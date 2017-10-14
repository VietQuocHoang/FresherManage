package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.CourseDAO;
import com.group.FresherManagement.dao.CoursesSubjectDAO;
import com.group.FresherManagement.dao.SubjectDAO;
import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Courses_Subject;
import com.group.FresherManagement.entities.Subject;

import java.util.ArrayList;
import java.util.List;

public class CoursesServices {
    private CoursesSubjectDAO coursesSubjectDAO;
    private CourseDAO courseDAO;
    private SubjectDAO subjectDAO;

    public CoursesServices() {
        coursesSubjectDAO = new CoursesSubjectDAO(Courses_Subject.class);
        courseDAO = new CourseDAO(Courses.class);
        subjectDAO = new SubjectDAO(Subject.class);
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
}

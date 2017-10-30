package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.CoursesSubjectDAO;
import com.group.FresherManagement.entities.Courses_Subject;

import java.util.List;

public class CourseSubjectServices {
    private CoursesSubjectDAO coursesSubjectDAO;

    public CourseSubjectServices() {
        this.coursesSubjectDAO = new CoursesSubjectDAO(Courses_Subject.class);
    }

    public List<Courses_Subject> findAll() {
        return coursesSubjectDAO.findAll();
    }

    public Courses_Subject findById(int id) {
        return coursesSubjectDAO.findById(id);
    }
}

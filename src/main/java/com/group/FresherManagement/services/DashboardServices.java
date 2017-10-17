package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.CourseDAO;
import com.group.FresherManagement.dao.SubjectDAO;
import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Subject;

public class DashboardServices {
    private CourseDAO courseDAO;
    private SubjectDAO subjectDAO;
    //TODO Add Fresher here later


    public DashboardServices() {
        courseDAO = new CourseDAO(Courses.class);
        subjectDAO = new SubjectDAO(Subject.class);
    }

    public long getNumOfCourses() {
        return courseDAO.count();
    }

    public long getNumOfSubject() {
        return subjectDAO.count();
    }
}

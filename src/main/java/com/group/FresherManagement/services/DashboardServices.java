package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.CourseDAO;
import com.group.FresherManagement.dao.FresherDAO;
import com.group.FresherManagement.dao.SubjectDAO;
import com.group.FresherManagement.dao.TestDAO;
import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Fresher;
import com.group.FresherManagement.entities.Subject;
import com.group.FresherManagement.entities.Test;

public class DashboardServices {
    private CourseDAO courseDAO;
    private SubjectDAO subjectDAO;
    private FresherDAO fresherDAO;
    private TestDAO testDAO;
    //TODO Add Fresher here later


    public DashboardServices() {
        courseDAO = new CourseDAO(Courses.class);
        subjectDAO = new SubjectDAO(Subject.class);
        fresherDAO = new FresherDAO(Fresher.class);
        testDAO = new TestDAO(Test.class);
    }

    public long getNumOfCourses() {
        return courseDAO.count();
    }

    public long getNumOfSubject() {
        return subjectDAO.count();
    }

    public long getNumOfFresher(){ return fresherDAO.count();}
    public long getNumOfTest(){ return testDAO.count();}
}

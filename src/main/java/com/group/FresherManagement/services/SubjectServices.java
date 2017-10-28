package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.CoursesSubjectDAO;
import com.group.FresherManagement.dao.SubjectDAO;
import com.group.FresherManagement.entities.Courses_Subject;
import com.group.FresherManagement.entities.Subject;

import java.util.List;

public class SubjectServices {
    private CoursesSubjectDAO coursesSubjectDAO;
    private SubjectDAO subjectDAO;


    public SubjectServices() {
        coursesSubjectDAO = new CoursesSubjectDAO(Courses_Subject.class);
        subjectDAO = new SubjectDAO(Subject.class);
    }

    public void saveSubject(Subject subject, int state) {
        if (state == 1) {
            subjectDAO.insert(subject);
        } else if (state == 2) {
            subjectDAO.update(subject);
        } else {
            return;
        }
    }

    public List<Subject> findAllSubject() {
        return subjectDAO.findAll();
    }

    public Subject findSubjectById(int id) {
        return subjectDAO.findById(id);
    }

    public void delete(int id) {
        subjectDAO.delete(id);
    }

    public List<Courses_Subject> getEquivalentCourses(Subject subject) {
        return coursesSubjectDAO.findBySubjectId(subject);
    }

    public boolean checkAcronymExisted(String acronym) {
        return subjectDAO.findByAcronym(acronym) != null;
    }
}

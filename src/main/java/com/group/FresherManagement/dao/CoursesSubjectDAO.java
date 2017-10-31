package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.CoursesSubject;
import com.group.FresherManagement.entities.Subject;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CoursesSubjectDAO extends GenericDAO<CoursesSubject> {
    public CoursesSubjectDAO(Class<CoursesSubject> courses_subjectClass) {
        super(courses_subjectClass);
    }

    public List<CoursesSubject> findBySubjectId(Subject subject) {
        EntityManager entityManager = getEntityManager();
        List<CoursesSubject> list = new ArrayList<CoursesSubject>();
        try {
            entityManager.getTransaction().begin();
            list = entityManager.createQuery("from CoursesSubject c where c.subject =:subject")
                    .setParameter("subject", subject)
                    .getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return null;
        } finally {
            entityManager.close();
        }
        return list;
    }

    public List<CoursesSubject> findByCourseId(Courses courses) {
        EntityManager entityManager = getEntityManager();
        List<CoursesSubject> list = new ArrayList<CoursesSubject>();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("from CoursesSubject c where c.courses = :course").setParameter("course", courses).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return null;
        } finally {
            entityManager.close();
        }
        return list;
    }

}

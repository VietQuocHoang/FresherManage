package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Courses_Subject;
import com.group.FresherManagement.entities.Subject;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class CoursesSubjectDAO extends GenericDAO<Courses_Subject> {
    public CoursesSubjectDAO(Class<Courses_Subject> courses_subjectClass) {
        super(courses_subjectClass);
    }

    public List<Courses_Subject> findBySubjectId(Subject subject) {
        EntityManager entityManager = getEntityManager();
        List<Courses_Subject> list = new ArrayList<Courses_Subject>();
        try {
            entityManager.getTransaction().begin();
            list = entityManager.createQuery("from Courses_Subject c where c.subject =:subject")
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

    public List<Courses_Subject> findByCourseId(Courses courses) {
        EntityManager entityManager = getEntityManager();
        List<Courses_Subject> list = new ArrayList<Courses_Subject>();
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery("from Courses_Subject c where c.courses = :course").setParameter("course", courses).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return null;
        } finally {
            entityManager.close();
        }
        return list;
    }

}

package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.CoursesFresher;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoursesFresherDAO extends GenericDAO<CoursesFresher> {

    public CoursesFresherDAO(Class<CoursesFresher> courses_fresherClass) {
        super(courses_fresherClass);
    }

    public List<CoursesFresher> findAllByCourse(Courses course) {
        EntityManager entityManager = getEntityManager();
        List<CoursesFresher> list = new ArrayList<CoursesFresher>();
        try {
            entityManager.getTransaction().begin();
            list = entityManager.createQuery("from CoursesFresher c where c.courses =:course").setParameter("course", course).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(CoursesFresherDAO.class.getName()).log(Level.SEVERE, "Exception at findFresherOfCourse in CoursesFresherDAO", ex);
        }
        entityManager.close();
        return list;
    }

}

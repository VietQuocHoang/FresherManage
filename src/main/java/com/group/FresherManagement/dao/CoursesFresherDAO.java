package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Courses;
import com.group.FresherManagement.entities.Courses_Fresher;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoursesFresherDAO extends GenericDAO<Courses_Fresher> {

    public CoursesFresherDAO(Class<Courses_Fresher> courses_fresherClass) {
        super(courses_fresherClass);
    }

    public List<Courses_Fresher> findAllByCourse(Courses course) {
        EntityManager entityManager = getEntityManager();
        List<Courses_Fresher> list = new ArrayList<Courses_Fresher>();
        try {
            entityManager.getTransaction().begin();
            list = entityManager.createQuery("from Courses_Fresher c where c.courses =:course").setParameter("course", course).getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(CoursesFresherDAO.class.getName()).log(Level.SEVERE, "Exception at findFresherOfCourse in CoursesFresherDAO", ex);
        }
        entityManager.close();
        return list;
    }

}

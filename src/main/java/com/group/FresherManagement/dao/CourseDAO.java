package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Courses;

import javax.persistence.EntityManager;

public class CourseDAO extends GenericDAO<Courses> {


    public CourseDAO(Class<Courses> coursesClass) {
        super(coursesClass);
    }

    public void updateCourses(Courses courses) {
        Courses curr = findById(courses.getId());
        EntityManager entityManager = getEntityManager();
        courses.setId(curr.getId());
        entityManager.getTransaction().begin();
        entityManager.merge(courses);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}

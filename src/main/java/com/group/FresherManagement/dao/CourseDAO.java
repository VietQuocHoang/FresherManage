package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Courses;

import javax.persistence.EntityManager;

public class CourseDAO extends GenericDAO<Courses> {


    public CourseDAO(Class<Courses> coursesClass) {
        super(coursesClass);
    }

    public void updateCourses(Courses courses) {
        EntityManager em = getEntityManager();
        Courses curr = em.find(Courses.class, courses.getId());
        curr.setAvailable(courses.isAvailable());
        curr.setCourseName(courses.getCourseName());
        curr.setCourseDescription(courses.getCourseDescription());
        curr.setEndDate(courses.getEndDate());
        curr.setStartDate(courses.getStartDate());
        em.getTransaction().begin();
        em.getTransaction().commit();
    }

}

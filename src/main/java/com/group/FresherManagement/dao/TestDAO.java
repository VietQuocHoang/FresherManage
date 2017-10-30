package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Test;

import javax.persistence.EntityManager;

public class TestDAO extends GenericDAO<Test> {

    public TestDAO() {
    }

    public TestDAO(Class<Test> testClass) {
        super(testClass);
    }

    public void update(Test test) {
        EntityManager entityManager = getEntityManager();
        Test currTest = entityManager.find(Test.class, test.getId());
        entityManager.getTransaction().begin();
        currTest.setName(test.getName());
        currTest.setQuestions(test.getQuestions());
        currTest.setCoursesSubject(test.getCoursesSubject());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.TestFresher;

import javax.persistence.EntityManager;
import java.sql.Date;

public class TestFresherDAO extends GenericDAO<TestFresher> {
    public TestFresherDAO() {
    }

    public TestFresherDAO(Class<TestFresher> test_fresherClass) {
        super(test_fresherClass);
    }


    public void update(TestFresher test_fresher, Date date) {
        EntityManager entityManager = getEntityManager();
        TestFresher currTestFresher = entityManager.find(TestFresher.class, test_fresher.getId());
        entityManager.getTransaction().begin();
        currTestFresher.setFresher(test_fresher.getFresher());
        currTestFresher.setTest(test_fresher.getTest());
        currTestFresher.setMarkDate(date);
        currTestFresher.setMark(test_fresher.getMark());
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}

package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Test_Fresher;

import javax.persistence.EntityManager;
import java.sql.Date;

public class TestFresherDAO extends GenericDAO<Test_Fresher> {
    public TestFresherDAO() {
    }

    public TestFresherDAO(Class<Test_Fresher> test_fresherClass) {
        super(test_fresherClass);
    }


    public void update(Test_Fresher test_fresher, Date date) {
        EntityManager entityManager = getEntityManager();
        Test_Fresher currTestFresher = entityManager.find(Test_Fresher.class, test_fresher.getId());
        entityManager.getTransaction().begin();
        currTestFresher.setFresher(test_fresher.getFresher());
        currTestFresher.setTest(test_fresher.getTest());
        currTestFresher.setMarkDate(date);
        currTestFresher.setMark(test_fresher.getMark());
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}

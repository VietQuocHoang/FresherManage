package com.group.FresherManagement.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMConfigs {
    private static EntityManager entityManager = createEntityManager();

    public static EntityManager createEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("fresherMng");
        return emf.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}

package com.group.FresherManagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class GenericDAO<T extends Object> {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fresherMng");
    private EntityManager entityManager;
    private Class<T> tClass;

    public GenericDAO() {
    }

    public GenericDAO(Class<T> tClass) {
        this.tClass = tClass;
    }

    public EntityManager getEntityManager() {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public List<T> findAll() {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        List<T> list = entityManager.createQuery("from " + tClass.getSimpleName(), tClass).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;
    }

    public void insert(T t) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(int id) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            T o = entityManager.find(tClass, id);
            entityManager.remove(o);
            entityManager.flush();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public T findById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(tClass, id);
    }

    public long count(){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        long result = entityManager.createQuery("SELECT COUNT(*) FROM " + tClass.getSimpleName(), Long.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }
}

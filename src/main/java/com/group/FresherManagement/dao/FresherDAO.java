package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Fresher;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FresherDAO extends GenericDAO<Fresher> {
    public FresherDAO(Class<Fresher> fresherClass) {
        super(fresherClass);
    }

    public FresherDAO() {
    }

    public boolean checkEmail(String email) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Fresher fresher = entityManager.createQuery("from Fresher f where f.email=:email", Fresher.class).setParameter("email", email).getSingleResult();
            if (fresher != null)
                return true;
        } catch (NoResultException ex) {
            Logger.getLogger(FresherDAO.class.getName()).log(Level.SEVERE, "Exception at checkEmail in FresherDAO", ex);
        }
        return false;
    }

    public void update(Fresher fresher) {
        EntityManager entityManager = getEntityManager();
        Fresher currFresher = entityManager.find(Fresher.class, fresher.getId());
        entityManager.getTransaction().begin();
        currFresher.setFirstName(fresher.getFirstName());
        currFresher.setLastName(fresher.getLastName());
        currFresher.setPhone(fresher.getPhone());
        currFresher.setDob(fresher.getDob());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Fresher> findByNotFresherId(List<Integer> includedFresherList) {
        EntityManager entityManager = getEntityManager();
        List<Fresher> list = new ArrayList();
        try {
            entityManager.getTransaction().begin();
            list = entityManager.createQuery("from Fresher f where f.id NOT IN :ids")
                    .setParameter("ids", includedFresherList)
                    .getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
        return list;
    }
}

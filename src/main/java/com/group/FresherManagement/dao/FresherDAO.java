package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Fresher;

import javax.persistence.EntityManager;
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

    public boolean checkEmail(String email){
        List<Fresher> listFresher = new FresherDAO().findAll();
        for (Fresher fresher: listFresher) {
            if(email.equals(fresher.getEmail())){
                return true;
            }
        }
        return false;
    }

    public void update(Fresher fresher){
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
}

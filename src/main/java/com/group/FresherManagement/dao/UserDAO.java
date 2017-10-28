package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends GenericDAO<User> {
    public UserDAO(Class<User> userClass) {
        super(userClass);
    }

    public boolean checkLogin(String username, String password) {
        boolean check = false;
        EntityManager entityManager = getEntityManager();
        try {
            User currUser = (User) entityManager.createQuery("from User u where u.username =:username and u.password =:password").setParameter("username", username).setParameter("password", password).getSingleResult();
            if (currUser != null) {
                check = true;
            }
        } catch (NoResultException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, "Error at checkLogin in UserDAO", ex);
        }finally {
            entityManager.close();
        }
        return check;
    }

}

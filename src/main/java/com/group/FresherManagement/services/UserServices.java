package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.UserDAO;
import com.group.FresherManagement.entities.User;

public class UserServices {
    private UserDAO userDAO;

    public UserServices() {
        this.userDAO = new UserDAO(User.class);
    }


    public boolean login(String username, String password){
        return userDAO.checkLogin(username, password);
    }
}

package com.group.FresherManagement.services;

import com.group.FresherManagement.dao.FresherDAO;
import com.group.FresherManagement.entities.Fresher;

import java.util.List;

public class FresherServices {
    private FresherDAO fresherDAO;

    public FresherServices() {
        this.fresherDAO = new FresherDAO(Fresher.class);
    }

    public List<Fresher> findAll(){return fresherDAO.findAll();}

    public void deleteFresher(int id){fresherDAO.delete(id);}

    public void saveFresher(Fresher fresher, int state){
        if(state == 1){
            fresherDAO.insert(fresher);
        }else if(state == 2){
            fresherDAO.update(fresher);
        }
    }

    public boolean checkFresherRegisterByEmail(String email){
        return fresherDAO.checkEmail(email);
    }

    public Fresher findById(int id){
        return fresherDAO.findById(id);
    }
}

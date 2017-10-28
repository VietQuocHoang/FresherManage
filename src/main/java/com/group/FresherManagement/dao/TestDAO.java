package com.group.FresherManagement.dao;

import com.group.FresherManagement.entities.Test;

public class TestDAO extends GenericDAO<Test> {

    public TestDAO() {
    }

    public TestDAO(Class<Test> testClass) {
        super(testClass);
    }
}

package com.grsu.pharmacy.dataAccess.dao;

import com.grsu.pharmacy.dataAccess.genericDao.GenericDaoImpl;
import com.grsu.pharmacy.model.entities.User;

public class UserDao extends GenericDaoImpl<User> {

    @Override
    public Class<User> getType() {
        return User.class;
    }

}

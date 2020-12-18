package com.grsu.pharmacy.model.dao.implementations;

import com.grsu.pharmacy.dataAccess.dao.UserDao;
import com.grsu.pharmacy.model.entities.User;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    private static UserDao userDao;
    private static User user;
    private static User newUser;

    @BeforeClass
    public static void setUp(){
        user = new User(1, "Ivan", "Ivanov");
        newUser = new User(2, "Maria", "Petrova");
        userDao = new UserDao();
    }

    @Test
    public void findById() {
        User actualUser = userDao.findById(1);
        assertEquals(user, actualUser);
    }

    @Test
    public void save() {
        userDao.save(newUser);
        assertEquals(newUser, userDao.findById(newUser.getId()));
        userDao.delete(newUser);
    }

    @Test
    public void update() {
        String initialFirstName = user.getFirstName();
        user.setFirstName("Aleksey");
        userDao.update(user);
        assertEquals(user, userDao.findById(user.getId()));

        user.setFirstName(initialFirstName);
        userDao.update(user);
    }

    @Test
    public void delete() {
        userDao.save(newUser);
        userDao.delete(newUser);
        assertEquals(null, userDao.findById(newUser.getId()));
    }
}
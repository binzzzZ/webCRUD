package com.service;

import com.dao.UserDao;
import com.entity.User;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/20 15:59
 * @Description
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public User login(String username, String password) {
        try {
            return userDao.findUser(username, password);
        } catch (Exception e) {
            return null;
        }
    }
}

package com.dao;

import com.entity.User;
import com.utils.JdbcTemplateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/20 15:55
 * @Description
 */
public class UserDao {
    //实例化JdbcTemplate
    private JdbcTemplate template = new JdbcTemplate(JdbcTemplateUtil.getDataSource());

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        System.out.println(userDao.template);
    }

    public User findUser(String username, String password) {
        String sql = "select * from user where username=? and password=?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
    }
}

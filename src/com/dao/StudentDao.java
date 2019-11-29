package com.dao;

import com.entity.Student;
import com.utils.JdbcTemplateUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @company
 * @create 2019/11/19 17:15
 * @Description
 */
public class StudentDao {
    //实例化JdbcTemplate
    private JdbcTemplate template = new JdbcTemplate(JdbcTemplateUtil.getDataSource());

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        System.out.println(studentDao.template);
    }

    /**
    * @Description: 查询所有数据
    * @author: admin
    * @param: []
    * @return: java.util.List<com.entity.Student>
    * @create: 2019/11/19 18:26
    */
    public List<Student> listAll() {
        String sql = "select * from student";
        return template.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    /**
    * @Description: 添加数据
    * @author: admin
    * @param: [student]
    * @return: void
    * @create: 2019/11/19 18:27
    */
    public void add(Student student) {
        String sql = "insert into student(name,age,address) values(?,?,?)";
        template.update(sql, student.getName(), student.getAge(), student.getAddress());
    }

    /**
    * @Description: 根据ID删除数据
    * @author: admin
    * @param: [id]
    * @return: void
    * @create: 2019/11/19 18:27
    */
    public void delete(Integer id) {
        String sql = "delete from student where id = ?";
        template.update(sql, id);
    }
}

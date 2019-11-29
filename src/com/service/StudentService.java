package com.service;

import com.dao.StudentDao;
import com.entity.Student;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @company
 * @create 2019/11/19 17:15
 * @Description
 */
public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public List<Student> listAll() {
        return studentDao.listAll();
    }

    public void add(Student student) {
        studentDao.add(student);
    }

    public void delete(Integer id) {
        studentDao.delete(id);
    }
}

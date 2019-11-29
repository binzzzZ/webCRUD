package com.controller;

import com.entity.Student;
import com.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author admin
 * @version 1.0.0
 * @company
 * @create 2019/11/19 17:48
 * @Description
 */

public class AddServlet extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String address = req.getParameter("address");

        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.valueOf(age));
        student.setAddress(address);

        studentService.add(student);

        resp.sendRedirect("/list");
    }
}

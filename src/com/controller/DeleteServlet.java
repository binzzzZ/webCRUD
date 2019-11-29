package com.controller;

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
 * @create 2019/11/19 17:42
 * @Description
 */
public class DeleteServlet extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        studentService.delete(Integer.valueOf(id));

        resp.sendRedirect("/list");
    }
}

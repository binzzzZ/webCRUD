package com.controller;

import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/20 16:12
 * @Description
 */
public class SuccessServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        User user = (User) req.getAttribute("user");
        PrintWriter out = resp.getWriter();
        out.print("<h1>欢迎您，登录成功" + user.getUsername() + "</h1>");
//        resp.sendRedirect("/list");

        resp.setHeader("refresh", "2;url=/list");
    }
}

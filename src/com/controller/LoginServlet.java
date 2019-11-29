package com.controller;

import com.entity.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author admin
 * @version 1.0.0
 * @company
 * @create 2019/11/19 17:15
 * @Description
 */
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User login = userService.login(username, password);

        if (login != null) {
            req.setAttribute("user", login);
            req.getRequestDispatcher(req.getContextPath() + "/success").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/fail.jsp");
        }
    }
}

package com.controller;

import com.entity.Student;
import com.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @company
 * @create 2019/11/19 17:23
 * @Description
 */
public class ListServlet extends HttpServlet {
    private StudentService studentService = new StudentService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        List<Student> list = studentService.listAll();

        PrintWriter out = resp.getWriter();
        out.append("<html>");
        out.append("<head>");
        out.append("<title>list</title>");
        out.append("</head>");
        out.append("<body>");

        out.append("<a href=\"/add.jsp\">添加</a>");

        out.append("<table>");
        out.append("<tr>");
        out.append("<td style=\"display: none;\">");
        out.append("id");
        out.append("</td>");
        out.append("<td>");
        out.append("姓名");
        out.append("</td>");
        out.append("<td>");
        out.append("年龄");
        out.append("</td>");
        out.append("<td>");
        out.append("地址");
        out.append("</td>");
        out.append("<td>");
        out.append("操作");
        out.append("</td>");
        out.append("</tr>");

        for (Student student : list) {
            out.append("<tr>");

            out.append("<td style=\"display: none;\">");
            out.append(student.getId().toString());
            out.append("</td>");
            out.append("<td>");
            out.append(student.getName());
            out.append("</td>");
            out.append("<td>");
            out.append(student.getAge().toString());
            out.append("</td>");
            out.append("<td>");
            out.append(student.getAddress());
            out.append("</td>");
            out.append("<td>");
            out.append("<a href=\"/delete?id=" + student.getId() + "\">删除</a>");
            out.append("</td>");

            out.append("</tr>");
        }

        out.append("</table>");
        out.append("</body>");
        out.append("</html>");
    }
}

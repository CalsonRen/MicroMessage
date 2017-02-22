package com.imooc.servlet;

import com.imooc.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by baidu on 17/1/21.
 */
public class InsertOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8"); // set character encoding
        String command = req.getParameter("command"); // get parameters from page
        String description = req.getParameter("description");
        String content = req.getParameter("content");

        MaintainService maintainService = new MaintainService();
        maintainService.insertOne(command, description, content);
        req.getRequestDispatcher("/WEB-INF/jsp/back/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

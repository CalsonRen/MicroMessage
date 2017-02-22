package com.imooc.servlet;

import com.imooc.service.ListService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by renjie on 17/1/6.
 *
 * function: page list control
 *
 */

public class ListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        // transfer value to the page.
        req.setAttribute("command", command);
        req.setAttribute("description", description);

        // query message list and transfer the value.(call service level)
        ListService listService = new ListService();
        req.setAttribute("messageList", listService.queryListMessage(command, description));
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

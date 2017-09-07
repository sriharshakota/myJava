package com.example.servlet;

import com.example.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountListServlet extends HttpServlet {

    @Override
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        AccountDAO dao = new AccountDAO();
        res.getWriter().write(dao.findAll().toJSONString());
    }



}

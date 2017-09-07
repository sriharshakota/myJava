package com.example.servlet;

import com.example.AccountDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by sriharshakota on 8/16/17.
 */

public class FindBalanceServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id")) ;
        try {
            AccountDAO dao = new AccountDAO();
            String obj = dao.find(id).toJSONString();
            res.getWriter().write(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

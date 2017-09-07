package com.example.servlet;

import com.example.AccountDAO;
import com.example.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Created by sriharshakota on 8/17/17.
 */

public class DeleteAccount extends HttpServlet {
    @Override
    public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id")) ;


        AccountDAO dao = new AccountDAO();


        try{
            dao.delete(id);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

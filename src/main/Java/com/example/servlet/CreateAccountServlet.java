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
 * Created by sriharshakota on 8/16/17.
 */

public class CreateAccountServlet extends HttpServlet {
    @Override
    public void service (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fName = req.getParameter("firstName");
        String lName = req.getParameter("lastName");
        String balance = req.getParameter("balance");
        int id = (int) (Math.random() * 10000);

        Account account = new Account ();
        account.setid(id);
        account.setfName(fName);
        account.setlName(lName);
        account.setbalance(Double.parseDouble(balance));

        AccountDAO dao = new AccountDAO();

        try{
            dao.create(account);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

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
 * Created by sriharshakota on 8/18/17.
 */

public class UpdateServlet extends HttpServlet{

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id")) ;
        String fName = req.getParameter("firstName");
        String lName = req.getParameter("lastName");
        String balance = req.getParameter("balance");

        Account account = new Account ();
        account.setid(id);
        account.setfName(fName);
        account.setlName(lName);
        account.setbalance(Double.parseDouble(balance));

        AccountDAO dao = new AccountDAO();
        try{
            dao.update(account);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }

    }

}

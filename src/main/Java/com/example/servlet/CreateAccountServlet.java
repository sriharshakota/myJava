package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres","postgres" , "postgres");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into bankAccounts VALUES(?,?,?,?)");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,fName);
            preparedStatement.setString(3,lName);
            preparedStatement.setDouble(4,Double.parseDouble(balance));
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        res.getWriter().write("Account Has been Created");
    }
}

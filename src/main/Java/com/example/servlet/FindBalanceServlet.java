package com.example.servlet;

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

@WebServlet(urlPatterns = ("/findbalance"))
public class FindBalanceServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id")) ;
        double balance = 0;
        boolean check = false;

        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres","postgres" , "postgres");


            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("select * from bankAccounts where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("id") == id) {
                     check = true;
                     balance = rs.getDouble("balance");
                }
            } else {
                check = false;
            }
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            if(check){
                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/accountsList");
                //dispatch your request to accountList.jsp
                dispatcher.forward(req, res);}
            else{
                res.getWriter().write( "Account with id "+ id + "Not found");
            }
    }
}

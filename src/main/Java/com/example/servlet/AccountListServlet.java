package com.example.servlet;

import com.example.model.Account;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountListServlet extends HttpServlet {

    @Override
        public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

            try {
                Class.forName("org.postgresql.Driver");
                Connection connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from bankAccounts");
                List<Account> accounts = new ArrayList<Account>();

                JSONArray jsonarray = new JSONArray();

                while (rs.next()) {
                    JSONObject account = new JSONObject();
                    account.put ( "id",rs.getString("id"));
                    account.put ( "firstName",rs.getString("fName"));
                    account.put ( "lastName",rs.getString("lName"));
                    account.put ( "balance",rs.getString("balance"));

                    jsonarray.add(account);
                }
                    res.getWriter().write(jsonarray.toJSONString());
//                add additional info to the same request
//                req.setAttribute("accList", accounts);
//                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/accountList.jsp");
//                dispatch your request to accountList.jsp
//                dispatcher.forward(req, res);


            }catch (Exception e){
                throw new RuntimeException(e);
            }
    }



}

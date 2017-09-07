package com.example;

import com.example.model.Account;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.sql.*;

public class AccountDAO {
    public Account create(Account account) throws Exception {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into bankAccounts values(?,?,?,?)");
        preparedStatement.setInt(1, account.getid());
        preparedStatement.setString(2, account.getFirstName());
        preparedStatement.setString(3, account.getLastName());
        preparedStatement.setDouble(4, account.getBalance());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        return account;
    }


    public Account update(Account account ){
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = null;
            PreparedStatement statement2 = null;
            preparedStatement = connection.prepareStatement("select * from bankAccounts where id = ?");
            preparedStatement.setInt(1,account.getid());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("id") == account.getid()) {

                    statement2 = connection.prepareStatement("UPDATE bankAccounts SET fname=?,lname=?,balance=? WHERE id = ?");
                    statement2.setString(1, account.getFirstName());
                    statement2.setString(2, account.getLastName());
                    statement2.setDouble(3, account.getBalance());
                    statement2.setInt(4, account.getid());
                    statement2.executeUpdate();
                }
            }
//            preparedStatement.executeUpdate();
            return account;

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }


    public JSONArray findAll(){
        JSONArray jsonArray = new JSONArray();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from bankAccounts");
            while (rs.next()){
                JSONObject account = new JSONObject();
                account.put("id",rs.getString("id"));
                account.put("firstName",rs.getString("fName"));
                account.put("lastName",rs.getString("lName"));
                account.put("balance",rs.getString("balance"));
                jsonArray.add(account);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jsonArray;
    }
    public  JSONObject find(int id) {

        JSONObject account = new JSONObject();
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement("select * from bankAccounts where id = ?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (rs.getInt("id") == id) {

                    account.put("id",rs.getString("id"));
                    account.put("firstName",rs.getString("fName"));
                    account.put("lastName",rs.getString("lName"));
                    account.put("balance",rs.getString("balance"));
                }
            }
            return account;
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void delete(int id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from bankAccounts where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
    }
}

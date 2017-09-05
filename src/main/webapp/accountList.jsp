<%--
  Created by IntelliJ IDEA.
  User: sriharshakota
  Date: 8/23/17
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.example.servlet.AccountListServlet" %>
<%@page import="com.example.model.Account" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Account List</title>

</head>

<form action="accountsList">
    Account List :
</form>


   <%

    ArrayList<Account> list = (ArrayList<Account>) request.getAttribute("accList");

    for (Account account  : list){
        out.println("ID : "+account.getid() + "  First Name : " +account.getFName() + " LastName : "+ account.getLName() + " Balance : " + account.getBalance() +"\r \n");
%>
<br/>
<%
    };
%>

<a href="routing/index.html" >Back to Home page</a>
</body>
</html>

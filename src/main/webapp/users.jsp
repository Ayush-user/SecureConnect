<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.ResultSet" %>

<%
    String currentUser = (String) session.getAttribute("name");

    if(currentUser == null){
        response.sendRedirect("login.html");
        return;
    }

    ResultSet rs = (ResultSet)request.getAttribute("users");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Users</title>
<link rel="stylesheet" href="users.css">

</head>
<body>

<div class="container">

<div class="card">

<h2>Available Users</h2>

<%
    while(rs.next()){
        String uname = rs.getString("uname");
%>

<div class="user">

<a href="Chat?receiver=<%= uname %>">

<%= uname %>

</a>

</div>

<%
    }
%>

</div>

</div>

</body>
</html>
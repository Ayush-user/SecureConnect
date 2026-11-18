<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String name = (String) session.getAttribute("name");

if(name == null){
    response.sendRedirect("login.html");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>

<link rel="stylesheet" href="home.css">

</head>
<body>

<div class="container">

    <div class="card">

        <div class="profile">

            <div class="avatar">
                <%= name.substring(0,1).toUpperCase() %>
            </div>

            <h1>Welcome, <%= name %> 👋</h1>

            <p>You have successfully logged in.</p>

        </div>

        <div class="details">

            <div class="box">
                <h3>Username</h3>
                <p><%= name %></p>
            </div>

            <div class="box">
                <h3>Status</h3>
                <p>🟢 Online</p>
            </div>

            <div class="box">
                <h3>Role</h3>
                <p>User</p>
            </div>

            <div class="box">
                <h3>Login Status</h3>
                <p>Authenticated ✔</p>
            </div>

        </div>

        <div class="buttons">

            <a href="index.html" class="btn blue">
                Register New User
            </a>

            <a href="login.html" class="btn green">
                Switch Account
            </a>

            <a href="login.html" class="btn red">
                Logout
            </a>
            
            <a href="./Users" class="btn red">
                Chat
            </a>

        </div>

    </div>

</div>

</body>
</html>
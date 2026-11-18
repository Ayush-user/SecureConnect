<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String name = (String) session.getAttribute("name");

    if(name == null){
        name = "User";
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Successful</title>

<link rel="stylesheet" href="success.css">

</head>
<body>

<div class="container">

    <div class="card">

        <div class="success-icon">
            ✓
        </div>

        <h1>Registration Successful!</h1>

        <h2>Welcome, <span><%= name %></span> 🎉</h2>

        <p>
            Your account has been created successfully.
            <br>
            You can now login using your registered credentials.
        </p>

        <div class="button-group">

            <a href="login.html" class="btn login-btn">
                Login Now
            </a>

            <a href="index.html" class="btn register-btn">
                Register Another
            </a>

        </div>

    </div>

</div>

</body>
</html>
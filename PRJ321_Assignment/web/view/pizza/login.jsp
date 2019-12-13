<%-- 
    Document   : home
    Created on : Jun 30, 2019, 5:29:07 PM
    Author     : Admin
--%>

<%@page import="model.CustomerAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
              crossorigin="anonymous">
        <link href="../css/pizza.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>


    </head>

    <%
        CustomerAccount account = (CustomerAccount) session.getAttribute("account");
    %>  


    <body>


        <div id="introduce">
            <div id="login-link">
                <%
                    if (account != null) {
                %><i class="fas fa-user"></i>
                Hello <%=account.getName()%>
                <br>Click <a href="logout" >Here</a> for logout!
                <%} else {%>
                <i class="fas fa-user"></i><a href="login">Login</a>
                <i class="fas fa-user"></i><a href="register">Register</a>
                    <%}%>
            </div>
            <div><h1>P   I   Z   Z   A</h1></div>
            <div id="order-link"><a href="order">Order now</a></div>
        </div>

        <!-- Navigation -->
        <div id="nav-bar">
            <a href="home">Home</a>
            <a href="pizza">Pizza</a>
            <a href="drink">Drink</a>
            <a href="contact" class="">Contact</a>
        </div>

        <div class="pizzas" style="width: 50%">
            <form action="login" method="POST">
                <p3 style="margin-left: 20px; font-size: 18px;">Username:</p3><input type="text" name="username" style="margin: 20px; padding: 5px;"/> <br/>
                <p3 style="margin-left: 20px; font-size: 18px;">Password:</p3><input type="password" name="password" style="margin: 20px; padding: 5px;"/><br/>
                <input type="checkbox" name="remember" value="remember" style="margin: 20px;"/> Remember me!<br/>
                <p style="margin-left: 20px; font-size: 18px; color: red">${requestScope.notify}<p>
                    <input type="submit" value="Login" class="form-submit" id="button-order"/>
            </form>    
        </div>
    </body>
</html>

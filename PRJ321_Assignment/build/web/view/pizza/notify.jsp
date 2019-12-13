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
        <title>Home</title>


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
                <form action="viewacc" method="GET" style="margin-left: 10px;">
                    <input type="hidden" value="<%=account.getId()%>" name="id">
                    <input type="submit" value="More..." id="more-btn">
                </form>
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

        <h1 style="margin-left: 500px; color: #ffff33" >Order completely!</h1>
        <a class="link-edit" href="pizza" style="font-size: 16px">Back to pizza!</a> 
    </body>
</html>

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
        <title>Edit Info</title>

    </head>
    <%
        CustomerAccount account = (CustomerAccount) session.getAttribute("account");

    %>  



    <body>


        <div id="introduce">
            <div id="login-link">
                <%                    if (account != null) {
                %><i class="fas fa-user"></i>
                Hello <%=account.getName()%>
                <br>Click <a href="logout" >Here</a> for logout!
                <%} else {%>
                <i class="fas fa-user"></i> <a href="login">Login</a>
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
            <form action="editinfo" method="POST">
                <h3 style="margin: 20px; padding: 5px;">Please input here:</h3>
                <input type="text" name="id" style="margin: 20px; padding: 5px;" placeholder="<%=account.getId()%>" readonly value="<%=account.getId()%>"/> <br/>
                <input type="text" name="name" style="margin: 20px; padding: 5px;" placeholder="<%=account.getName()%>" value="<%=account.getName()%>"/> <br/>
                <input checked="checked" type="radio" name="gender" value="male" style="margin: 20px; padding: 5px;"/> Male
                <input  type="radio" name="gender" value="female" style="margin: 20px; padding: 5px;"/> Female<br>
                <input type="email" name="email" style="margin: 20px; padding: 5px;" placeholder="<%=account.getEmail()%>" readonly value="<%=account.getEmail()%>"/> <br/>
                <input type="text" name="phone" style="margin: 20px; padding: 5px;" placeholder="<%=account.getPhone()%>" value="<%=account.getPhone()%>"/> <br/>
                <input type="hidden" name="password" value="<%=account.getPhone()%>"/> <br/>

                <input type="submit" value="Update" class="form-submit" id="button-order"/>
            </form>    
        </div>
    </body>
</html>

<%-- 
    Document   : home
    Created on : Jun 30, 2019, 5:29:07 PM
    Author     : Admin
--%>

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
        <title>Register</title>

    <%
        String p_id = (String) request.getAttribute("pizza_id");
    %>  
        
        
    </head>

    <body>
        <div id="introduce">
            <div id="login-link">
                <i class="fas fa-user"></i><a href="login">Login</a>
                <i class="fas fa-user"></i><a href="register">Register</a>
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
            <form action="getinfo" method="POST">
                <h3 style="margin: 20px; padding: 5px;">Please input here:</h3>
                <input type="hidden" name="pizza_id" value="<%=p_id%>"/> <br/>
                
                <input type="text" name="name" style="margin: 20px; padding: 5px;" placeholder="Name"/> <br/>
                
                <input type="text" name="address" style="margin: 20px; padding: 5px;" placeholder="Address"/> <br/>
                <input type="text" name="phone" style="margin: 20px; padding: 5px;" placeholder="Phone"/> <br/>
                
                
                <input type="submit" value="Continue order" class="form-submit" id="button-order"/>
            </form>    
        </div>
                
    </body>
</html>

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
        <title>View More</title>


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

        <div id="style-more-acc"> 

            <div id="show-history">
                <h3 style="margin-left: 20px;">Your History Order:</h3>
                <c:forEach items="${requestScope.pizzas_order}" var="p" varStatus="loop" > 
                    <div class="pizzas">
                        <div >
                            <img class="pizza-img-acc" src="data:image/png;base64,${p.image}">
                        </div>
                        <div class="pizza-detail">
                            <p style="color: #ffff33; font-size: 18px; font-weight: bold; margin-top: 10px">${p.name}</p>
                            <p style="margin-top: 10px">Size : ${p.size}</p>
                            <p class="p-bold">Total : ${p.price} $</p>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <div id="show-more-acc" >
                <h3>User's Information</h3>
                <div class="pizzas">
                    <p style="color: #ffff33">Name: <%=account.getName()%><p>
                    <p style="color: #ffff33">Email: <%=account.getEmail()%><p>
                    <p style="color: #ffff33">Gender: <% if (account.isGender()) {%>
                        Male
                        <%} else {%>
                        Female
                    <%}%><p>    
                    <p style="color: #ffff33">Phone: <%=account.getPhone()%><p>
                     <br><a href="editinfo" class="link-edit">Edit</a>
                </div>
            </div>
        </div>

    </body>
</html>

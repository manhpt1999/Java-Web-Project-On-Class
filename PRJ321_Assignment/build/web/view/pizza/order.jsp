<%-- 
    Document   : home
    Created on : Jun 30, 2019, 5:29:07 PM
    Author     : Admin
--%>

<%@page import="model.Customer"%>
<%@page import="model.Pizza"%>
<%@page import="model.CustomerAccount"%>
<%@page import="util.HtmlHelper"%>
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
        <title>Pizza</title>

    </head>

    <%
        CustomerAccount account = (CustomerAccount) session.getAttribute("account");
        Pizza p = (Pizza) request.getAttribute("pizza");

    %>  


    <body>


        <div id="introduce">
            <div id="login-link">
                <%                    if (account != null) {
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



        <div id="show-pizza">
            <div class="pizzas">
                <div>
                    <img class="pizza-img" src="data:image/png;base64,<%=p.getImage()%>">
                </div>
                <div class="pizza-detail">
                    <p style="color: #ffff33; font-size: 18px; font-weight: bold"><%=p.getName()%></p>
                    <p><%=p.getDetails()%></p>
                    <p class="p-bold"><%=p.getPrice()%> $</p>
                </div>
                <div class="form-submit">
                    <form action="order" method="POST">
                        <input type="hidden" value="<%=p.getId()%>" name="pizza_id">
                        <input type="hidden" value="<%=p.getPrice()%>" name="pizza_price">

                        <%if (account != null) {%>

                        <input type="hidden" value="<%=account.getId()%>" name="customer_id">
                        <input type="hidden" value="<%=account.getPhone()%>" name="phone">

                        <%} else {%>
                        <%
                            Customer c = (Customer) request.getAttribute("customer");

                        %> 
                        <input type="hidden" value="<%=c.getId()%>" name="customer_id">
                        <input type="hidden" value="<%=c.getPhone()%>" name="phone">
                        <%}%>




                        <p>Topping 1:</p>
                        <select name="topping1" class="options">
                            <c:forEach items="${requestScope.toppings}" var="t" varStatus="loop" > 
                                <option value="${t.topping}">${t.topping}</option>
                            </c:forEach>
                        </select>
                        <p>Topping 2:</p>
                        <select name="topping2" class="options">
                            <c:forEach items="${requestScope.toppings}" var="t" varStatus="loop" > 
                                <option value="${t.topping}">${t.topping}</option>
                            </c:forEach>
                        </select>
                        <p>Size: (Size L with more people x2 price)</p>
                        <select name="size" class="options">
                            <c:forEach items="${requestScope.sizes}" var="s" varStatus="loop" > 
                                <option value="${s.size}">${s.size}</option>
                            </c:forEach>
                        </select>

                        <input type="submit" value="Finish Order!" id="button-order">
                    </form>
                </div>
            </div>
        </div>







    </body>
</html>

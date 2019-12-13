<%-- 
    Document   : home
    Created on : Jun 30, 2019, 5:29:07 PM
    Author     : Admin
--%>

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


        <%
            Integer totalpage = (Integer) request.getAttribute("totalpage");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
        %>
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
                <form action="viewacc" method="GET" style="margin-left: 10px;" id="form-1">
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

        <!-- Slide Show -->
        <div id="section">
            <img class="mySlides" src="../img/home/slideshow/Capture3.PNG" >
            <img class="mySlides" src="../img/home/slideshow/Capture.PNG" >
            <img class="mySlides" src="../img/home/slideshow/Capture3.PNG" >
            <img class="mySlides" src="../img/home/slideshow/Capture.PNG" >
        </div>

        <div id="util-tab">
            <div class="search">      
                <form action="pizza" method="POST">
                    <input class="input" type="text" placeholder="Price" name="price"/>
                    <input class="input" type="text" placeholder="Pizza name" name="name"/>
                    <input class="input" type="text" placeholder="Recipe" name="recipe"/>
                    <button type="submit" id="btn-search">Search <i class="fas fa-search"></i></button>
                </form>
            </div> 


            <%if (totalpage != 0 && pageindex != 0) {%>
            <div class="paging">
                <%=HtmlHelper.pager(2, pageindex, totalpage)%>
            </div>
            <%}%>

        </div>


        <div id="show-pizza">

            <c:forEach items="${requestScope.pizzas}" var="p" varStatus="loop" > 
                <div class="pizzas">
                    <div >
                        <img class="pizza-img" src="data:image/png;base64,${p.image}">
                    </div>
                    <div class="pizza-detail">
                        <p style="color: #ffff33; font-size: 18px; font-weight: bold">${p.name}</p>
                        <p>${p.details}</p>
                        <p class="p-bold">${p.price} $</p>
                    </div>
                    <div class="form-submit">
                        <%
                            if (account != null) {%>
                        <form action="order" method="GET">
                            <input type="hidden" value="${p.id}" name="pizza_id">
                            <input type="submit" value="Order now" id="button-order">
                        </form>
                        <%} else {%>
                        <form action="getinfo" method="GET">
                            <input type="hidden" value="${p.id}" name="pizza_id">
                            <input type="submit" value="Order now" id="button-order">
                        </form>
                        <%}%>

                    </div>
                </div>
            </c:forEach>


        </div>

        

        <script>
// Automatic Slideshow - change image every 3 seconds
            var myIndex = 0;
            carousel();

            function carousel() {
                var i;
                var x = document.getElementsByClassName("mySlides");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                myIndex++;
                if (myIndex > x.length) {
                    myIndex = 1
                }
                x[myIndex - 1].style.display = "block";
                setTimeout(carousel, 3000);
            }
        </script>

    </body>
</html>

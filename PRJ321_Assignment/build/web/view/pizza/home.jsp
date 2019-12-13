<%-- 
    Document   : home
    Created on : Jun 30, 2019, 5:29:07 PM
    Author     : Admin
--%>

<%@page import="model.CustomerAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
              crossorigin="anonymous">
        <link href="../css/home.css" rel="stylesheet" type="text/css"/>
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

        <!-- Slide Show -->
        <div id="section">
            <img class="mySlides" src="../img/home/slideshow/Capture3.PNG" >
            <img class="mySlides" src="../img/home/slideshow/Capture.PNG" >
            <img class="mySlides" src="../img/home/slideshow/Capture3.PNG" >
            <img class="mySlides" src="../img/home/slideshow/Capture.PNG" >
        </div>

        <!-- POP-UP -->
        <div id="pop-up">
            <div class="pop-up-left"><img src="../img/home/pop-up/pop-up-1.jpg"></div>
            <div class="pop-up-right"><img src="../img/home/pop-up/pop-up-2.jpg"></div>
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

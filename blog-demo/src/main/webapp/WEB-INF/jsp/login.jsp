<%--
  Created by IntelliJ IDEA.
  User: nick2
  Date: 1/31/2020
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@include file="include/header.jsp" %>
    <link href="static/css/loginCss.css" rel="stylesheet" />
</head>
<body>
<%@include file="include/navigation.jsp" %>
<header class="masthead" style="background-image: url('static/img/about-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="page-heading">

                </div>
            </div>
        </div>
    </div>
</header>
    <form method="post">
        <table>
            <tr>
                <td><label for="login">Login:</label></td>
                <td><input id="login" name="login"></td>
            </tr>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><input id="password" type="password" name="password"></td>
            </tr>
        </table>
        <button class="login" type="submit">Sing in</button>
    </form>


<%@include file="include/footer.jsp" %>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 05.07.16
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Registration</h1>
  <form action="Register" method="post">

    <label for = "login">Login: <br></label>
    <input type = "text" id = "login" name = "login">
    <br>
    <label for = "password">Password: <br></label>
    <input type = "password" id = "password" name = "password" >
    <br>
    <label for = "firstName">Name: <br></label>
    <input type = "text" id = "firstName" name = "firstName" >
    <br>
    <label for = "lastName">Surname: <br></label>
    <input type = "text" id = "lastName" name = "lastName">
    <br>
    <input type = "submit" value="Sign Up">

  </form>
</body>
</html>

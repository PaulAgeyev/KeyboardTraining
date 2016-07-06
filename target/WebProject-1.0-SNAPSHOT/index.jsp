<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KeyBoardTraining</title>
</head>
<body>
<h1>Authorization</h1>
${textA}
    <form action="UserService" method="post">
        <input type = "text" name = "login">
        <br>
        <input type = "password" name = "password">
        <br>
        <input type = "submit" value="Sign In">
        <a href="registration.jsp"><input type = "button" value="Sign Up"></a>
    </form>
</body>
</html>
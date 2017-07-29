<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 28.07.2017
  Time: 5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<p>Sign In</p>
<form action="${pageContext.servletContext.contextPath}/SignIn" method='post'>
    Login:<input name='login'/>
    <br/>
    Password:<input type='password' name='password' />
    <input type='submit'>
</form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 04.09.2017
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="container">
    <h2>Список пользователей</h2>
    <form action="${pageContext.servletContext.contextPath}/users.do" method="post">
        name : <input type="text" name="name"><br/>
        <input type="submit"><br/>
    </form>
    <table border="1">
        <tr>
            <td>Имя</td>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="status">
            <tr valign="top">
                <td>${user.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

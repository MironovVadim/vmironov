<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="border: 1pt solid black" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>Name</th>
        <th>Login</th>
        <th>Email</th>
        <th>CreateDate</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.createDate}"/></td>
        </tr>
    </c:forEach>
</table>
</br>
<p>Delete user</p>
<form action="${pageContext.servletContext.contextPath}/DelUser" method='post'>
    Name:<input name='name'/>
    <br/>
    <input type='submit'>
</form>
<br/>
<p>Add user</p>
<form action="${pageContext.servletContext.contextPath}/AddUser" method='post'>
    Name:<input name='name'/>
    <br/>
    Login:<input name='login'/>
    <br/>
    Email:<input name='email'/>
    <br/>
    <input type='submit'>
</form>
<br/>
<p>Update user</p>
<form action="${pageContext.servletContext.contextPath}/UpdateUser" method='post'>
    Name:<input name='name'/>
    <br/>
    Email:<input name='email' />
    <br/>
    <input type='submit'>
</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Current user:<c:out value="${login}"/>
<br/>
User role:<c:out value="${role}"/>
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
<p>Update user</p>
<form action="${pageContext.servletContext.contextPath}/UpdateUser" method='post'>
    Name:<input name='name'/>
    <br/>
    Email:<input name='email' />
    <br/>
    <input type='submit'>
</form>
<table style="border: 1pt solid black" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${serviceUsers}" var="user">
        <tr>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.role}"/></td>
        </tr>
    </c:forEach>
</table>
<c:if test="${role == 'Administrator'}">
    <p>Update service user</p>
    <form action="${pageContext.servletContext.contextPath}/UpdateServiceUser" method="post">
        Login for change:<input name='login'/>
        <br/>
        New Login:<input name='newLogin'/>
        <br/>
        New Password:<input name='password'/>
        <br/>
        New Role:<select size="2" multiple name="role">
        <option disabled>Choose new role</option>
        <option value="">Don't change</option>
        <option value="Administrator">Administrator</option>
        <option value="User">User</option>
    </select>
        <br/>
        <input type='submit'>
    </form>
    <br/>
    <p>Add new service user</p>
    <form action="${pageContext.servletContext.contextPath}/AddServiceUser" method="post">
        New Login:<input name='login'/>
        <br/>
        New Password:<input name='password'/>
        <br/>
        New Role:<select size="2" multiple name="role">
        <option disabled>Choose new role</option>
        <option value="">Don't change</option>
        <option value="Administrator">Administrator</option>
        <option value="User">User</option>
    </select>
        <br/>
        <input type='submit'>
    </form>
</c:if>
<c:if test="${role == 'User'}">
    <p>Update current user</p>
    <form action="${pageContext.servletContext.contextPath}/UpdateServiceUser" method="post">
        New Login:<input name='newLogin'/>
        <br/>
        New Password:<input name='password'/>
        <br/>
        <input type='submit'>
    </form>
</c:if>
</body>
</html>
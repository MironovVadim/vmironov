<%@ page import="ru.job4j.servlets.PostgresDBController" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ПК
  Date: 17.07.2017
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <% List<String> tableUsers = PostgresDBController.newInstance().get();%>
    <% for (int i = 0; i < tableUsers.size();) {%>
    <tr>
        <td><%=tableUsers.get(i++)%></td>
        <td><%=tableUsers.get(i++)%></td>
        <td><%=tableUsers.get(i++)%></td>
        <td><%=tableUsers.get(i++)%></td>
    </tr>
    <% } %>
</table>
</br>
    <p>Delete user</p>
    <form action="<%=request.getContextPath()%>/delServ" method='post'>
    Name:<input type='text' name='name'/>
    <br/>
    <input type='submit'>
    </form>
    <br/>
    <p>Add user</p>
    <form action="<%=request.getContextPath()%>/postServ" method='post'>
    Name:<input type='text' name='name'/>
        <br/>
    Login:<input type='text' name='login'/>
        <br/>
        Email:<input type='text' name='email'/>
        <br/>
    <input type='submit'>
    </form>
    <br/>
    <p>Update user</p>
    <form action="<%=request.getContextPath()%>/putServ" method='post'>
    Name:<input type='text' name='name'/>
    <br/>
    Email:<input type='text' name='email' />
    <input type='submit'>
    </form>
</body>
</html>

<%@ page import="by.sterlikov.calculator.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: sergeysterlikov
  Date: 5.08.23
  Time: 05:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="by.sterlikov.calculator.entity.User" %>

<html>
<head>
    <title>Home</title>
</head>
<body>

<c:if test="${sessionScope.currentUser != null}">
    <h3>Hello ${sessionScope.currentUser.userName}</h3>
    <a href="calculator">Calculator</a>
    <a href="logout">Logout</a>

    <table>
        <c:forEach var="user" items="${sessionScope.allUsers}">
            <p>${user}</p>
        </c:forEach>
    </table>

</c:if>

<c:if test="${sessionScope.currentUser == null}">
    <h3>Hello guest</h3>
    <a href="registration">Registration</a>
    <a href="login">Login</a>
</c:if>


</body>
</html>

<%@ page import="by.sterlikov.calculator.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
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

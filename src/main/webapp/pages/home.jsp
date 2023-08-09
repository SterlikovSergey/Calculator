<%--
  Created by IntelliJ IDEA.
  User: sergeysterlikov
  Date: 5.08.23
  Time: 05:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

<c:if test="${sessionScope.currentUser != null}">
    <a href="calculator">Calculator</a>
    <a href="logout">Logout</a>
</c:if>

<c:if test="${sessionScope.currentUser == null}">
    <a href="registration">Registration</a>
    <a href="login">Login</a>
</c:if>


</body>
</html>

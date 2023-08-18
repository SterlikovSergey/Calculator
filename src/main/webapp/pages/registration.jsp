<%--
  Created by IntelliJ IDEA.
  User: sergeysterlikov
  Date: 6.08.23
  Time: 03:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form name="registration" method="post">
    <label>
        <input name="name" type="text" placeholder="insert name">
    </label>
    <label>
        <input name="userName" type="text" placeholder="insert user name">
    </label>
    <label>
        <input name="password" type="password" placeholder="your password">
    </label>
    <button type="submit">Accept</button>
</form>
<h1>${existsUser}</h1>
<c:if test="${sessionScope.existsUser != null}">
    <a href="login">Login</a>
</c:if>
</body>

</html>

<%--
  Created by IntelliJ IDEA.
  User: sergeysterlikov
  Date: 8.08.23
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="currentUser" var="user">

</c:if>
<form action="login" method="post">
    <label>
    <input name="userName" type="text" placeholder="userName">
    </label>
    <label>
        <input name="password" type="password" placeholder="password">
    </label>
    <label>
        <button type="submit">Accept</button>
    </label>
</form>

</body>
</html>

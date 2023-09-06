<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="by.sterlikov.calculator.entity.User" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="calculator" method="post">
    <h3>Hello ${sessionScope.currentUser.userName}, enter an arithmetic expression</h3>
    <input type="text" name="values" placeholder="your values">
    <input type="number" name="num1" placeholder="Number 1">
    <input type="number" name="num2" placeholder="Number 2">
    <input type="text" name="type" placeholder="sum,sub,cos,sin,exp,abs,floor">
    <button>Access</button>
</form>
<h3>${result}</h3>
<a href="history">Open history</a>
<table>
    <c:forEach var="value" items="${history}">
        <p>${value}</p>
    </c:forEach>
</table>
<h3>${message}</h3>
<a href="logout">Logout</a>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: sergeysterlikov
  Date: 5.08.23
  Time: 07:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <input type="text" name="type" placeholder="sum,sub,cos,sin">
    <button>Access</button>
</form>
<h3>${result}</h3>
<h3>${message}</h3>
</body>
</html>

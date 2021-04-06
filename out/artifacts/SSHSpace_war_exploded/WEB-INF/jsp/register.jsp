<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 2021/4/1
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h3>注册</h3>
<form action="user/register">
    <label>
        用户名：
        <input type="text" name="username">
    </label><br>
    <label>
        密码：
        <input type="password" name="password">
    </label><br>
    <input type="submit" value="注册">
</form>
</body>
</html>

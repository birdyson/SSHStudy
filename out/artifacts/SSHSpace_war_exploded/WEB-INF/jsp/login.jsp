<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>请登录</title>
</head>
<body>
<p style="color: red; font-weight: bolder">${error}</p>
<form action="/user/login">
    <h3>登录</h3>
    <label>
        用户名：
        <input type="text" name="username">
    </label><br>
    <label>
        密码：
        <input type="password" name="password">
    </label><br>
        <input type="submit" value="登录">
</form>
<a href="registerPage.action">
    <input type="button" value="注册">
</a>
</body>
</html>

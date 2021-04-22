<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>你好</title>
</head>
<body>

<h4>你好！${username}!</h4>
<a href="/user/findAll"><button>用户注册表</button></a>
<a href="/user/delete"><button>注销</button></a>
<a href="/user/update"><button>修改密码</button></a><br>
<form action="/user/find">
    <label for="findUsername">用户名字查询</label>
    <input type="text" name="findUsername" id="findUsername">
    <input type="submit" value="查询">
</form>


</body>
</html>

<%@ page import="com.alex.service.UserService" %>
<%@ page import="com.alex.vo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>你好</title>
</head>
<body>
你好！
<table border="1">
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
    </tr>

<%
    UserService userService = new UserService();
    List<User> allUser = userService.getAllUser();
    for (User u :
            allUser) {
%>
    <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getUsername()%></td>
        <td><%=u.getPassword()%></td>
    </tr>
<%
    }
%>
</table>
</body>
</html>

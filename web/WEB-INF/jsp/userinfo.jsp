<%@ page import="com.alex.vo.User" %>
<%@ page import="com.alex.service.UserService" %>
<%@ page import="com.alex.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<%
    if (session.getAttribute("username") == null){
        response.sendRedirect("hello/hello");
    }
%>
<%
//    String updateId = request.getParameter("updateId");
//    System.out.println(updateId);
//    UserDao userDao = new UserDao();
//    User user = userDao.selectUserById(Integer.parseInt(updateId));


%>
<form action="/user/update">
    <input type="hidden" name="id" value="${userUpdate.id}">
    <table>
        <tr>
            <th>用户名</th>
            <td><input type="text" name="username" value="${userUpdate.username}"></td>
        </tr>
        <tr>
            <th>密码</th>
            <td><input type="text" name="password" value="${userUpdate.password}"></td>
        </tr>
        <tr>
            <th><input type="submit" value="修改"></th>
        </tr>
    </table>

</form>
<%--<form action="/user/update">--%>
<%--    <input type="hidden" name="id" value="<%=user.getId()%>">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <th>用户名</th>--%>
<%--            <td><input type="text" name="username" value="<%=user.getUsername()%>"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>密码</th>--%>
<%--            <td><input type="text" name="password" value="<%=user.getPassword()%>"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th><input type="submit" value="修改"></th>--%>
<%--        </tr>--%>
<%--    </table>--%>

<%--</form>--%>
<jsp:include page="template.jsp"/>

</body>
</html>

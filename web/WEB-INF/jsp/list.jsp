<%@ page import="com.alex.service.UserService" %>
<%@ page import="com.alex.vo.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>list</title>
</head>
<body>
<%
    if (session.getAttribute("username") == null){
        response.sendRedirect(request.getContextPath()+"/hello");
    }
//    System.out.println("用户user:"+session.getAttribute("username"));
    List<User> allUser = (List<User>) request.getAttribute("userlist");
//    UserService userService = new UserService();
//    List<User> allUser = userService.getAllUser();
%>
<p style="color: red; font-weight: bolder;">${error}</p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    <c:forEach var="user" items="<%=allUser%>">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.username}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/user/delete?delUsername=<c:out value="${user.username}"/>"><button>删除</button></a>
<%--                <a href="${pageContext.request.contextPath}/hello/update?updateId=<c:out value="${user.id}"/>"><button>修改</button></a>--%>
                <a href="${pageContext.request.contextPath}/user/updateForward?userUpdate.id=${user.id}&userUpdate.username=${user.username}&userUpdate.password=${user.password}"><button>修改</button></a>
            </td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="template.jsp"/>
</body>
</html>

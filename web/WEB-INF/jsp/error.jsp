<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出错啦！</title>
</head>
<body>
<%--    <%
        if (session.getAttribute("username") == null){
            response.sendRedirect("hello/hello");
        }
    %>--%>
    <p style="color:red; font-weight: bolder">${error}</p>
<jsp:include page="template.jsp"/>
</body>
</html>

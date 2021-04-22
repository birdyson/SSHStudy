<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>出错啦！</title>
</head>
<body>
    <%
        if (session.getAttribute("username") == null){
            response.sendRedirect("hello/hello");
        }
        System.err.println("出现错误Error！");
    %>
    <%="出错了！"%>
</body>
</html>

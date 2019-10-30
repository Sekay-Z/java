<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/11
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1>
${requestScope.get("msg")}
    <form action="<c:url value='/Servlet'/>" method="post">
        用户名：<input type="text" name="username"/>
        <input type="submit" value="登录">
    </form>
</body>
</html>

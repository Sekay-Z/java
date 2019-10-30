<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/2/24
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<form action="<c:url value='/RegistServlet'/>" method="post">
    <h1>注册</h1>
    <p style="color:red">${requestScope.get("msg")}</p><br/>
    用户名：<input type="text" name="username" value="${requestScope.get("user").username}"/><br/>
    密码：<input type="text" name="password" value="${requestScope.get("user").password}"/><br/>
    <input type="submit" value="注册"/>
</form>
</body>
</html>

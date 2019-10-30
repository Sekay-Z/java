<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/11
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>欢迎欢迎</h1>
    <a href="<c:url value='/index.jsp'/>">游客入口</a>
    <a href="<c:url value='/user/user.jsp'/>">会员入口</a>
    <a href="<c:url value='/admin/admin.jsp'/>">管理员入口</a>
</body>
</html>

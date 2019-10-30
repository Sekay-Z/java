<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/2/24
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
    <c:choose>
        <c:when test="${empty sessionScope.get('user')}">滚蛋！</c:when>
        <c:otherwise>欢迎${sessionScope.get("user").username}光临！！</c:otherwise>
    </c:choose>
</body>
</html>
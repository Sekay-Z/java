<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/2/22
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="code" value="<script>alert('hello');</script>" scope="session"/>
<c:out value="${code}" />
<hr/>
<c:if test="${not empty param.name}">
    你傻了吗
</c:if>
<hr/>
<c:choose>
    <c:when test="${empty param.name}">
        你有种
    </c:when>
    <c:otherwise>你没种</c:otherwise>
</c:choose>

</body>
</html>

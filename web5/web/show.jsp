<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/11
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value='/AServlet?method=fun1'/>">点击</a><br/>
<a href="<c:url value='/AServlet?method=fun2'/>">点击</a><br/>
<a href="<c:url value='/AServlet?method=fun3'/>">点击</a><br/>
<a href="<c:url value='/AServlet?method=fun4'/>">点击</a><br/>
<a href="<c:url value='/AServlet?method=fun5'/>">点击</a><br/>
</body>
</html>

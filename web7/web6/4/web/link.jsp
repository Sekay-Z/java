<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/11
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<h1>查询书籍</h1>
<a href="<c:url value='/BookServlet?method=findAll'/>">查询所有</a><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=1'/>">查询SE分类</a><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=2'/>">查询EE分类</a><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=3'/>">查询框架</a>
</body>
</html>

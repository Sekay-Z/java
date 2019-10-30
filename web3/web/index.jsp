<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/2/22
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="<c:url value='/UserServlet'/>">点击查看</a><br/>
    <a href="${pageContext.request.contextPath}/UserServlet">点击查看</a><br/>
    <a href="/web3/UserServlet">点击查看</a><br/>
  </body>
</html>

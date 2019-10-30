<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/6
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h1 align="center">客户列表</h1>
<table align="center" border="1" width="50%">
    <tr>
        <td>客户名字</td>
        <td>客户性别</td>
        <td>手机</td>
        <td>邮箱</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.customerList}" var="customer">
    <tr>
        <td>${customer.cname}</td>
        <td>${customer.gender}</td>
        <td>${customer.cellphone}</td>
        <td>${customer.email}</td>
        <td>
            <a href="<c:url value='/edit.jsp'/> ">编辑</a>
            <a href="<c:url value='/CustomerServlet?method=delete&cname=${customer.cname}'/> ">删除</a>
        </td>
    </c:forEach>
    </tr>
</table>
</form>
</body>
</html>

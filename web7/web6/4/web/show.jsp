<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/11
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">书籍列表</h1>
    <table align="center" width="60%" border="1">
        <tr>
            <th>书名</th>
            <th>单价</th>
            <th>分类</th>
        </tr>
        <c:forEach items="${requestScope.lb}" var="book">
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.category}</td>
        </c:forEach>
    </table>
</body>
</html>

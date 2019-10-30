<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/11
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<h1 align="center">IP访问次数登记</h1>
    <table align="center" width="60%" border="1">
        <tr>
            <th>ip</th>
            <th>count</th>
        </tr>
        <c:forEach items="${applicationScope.map}" var="entry">
            <tr>
                <td>${entry.key}</td>
                <td>${entry.value}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>

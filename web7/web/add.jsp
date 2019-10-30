<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/6
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<h1 align="center">添加客户</h1>
<form action="<c:url value='/CustomerServlet'/>" method="post" style="text-align: center">
    <input type="hidden" name="method" value="add"/>
    <table border="0" align="center" width="30%" >
        <tr>
            <td align="right">客户名字：</td>
            <td><input type="text" name="cname" value="${requestScope.cstm.cname}" /></td>
            <td><div style="color: red">${requestScope.error.cname}<div/></td>
        </tr>
        <tr>
            <td align="right">客户性别：</td>
            <td><input type="radio" name="gender" value="nan"/>男 <input type="radio" name="gender" value="nv">女</td>
        </tr>
        <tr>
            <td align="right">手机：</td>
            <td><input type="text" name="cellphone" value="${requestScope.cstm.cellphone}"/></td>
            <td><div style="color: red">${requestScope.error.cellphone}<div/></td>
        </tr>
        <tr>
            <td align="right">邮箱：</td>
            <td><input type="text" name="email" value="${requestScope.cstm.email}"/></td>
            <td><div style="color: red">${requestScope.error.email}<div/></td>
        </tr>
    </table>
    <input type="submit" value="添加"/>
</form>
</body>
</html>

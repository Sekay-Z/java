<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/7
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h1 align="center">编辑客户</h1>
<form action="<c:url value="/CustomerServlet"/> " method="post" style="text-align: center">
    <input type="hidden" name="method" value="edit">
    <table border="1" align="center">
        <tr>
            <td align="right">客户名字：</td>
            <td><input type="text" name="cname"/></td>
        </tr>
        <tr>
            <td align="right">客户性别：</td>
            <td><input type="radio" name="gender" value="nan"/>男 <input type="radio" name="gender" value="nv">女</td>
        </tr>
        <tr>
            <td align="right">手机：</td>
            <td><input type="text" name="cellphone"/></td>
        </tr>
        <tr>
            <td align="right">邮箱：</td>
            <td><input type="text" name="email"></td>
        </tr>
    </table>
    <input type="submit" value="编辑" align="center">
</form>
</body>
</html>

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
<h1 align="center">高级搜索</h1>
<form action="<c:url value="/CustomerServlet"/> " method="post" style="text-align: center">
    <input type="hidden" name="method" value="query">
    <table border="0" align="center" width="30%" >
        <tr>
            <td align="right">客户名字：</td>
            <td><input type="text" name="cname"/></td>
        </tr>
        <tr>
            <td align="right">客户性别：</td>
            <td>
                <select name="gender">
                    <option value="">请选择</option>
                    <option value="nan">男</option>
                    <option value="nv">女</option>
                </select>
            </td>
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
    <input type="submit" value="搜索" align="center">
</form>
</body>
</html>

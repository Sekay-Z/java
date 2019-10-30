<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/11
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="<c:url value='/Servlet?username=张三'/> ">点击这里</a>
    <form action="<c:url value='/Servlet'/> " method="post">
     用户名:<input type="text" name="username" value="李四"/>
      <input type="submit" value="点击">
    </form>
  </body>
</html>

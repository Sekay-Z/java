<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZSK
  Date: 2019/3/6
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<frameset rows="20%,*">
    <frame src="<c:url value="top.jsp"/> " name="top"/>
    <frame src="<c:url value="welcome.jsp"/> " name="main"/>
</frameset>
</html>

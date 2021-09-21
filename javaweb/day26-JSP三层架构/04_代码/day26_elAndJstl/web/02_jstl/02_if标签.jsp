<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>02_if标签.jsp</title>
</head>
<body>

<%--从session域对象中取flag的值--%>
<c:if test="${flag}">
    true
</c:if>


</body>
</html>

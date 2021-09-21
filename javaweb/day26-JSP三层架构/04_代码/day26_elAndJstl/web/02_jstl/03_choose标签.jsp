<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>03_choose标签</title>
</head>
<body>
<%
    request.setAttribute("num",2);
%>
<%--需求:如果域对象中num的值大于5,就显示num大于5,小于5,就显示num小于5,否则就是显示num等于5--%>
<c:choose>
    <c:when test="${num > 5}">
        num大于5
    </c:when>
    <c:when test="${num < 5}">
        num小于5
    </c:when>
    <c:otherwise>
        num等于5
    </c:otherwise>
</c:choose>

</body>
</html>

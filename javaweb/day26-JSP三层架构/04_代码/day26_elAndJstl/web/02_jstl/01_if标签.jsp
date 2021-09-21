<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>01_if标签</title>
</head>
<body>
<%
    request.setAttribute("num",10);

%>

<%--需求:如果域对象中num的值大于5,就显示num大于5,否则就显示num小于或等于5--%>
<%--test属性:值为判断条件,可以写EL表达式--%>
<%--var属性: 存储test属性的结果,不可以写EL表达式,var的值是存储到了某个域中,默认是page--%>
<%--scope属性: 指定var属性的值到底存储到哪个域中, 不可以写EL表达式,默认page--%>
<c:if test="${num > 5}" var="flag" scope="session">
    <font color="red" size="7">num 大于 5</font>
</c:if>

<c:if test="${num <= 5}">
    <font color="red" size="7">num 小于或等于 5</font>
</c:if>

<c:if test="${flag}">
    true
</c:if>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/9
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--如果user不为null,说明有登录,就显示成功页面-->
<c:if test="${not empty user}">
    success....<br/>
    欢迎${user.username}---<a href="LogoutServlet">退出登录</a>
</c:if>
<!--如果user为null,说明没有登录,就显示提示信息: 小子,你还没有登录呢,赶紧去<a>登录</a>-->
<c:if test="${empty user}">
    小子,你还没有登录呢,赶紧去<a href="login.jsp">登录</a>
</c:if>

</body>
</html>

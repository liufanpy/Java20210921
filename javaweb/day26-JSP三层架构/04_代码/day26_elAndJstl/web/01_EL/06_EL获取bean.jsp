<%@ page import="com.itheima.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>06_EL获取bean</title>
</head>
<body>
<%
    User user = new User("zs","123456");
    request.setAttribute("u",user);
%>
<h1>el方式:</h1>
${u.getUsername()}<br/>
${u.getPassword()}<br/>
${u.username}<br/>
${u.password}<br/>


</body>
</html>

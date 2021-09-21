<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>04_EL获取list集合</title>
</head>
<body>
<%
    ArrayList<String> list = new ArrayList<>();
    list.add("itheima");
    list.add("itcast");
    list.add("java");
    request.setAttribute("l",list);
%>

<h1>jsp方式:</h1>
<%= ((ArrayList<String>)request.getAttribute("l")).get(0)%><br/>
<%= ((ArrayList<String>)request.getAttribute("l")).get(1)%><br/>
<%= ((ArrayList<String>)request.getAttribute("l")).get(2)%><br/>

<h1>el方式:</h1>
${requestScope.get("l").get(0)}<br/>
${requestScope.get("l").get(1)}<br/>
${requestScope.get("l").get(2)}<br/>
${l.get(0)}<br/>
${l.get(1)}<br/>
${l.get(2)}<br/>
${l[0]}<br/>
${l[1]}<br/>
${l[2]}<br/>


</body>
</html>

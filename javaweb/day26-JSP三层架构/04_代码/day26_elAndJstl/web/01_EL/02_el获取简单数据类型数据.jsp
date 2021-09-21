<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>02_el获取简单数据类型数据</title>
</head>
<body>
<%
    /*往请求域对象中存值*/
    request.setAttribute("akey","aaa");

    /*往session域对象中存值*/
    session.setAttribute("bkey","bbb");

    /*往application域对象中存值(ServletContext)*/
    application.setAttribute("ckey","ccc");

    /*同时往请求域对象,session域对象,application域对象中存储一个同名的键与值*/
    //request.setAttribute("rkey","rrr");
    //session.setAttribute("rkey","rrrr");
    //application.setAttribute("rkey","rrrrr");
%>

<h1>取请求域对象中的值:</h1>
jsp方式:<br/>
<%= request.getAttribute("akey") %><br/>
el方式:<br/>
${requestScope.get("akey")}


<h1>取session域对象中的值:</h1>
jsp方式:<br/>
<%= session.getAttribute("bkey")%><br/>
el方式:<br/>
${sessionScope.get("bkey")}<br/>

<h1>取application域对象中的值:</h1>
jsp方式:<br/>
<%= application.getAttribute("ckey")%><br/>
el方式:<br/>
${applicationScope.get("ckey")}<br/>

<%--el表达式简单获取域对象值的方式: ${键名}--%>
<%--从小到大的范围进行查找:  request-->session-->application --%>
<h1>el简单方式</h1>
${akey}<br/>
${bkey}<br/>
${ckey}<br/>
${rkey}<br/>


</body>
</html>

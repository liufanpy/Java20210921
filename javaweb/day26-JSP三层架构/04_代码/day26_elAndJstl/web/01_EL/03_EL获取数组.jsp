<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>03_EL获取数组</title>
</head>
<body>
<%
    /*请求域对象中存数组*/
    String[] arr = {"itheima","itcast","java"};
    request.setAttribute("array",arr);
%>

<h1>jsp方式取值:</h1>
<%= ((String[])request.getAttribute("array"))[0]%><br/>
<%= ((String[])request.getAttribute("array"))[1]%><br/>
<%= ((String[])request.getAttribute("array"))[2]%><br/>

<%--语法:${数组名[索引]}--%>
<h1>el方式取值: </h1>
${requestScope.get("array")[0]}<br/>
${requestScope.get("array")[1]}<br/>
${requestScope.get("array")[2]}<br/>
${array[0]}<br/>
${array[1]}<br/>
${array[2]}<br/>

</body>
</html>

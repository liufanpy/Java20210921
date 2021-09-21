<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>05_EL获取Map</title>
</head>
<body>
<%
    HashMap<String,String> map = new HashMap<>();
    map.put("k1","v1");
    map.put("k2","v2");
    map.put("k3","v3");
    request.setAttribute("m",map);
%>

<%--语法: ${域对象的key.map集合的key} 或者 ${域对象的key.get(map集合的key)}--%>
<h1>EL方式:</h1>
${m.k1}<br/>
${m.k2}<br/>
${m.k3}<br/>

${m.get("k1")}<br/>
${m.get("k2")}<br/>
${m.get("k3")}<br/>

</body>
</html>

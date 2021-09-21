<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>07_EL取值注意事项.jsp</title>
</head>
<body>
<%--能获取到则获取,获取不到返回" "字符串 ,不是返回null--%>
${akey}<br/>

<%--${域中属性名}:依次从requestScope|sessionScope|applicationScope中查找指定的属性--%>
<%
    /*同时往请求域对象,session域对象,application域对象中存储一个同名的键与值*/
    //request.setAttribute("rkey","rrr");
    //session.setAttribute("rkey","rrrr");
    //application.setAttribute("rkey","rrrrr");
%>
${rkey}<br/>

<%
    request.setAttribute("a.b.c.d","abcd");

    HashMap<String,String> map = new HashMap<>();
    map.put("a.k1","v1");
    map.put("k2","v2");
    map.put("k3","v3");
    request.setAttribute("m",map);

%>
<%--
[]和.方式的区别: 有特殊字符的要用[]
- 若属性名中出现了".""+""-"等特殊的符号的时候,快捷获取的方式不好使,必须使用以下方式:
${xxxScope["属性名"]}
${key["属性名"]}
--%>
<h1>el方式:</h1>
${a.b.c.d} -- ${requestScope.get("a.b.c.d")} -- ${requestScope["a.b.c.d"]}<br/>
${m.a.k1} -- ${requestScope.get("m").get("a.k1")} -- ${m["a.k1"]}<br/>

</body>
</html>

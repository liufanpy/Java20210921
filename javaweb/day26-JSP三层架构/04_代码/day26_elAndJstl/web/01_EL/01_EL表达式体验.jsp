<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>01_EL表达式体验</title>
</head>
<body>
<%--el: 就是用来取域对象中的值,或者执行运算--%>
<%--格式: ${el表达式}--%>
<%--JSP-->翻译成Servlet-->翻译后里面内置了很多对象()--%>
<%--jsp内置对象:request(HttpServletRequest),response(HttpServletResponse),session(HttpSession),application(ServletContext),config(ServletConfig)--%>
<%
    // 请求域对象中存值
    request.setAttribute("username","zhangsan");
%>

<h1>jsp方式:</h1>
<%= request.getAttribute("username") %><br/>

<%--el里面的内置对象: requestScope,sessionScope,applicationScope,pageScope,cookie--%>
<h1>el方式:</h1>
${requestScope.get("username")}<br/>

<h1>el简单方式:</h1>
${username}<br/>

</body>
</html>

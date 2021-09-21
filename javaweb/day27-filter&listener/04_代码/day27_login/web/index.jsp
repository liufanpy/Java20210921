<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/6
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>index.jsp</h1>
<%-- JSP基本语法 --%>
<%
    // Servlet的Service方法里面可以写啥,这里就可以写啥
    for (int i = 0; i < 10; i++) {
        System.out.println("第" + i + "次循环");
    }

    int num1 = 10;
%>

 <%--Servlet里面字符输出流out的write方法小括号中的内容--%>
<%--out.write(10)--%>
<%=
    10
%>
<%--out.write(num1)--%>
<%=
    num1
%>

<%--Serlvet的类里面可以写啥,这里就可以写啥--%>
<%!
    int num2 = 20;
%>
<%=
    num2
%>

</body>
</html>

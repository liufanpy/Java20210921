<%@ page import="com.itheima.bean.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>08_执行运算</title>
</head>
<body>
<%
    request.setAttribute("num",10);
%>

<h1>EL执行运算: 与java中操作一样</h1>
${10 + 20}<br/>
${10 > 20}<br/>
${num + 20}<br/>

<h1>EL执行运算: 与java中操作不一样</h1>
<%--算术运算符的+号运算符--%>
<%--java中基本类型和字符串相加是拼接--%>
<%--EL中基本类型和字符串相加不能拼接,如果是数组加字符串,并且字符串是数字,会自动格式化,否则会报异常--%>
${num +  "20"}<br/>
<%--${num +  "abc"}<br/>--%>
<hr/>
<%--empty:  判断一个对象是否为null;  判断集合长度是否为0;   判断一个字符串是否为 ""--%>
<%
    User u1 = new User();
    User u2 = null;
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<String> list2 = null;
    String str1 = "";
    String str2 = null;

    request.setAttribute("u1",u1);
    request.setAttribute("u2",u2);
    request.setAttribute("list1",list1);
    request.setAttribute("list2",list2);
    request.setAttribute("str1",str1);
    request.setAttribute("str2",str2);
%>

${empty u1}<br/>
${empty u2}<br/>
${empty list1}<br/>
${empty list2}<br/>
${empty str1}<br/>
${empty str2}<br/>
<hr/>
${not empty u1}<br/>
${not empty u2}<br/>
${not empty list1}<br/>
${not empty list2}<br/>
${not empty str1}<br/>
${not empty str2}<br/>

</body>
</html>

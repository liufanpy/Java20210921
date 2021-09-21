<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/7
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>04_forEach标签</title>
</head>
<body>
<%--普通循环: 循环打印10次hello jsp...--%>
<%--begin: 循环起始位置--%>
<%--end: 循环结束位置--%>
<%--step:步长--%>
<%--var: 存储遍历的变量(域,默认page)--%>
<c:forEach begin="1" end="10" step="1" var="i">
    <font color="red">hello jsp...${i}</font><br/>
</c:forEach>

<%--增强for循环: 循环遍历集合中的元素--%>
<%
    ArrayList<String> list = new ArrayList<>();
    list.add("itheima");
    list.add("itcast");
    list.add("java");
    request.setAttribute("l",list);
%>
<%--items:要迭代的集合或者数组...--%>
<%--varStatus:记录迭代过程中的状态()--%>
<%--
c:forEach中的varStatus属性。
这个对象记录着当前遍历的元素的一些信息：
       		   index:返回索引。从0开始
        		count:返回计数。从1开始
       		    last:是否是最后一个元素
        		first:是否是第一个元素
--%>
<c:forEach items="${l}" var="e" varStatus="status">
    ${e}<br/>
    当前循环的索引:${status.index}<br/>
    当前循环的次数:${status.count}<br/>
    当前迭代出来的元素是否是最后一个元素:${status.last}<br/>
    当前迭代出来的元素是否是第一个元素:${status.first}<br/>
    <hr/>
</c:forEach>


</body>
</html>

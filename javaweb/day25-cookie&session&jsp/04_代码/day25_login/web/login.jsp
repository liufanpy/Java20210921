<%--
  Created by IntelliJ IDEA.
  User: pengzhilin
  Date: 2021/5/6
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<center>
    <h1>用户登录</h1>
    <%
        System.out.println(session.getAttribute("checkCode"));
        // 可以使用的对象: request(HttpServletRequest),response(HttpServletResponse),session(HttpSession),application(ServletContext),config(ServletConfig)
    %>
    <form action="ServletLogin" method="post">
        姓名：<input type="text" name="username" value="${cookie.username.value}"/><br/>
        密码：<input type="password" name="password"/><br/>
        验证码:<input type="text" name="checkCode"><br/>
        <img src="ServletCode" width="200px" height="50px" onclick="getCode(this)"><br/>
        <input type="checkbox" name="remember" value="ok">记住用户名
        <input type="submit" value="登录"/>
    </form>
</center>
</body>
<script>
    function getCode(obj) {
        // 点击一次图片,就修改src属性的值(访问一次ServletCode)
        obj.src = "ServletCode?date="+new Date().getMilliseconds();
    }
</script>

</body>
</html>

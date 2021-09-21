<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<form action="add" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input name="username"/></td>
            <td>${username}</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input name="age"/></td>
            <td>${age}</td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
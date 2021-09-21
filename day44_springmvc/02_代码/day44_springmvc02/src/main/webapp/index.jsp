<%--
  Created by IntelliJ IDEA.
  User: xiaomi
  Date: 2021/6/2
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>提交简单的参数：</h2>
<form action="getSimpleParams">
    用户名: <input type="text" name="username"/><br/>
    密  码: <input type="text" name="password"/><br/>
    <input type="submit">
</form>

<br/>


<h2>提交对象的参数：</h2>
<form action="getObjectParams">
    姓  名: <input type="text" name="name"/><br/>
    金  额: <input type="text" name="money"/><br/>
    <input type="submit">
</form>

<br/>

<h2>提交数组的参数：</h2>
<form action="getArrayParams">
    爱好：
        <input type="checkbox" name="hobby" value="抽烟">抽烟
        <input type="checkbox" name="hobby" value="喝酒">喝酒
        <input type="checkbox" name="hobby" value="烫头">烫头
    <input type="submit">
</form>


<br/>

<h2>提交对象包含对象的参数：</h2>
<form action="getObjectInObjectParams">
    姓  名: <input type="text" name="name"/><br/>
    金  额: <input type="text" name="money"/><br/>

    省  份: <input type="text" name="province"/><br/>
    城  市: <input type="text" name="city"/><br/>

    <input type="submit">
</form>

<br/>


<h2>提交对象包含List的参数：</h2>
<form action="getListInObjectParams">
    姓  名: <input type="text" name="name"/><br/>
    年  龄: <input type="text" name="age"/><br/>

    第一个账户的名称: <input type="text" name="accountList[0].name"/><br/>
    第一个账户的金额: <input type="text" name="accountList[0].money"/><br/>

    第二个账户的名称: <input type="text" name="accountList[1].name"/><br/>
    第二个账户的金额: <input type="text" name="accountList[1].money"/><br/>

    <input type="submit">
</form>

<br/>
<h2>提交对象包含Map的参数：</h2>
<form action="getMapInObjectParams" method="post">
    姓  名: <input type="text" name="name"/><br/>
    年  龄: <input type="text" name="age"/><br/>

    第一个账户的名称: <input type="text" name="accountMap['aa'].name"/><br/>
    第一个账户的金额: <input type="text" name="accountMap['aa'].money"/><br/>

    第二个账户的名称: <input type="text" name="accountMap['bb'].name"/><br/>
    第二个账户的金额: <input type="text" name="accountMap['bb'].money"/><br/>

    <input type="submit">
</form>


<br/>
<h2>提交包含日期的参数：</h2>
<form action="getDateParams" method="get">
    用户名: <input type="text" name="username"/><br/>
    密  码: <input type="text" name="password"/><br/>
    生  日: <input type="date" name="birthday"/><br/>

    <input type="submit">
</form>



<br/>
<h2>使用原始的Servlet API来获取参数：</h2>
<form action="getParams" method="get">
    用户名: <input type="text" name="username"/><br/>
    密  码: <input type="text" name="password"/><br/>
    <input type="submit">
</form>

</body>
</html>

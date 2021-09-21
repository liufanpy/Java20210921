<%--
  Created by IntelliJ IDEA.
  User: xiaomi
  Date: 2021/6/4
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/axios-0.18.0.js"></script>
</head>
<body>
<h2>这是首页</h2>

<h2>使用@RequestBody获取数据</h2>
<form action="requestBody01" method="post">
    <input type="text" name="_method" value="put" hidden>
    用户名: <input type="text" name="username"/><br/>
    密  码: <input type="text" name="password"/><br/>
    <input type="submit">
</form>

<h2>使用@RequestBody获取JSON数据</h2>
<input type="button" value="点我发送json数据" onclick="sendJson()"/>
<script>
    function sendJson(){
        //1. 创建json数据
        var json = {"username":"admin" , "password":"123456"}

        //2. 发请求
        // axios.post("请求地址" , {"a":"b", "c":"d"})
        //axios.post("requestBody02" , json);
        axios.post("requestBody03" , json);
    }
</script>

<h2>使用@PathVariable截取url中的参数</h2>
<a href="delete/3">点我发请求</a>

<h2>使用@RequestHeader获取请求头</h2>
<a href="requestHeader">点我发请求</a>

<h2>使用@Cookie获取Cookie</h2>
<a href="cookieValue">点我发请求</a>


<h2>上传文件（传统）</h2>
<form action="fileUpload" method="post" enctype="multipart/form-data">
    文件： <input type="file" name="file"/><br/>
    <input type="submit"/>
</form>

<h2>上传文件（跨服务器）</h2>
<form action="fileUpload02" method="post" enctype="multipart/form-data">
    文件： <input type="file" name="file"/><br/>
    <input type="submit"/>
</form>


</body>
</html>

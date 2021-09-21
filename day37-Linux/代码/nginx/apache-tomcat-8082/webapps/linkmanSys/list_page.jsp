<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap模板</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">显示所有联系人</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <%--
            1.获取request作用域中pageBean对象 拿到每页要显示的联系人集合数据  page.list
            2.使用forEach标签遍历 每遍历一次  就显示一个联系人信息
        --%>
        <c:forEach items="${page.list}" var="linkman">
            <tr>
                <td>${linkman.id}</td>
                <td>${linkman.name}</td>
                <td>${linkman.sex}</td>
                <td>${linkman.age}</td>
                <td>${linkman.address}</td>
                <td>${linkman.qq}</td>
                <td>${linkman.email}</td>
                <td><a class="btn btn-default btn-sm" href="修改联系人.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="修改联系人.html">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8" align="center">
				<ul class="pagination success">
                    <%--判断当前页码是否大于一  大于1就显示上一页--%>
                    <c:if test="${page.pageNum >1}">
                        <li ><a href="linkMan?method=findPage&curPageNo=${page.pageNum-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                    </c:if>
                    <%--
                        1.遍历显示所有页码  根据总页数进行遍历
                        2.判断当前页码是哪一页 如果是当前页就高亮显示
                        3.设置指定页码跳转   linkMan?method=findPage&curPageNo=${i}
                        4.设置上一页  linkMan?method=findPage&curPageNo=${page.curPageNo-1}
                            添加判断：是不是首页   ${page.curPageNo >1}
                        5.设置下一页  linkMan?method=findPage&curPageNo=${page.curPageNo+1}
                            添加判断：是否是尾页  ${page.curPageNo < page.totalPage}
                    --%>
					<c:forEach var="i" begin="1" end="${page.pages}">
                        <c:choose>
                            <%--如果遍历的页码刚好是当前页码 高亮显示--%>
                            <c:when test="${i eq page.pageNum}">
                                <li class="active"><a href="linkMan?method=findPage&curPageNo=${i}">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="linkMan?method=findPage&curPageNo=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <%--判断当前页码是不是大于总页数  如果不大于 则会存在下一页--%>
					<c:if test="${page.pageNum < page.pages}">
                        <li><a href="linkMan?method=findPage&curPageNo=${page.pageNum+1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
                    </c:if>
				</ul>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

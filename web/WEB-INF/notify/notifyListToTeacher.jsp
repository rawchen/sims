<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>公告列表</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
</head>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/teacher/tHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/teacher/teacherNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <span class="layui-breadcrumb">
                <a>教师端</a>
                <a><cite>公告列表</cite></a>
            </span>
            <p> &nbsp;</p>

            <table class="layui-table" lay-filter="test">
                <thead>
                <tr>
                    <th>公告ID</th>
                    <th>公告日期</th>
                    <th>公告内容</th>
                </tr>
                </thead>

                <c:forEach items="${notifys}" var="notify" varStatus="n">
                    <tr>
                        <td>${n.count}</td>
                        <td>${notify.notifyDate}</td>
                        <td>${notify.notifyInfo}</td>
                    </tr>
                </c:forEach>
            </table>

            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>



<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
</body>
</html>


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
<jsp:include page="/WEB-INF/admin/aHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/adminNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <span class="layui-breadcrumb">
                <a>管理员</a>
                <a>系统管理</a>
                <a><cite>公告列表</cite></a>
            </span>
            <p> &nbsp;</p>

            <table class="layui-table" lay-filter="test">
                <thead>
                <tr>
                    <th><input type="checkbox" class="my-checkbox" name="" title="" lay-skin="primary"></th>
                    <th>公告ID</th>
                    <th>公告日期</th>
                    <th>公告内容</th>
                    <th>操作</th>
                </tr>
                </thead>

                <c:forEach items="${notifys}" var="notify" varStatus="n">
                    <tr>
                        <th><input type="checkbox" class="my-checkbox" name="" title="" lay-skin="primary"></th>
                        <td>${n.count}</td>
                        <td>${notify.notifyDate}</td>
                        <td>${notify.notifyInfo}</td>
                        <td><a class="layui-btn layui-btn-danger" href="javascript:deleteNotify(${notify.id});">删除</a></td>
                    </tr>
                </c:forEach>
            </table>

            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>


<script type="text/javascript">
    $("#nav li:nth-child(5) dl dd:nth-child(2)").addClass("layui-this");
    $("#nav li:nth-child(5)").addClass("layui-nav-itemed");
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>

<script>
    function deleteNotify(n_id) {
        if (confirm("你确定删除该通知吗？")) {
            location.href = "${pageContext.request.contextPath}/deleteNotifyServlet?id=" + n_id;
        }
    }
</script>
</body>
</html>


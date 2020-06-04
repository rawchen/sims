<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>可选课程</title>
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
                    <a href="">管理员</a>
                    <a href="">选课信息管理</a>
                    <a><cite>可选课程</cite></a>
                </span>
                <span style="color: red;margin-right: 100px;float: right;">${select_msg}</span>
            <table class="layui-table" lay-filter="test">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>课程号</th>
                    <th>课程名</th>
                    <th>课程简介</th>
                    <th>教师号</th>
                    <th>教师姓名</th>
                    <th>操作</th>
                </tr>
                </thead>

                <c:forEach items="${optionalcourses}" var="optionalcourse" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${optionalcourse.c_id}</td>
                        <td>${optionalcourse.c_name}</td>
                        <td>${optionalcourse.c_info}</td>
                        <td>${optionalcourse.t_id}</td>
                        <td>${optionalcourse.t_name}</td>
                        <td><a class="layui-btn layui-btn-danger" href="javascript:deleteCourse(${optionalcourse.c_id});">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>


<script type="text/javascript">
    $("#nav li:nth-child(1) dl dd:nth-child(2)").addClass("layui-this");
    $("#nav li:nth-child(1)").addClass("layui-nav-itemed");
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
<script>
    function deleteCourse(c_id) {
        if (confirm("你确定删除该学生吗？")) {
            location.href = "${pageContext.request.contextPath}/doDeleteSelectCourseServlet?cid=" + c_id;
        }
    }
</script>

</body>
</html>


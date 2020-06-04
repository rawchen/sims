<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的授课</title>
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
                    <a href="">教师端</a>
                    <a href="">课程信息</a>
                    <a><cite>学生成绩</cite></a>
                </span>
            <table class="layui-table" lay-filter="test">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>学号</th>
                    <th>学生姓名</th>
                    <th>课程号</th>
                    <th>课程名</th>
                    <th>课程简介</th>
                    <th>学生分数</th>
                    <td>操作</td>
                </tr>
                </thead>

                <c:forEach items="${scs}" var="sc" varStatus="t">
                    <tr>
                        <td>${t.count}</td>
                        <td>${sc.s_id}</td>
                        <td>${sc.s_name}</td>
                        <td>${sc.c_id}</td>
                        <td>${sc.c_name}</td>
                        <td>${sc.c_info}</td>
                        <td>${sc.score}</td>
                        <td><a class="layui-btn layui-btn-normal" href="${pageContext.request.contextPath}/updateScoreServlet?cid=${sc.c_id}&sid=${sc.s_id}">修改分数</a><a class="layui-btn layui-btn-danger" href="javascript:deleteStudentSelectCourse();">删除</a></td>
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
    $("#hidden-score").removeAttr("hidden");
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
<script type="text/javascript">
    function deleteOptionalCourse(c_id) {
        if (confirm("你确定删除授课吗？")) {
            location.href = "${pageContext.request.contextPath}/deleteOptionalCourseServlet?cid=" + c_id;
        }
    }
</script>
</body>
</html>

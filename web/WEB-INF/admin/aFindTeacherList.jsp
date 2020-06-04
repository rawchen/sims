<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询教师</title>
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
                    <a href="">教师管理</a>
                    <a><cite>查询教师</cite></a>
                </span>
                <table class="layui-table" lay-filter="test">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>工号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>文化程度</th>
                        <th>职称</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <c:forEach items="${teachers}" var="teacher" varStatus="t">
                        <tr>
                            <td>${t.count}</td>
                            <td>${teacher.t_id}</td>
                            <td>${teacher.t_name}</td>
                            <td>${teacher.t_sex}</td>
                            <td>${teacher.t_education}</td>
                            <td>${teacher.t_title}</td>
                            <td><a class="layui-btn layui-btn-normal" href="${pageContext.request.contextPath}/updateTeacherServlet?tid=${teacher.t_id}">修改</a><a class="layui-btn layui-btn-danger" href="javascript:deleteTeacher(${teacher.t_id});">删除</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <jsp:include page="/footer.jsp"></jsp:include>
            </div>
        </div>
    </div>


<script type="text/javascript">
    $("#nav li:nth-child(3) dl dd:nth-child(1)").addClass("layui-this");
    $("#nav li:nth-child(3)").addClass("layui-nav-itemed");
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
<script>
    function deleteTeacher(t_id) {
        if (confirm("你确定删除该教师吗？")) {
            location.href = "${pageContext.request.contextPath}/deleteTeacherServlet?tid=" + t_id;
        }
    }
</script>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test" id="nav">
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">选课信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/studentSelectCourseListServlet">选课列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/studentOptionalCourseServlet">可选课程</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">学生管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findStudentByPageServlet">查询学生</a></dd>
                        <dd hidden id="hidden-update"><a href="#">修改学生信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addStudentServlet">增加学生</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/teacherListServlet">查询教师</a></dd>
                        <dd hidden id="hidden-update2"><a href="#">修改教师信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/addTeacherServlet">增加教师</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">学院专业管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/cdcListServlet">学院专业查询</a></dd>
                        <dd><a href="#">学院专业增加</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">系统管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/notifyServlet">公告发布</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/notifyListServlet">公告列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/fileServlet">文件发布</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/fileListServlet">文件列表</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/adminPasswordIndexServlet">修改密码</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>

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
                    <a class="" href="javascript:;">选课信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/studentSelectCourseListServlet">选课与成绩</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/studentOptionalCourseServlet">可选课程</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">学生通讯录</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/findStudentByPageServlet">本院学生信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">教师通讯录</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/teacherListServlet">本院教师信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">学院专业信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/cdcListServlet">学院专业查询</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">个人信息管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${pageContext.request.contextPath}/studentInfomationServlet">个人信息</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/studentPasswordIndexServlet">修改密码</a></dd>
                        <dd><a href="${pageContext.request.contextPath}/fileListServlet">文件列表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
</div>
<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
</body>
</html>

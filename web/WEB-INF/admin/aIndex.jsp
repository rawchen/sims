<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${html_title}</title>
    <script>
        //JavaScript代码区域
        layui.use('element', function(){
            var element = layui.element;
            element.init();
        });
    </script>
    <style>
        .layui-card .layui-card-body .layui-icon {
            display: inline-block;
            width: 100%;
            height: 60px;
            line-height: 60px;
            text-align: center;
            border-radius: 2px;
            font-size: 30px;
            background-color: #F8F8F8;
            color: #333;
            transition: all .3s;
            -webkit-transition: all .3s;
        }
        .layui-card .layui-card-body {
            text-align: center;
        }
        #notify {
            text-align: left;
        }

    </style>
</head>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/aHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/admin/adminNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="layui-card">
                <div class="layui-card-header" id="index-function">功能</div>
                <div class="layui-card-body">
                    <ul class="layui-row layui-col-space10 layui-this">
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/student/query">
                                <i class="layui-icon layui-icon-survey"></i>
                                <cite>选课列表</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/class/query">
                                <i class="layui-icon layui-icon-survey"></i>
                                <cite>可选课程</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/major/query">
                                <i class="layui-icon layui-icon-survey"></i>
                                <cite>查询学生</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/user/info">
                                <i class="layui-icon layui-icon-user"></i>
                                <cite>增加学生</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/user/password">
                                <i class="layui-icon layui-icon-set"></i>
                                <cite>查询教师</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/user/email">
                                <i class="layui-icon layui-icon-set"></i>
                                <cite>增加教师</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/student/modify">
                                <i class="layui-icon layui-icon-survey"></i>
                                <cite>学院专业查询</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/student/modify">
                                <i class="layui-icon layui-icon-survey"></i>
                                <cite>学院专业增加</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/student/modify">
                                <i class="layui-icon layui-icon-survey"></i>
                                <cite>公告发布</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/student/modify">
                                <i class="layui-icon layui-icon-survey"></i>
                                <cite>公告列表</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/student/modify">
                                <i class="layui-icon layui-icon-survey"></i>
                                <cite>文件发布</cite>
                            </a>
                        </li>
                        <li class="layui-col-xs3">
                            <a lay-href="/mavenTemplate/student/modify">
                                <i class="layui-icon layui-icon-survey"></i>
                                <cite>文件列表</cite>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-header">学校最新公告</div>
                <c:forEach items="${notifys}" var="notify">
                    <div class="layui-card-body" id="notify">${notify.notifyInfo}<p>${notify.notifyDate}</div>
                </c:forEach>
            </div>
        </div>
    </div>
    <jsp:include page="/footer.jsp"></jsp:include>
</div>
<script type="text/javascript">
    document.onkeydown = function(e) {
        e = window.event || e;
        var k = e.keyCode;
    }
</script>
<script type="text/javascript">
    $("#nav li:nth-child(1)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(2)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(3)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(4)").addClass("layui-nav-itemed");
    $("#nav li:nth-child(5)").addClass("layui-nav-itemed");
</script>
</body>
</html>

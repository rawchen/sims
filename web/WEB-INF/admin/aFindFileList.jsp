<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>文件列表</title>
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
                    <a href="">系统设置</a>
                    <a><cite>文件列表</cite></a>
                </span>
            <table class="layui-table" lay-filter="test">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>文件名</th>
                    <th>文件路径</th>
                    <th>文件大小</th>
                    <th>操作</th>
                </tr>
                </thead>

                <c:forEach items="${fileLists}" var="filelist" varStatus="f">
                    <tr>
                        <td>${f.count}</td>
                        <td>${filelist.fileName}</td>
                        <td>${filelist.filePath}</td>
                        <td>${filelist.fileSize}</td>
                        <td><a class="layui-btn layui-btn-normal" href="${pageContext.request.contextPath}/downloadServlet?filename=${filelist.fileName}">下载</a><a class="layui-btn layui-btn-danger" href="${pageContext.request.contextPath}/deleteFileServlet?filename=${filelist.fileName}">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>


<script type="text/javascript">
    $("#nav li:nth-child(5) dl dd:nth-child(4)").addClass("layui-this");
    $("#nav li:nth-child(5)").addClass("layui-nav-itemed");
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
</body>
</html>
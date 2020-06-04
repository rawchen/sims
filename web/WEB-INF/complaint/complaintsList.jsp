<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>公告发布</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.ckeditor.com/4.14.0/full/ckeditor.js"></script>
    <style type="text/css">
        .input-block {
            margin-left: 0px;
            min-height: 36px;
        }
        #addcomplaintsbutton {
            text-align: center;
        }
        .layui-btn {
            width: 30%;
        }
    </style>
</head>
<body class="layui-layout-body" style="background-color: #F2F2F2">
<jsp:include page="/filterLogin.jsp"></jsp:include>
<jsp:include page="/WEB-INF/student/sHeader.jsp"></jsp:include>
<jsp:include page="/WEB-INF/student/studentNav.jsp"></jsp:include>
<div class="layui-layout layui-layout-admin">
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <span class="layui-breadcrumb">
                <a>学生端</a>
                <a><cite>小吐槽</cite></a>
            </span>
            <p> &nbsp;</p>
            <form action="${pageContext.request.contextPath}/addComplaintsServlet" method="post">
                <div class="input-block">
                    <textarea name="complaint" placeholder="请输入吐槽内容" required lay-verify="required" class="layui-textarea"></textarea>
                    <script>
                        CKEDITOR.replace( 'complaint' );
                    </script>
                    <p>
                </div>
                <%--    <input type="text" name="notifyInfo" />--%>
                <div id="addcomplaintsbutton">
                    <button type="submit" class="layui-btn">发布</button>
                </div>
            </form>
            <c:forEach items="${complaints}" var="complaint">
                <div class="layui-card">
                    <div class="layui-card-header">吐槽ID：${complaint.id} | ${complaint.cdate}</div>
                    <div class="layui-card-body" id="" style="line-height: 30px;">${complaint.content}</div>
                </div>
            </c:forEach>

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


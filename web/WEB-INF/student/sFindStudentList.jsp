<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息查询</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
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
                    <a href="">学生端</a>
                    <a href="">学生通讯录</a>
                    <a><cite>本院学生信息</cite></a>
                </span>
                <form style="padding-top: 20px;" action="${pageContext.request.contextPath}/findStudentByPageServlet" method="post">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label" style="width: auto;">学号</label>
                            <div class="layui-input-inline">
                                <input type="tel" name="s_id" value="${condition.s_id[0]}" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label" style="width: auto;">姓名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="s_name" value="${condition.s_name[0]}" autocomplete="off" class="layui-input">
                            </div>

                            <div class="layui-input-inline">

                                <button type="submit" class="layui-btn">查询</button>
                            </div>
                        </div>
                    </div>
                </form>


                <table class="layui-table" lay-filter="test">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>学号</th>
                        <th>学院</th>
                        <th>系别</th>
                        <th>班级</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>城市</th>
                        <th>手机号</th>
                        <th>邮箱</th>
                    </tr>
                    </thead>

                    <c:forEach items="${pb.list}" var="student" varStatus="s">
                        <tr style="height: 70px;">
                            <td>${s.count}</td>
                            <td>${student.s_id}</td>
                            <td>${student.s_college}</td>
                            <td>${student.s_department}</td>
                            <td>${student.s_class}</td>
                            <td>${student.s_name}</td>
                            <td>${student.s_sex}</td>
                            <td>${student.s_age}</td>
                            <td>${student.s_address}</td>
                            <td>${student.s_phone}</td>
                            <td>${student.s_email}</td>
                        </tr>
                    </c:forEach>
                </table>
                <ul>

                    <c:if test="${pb.currentPage == 1}">
                    <a href ="javascript:return false;">
                        </c:if>
                        <c:if test="${pb.currentPage != 1}">
                        <a href="${pageContext.request.contextPath}/findStudentByPageServlet?currentPage=${pb.currentPage-1}&rows=5&s_id=${condition.s_id[0]}&s_name=${condition.s_name[0]}">
                            </c:if>

                            <li class="page-li">上一页</li></a>
                    </a>
                    <c:forEach begin="1" end="${pb.totalPage}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <a href="${pageContext.request.contextPath}/findStudentByPageServlet?currentPage=${i}&rows=5&s_id=${condition.s_id[0]}&s_name=${condition.s_name[0]}"><li class="page-li" style="background-color: #009688;border-radius: 2px;color: white;">${i}</li></a>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <a href="${pageContext.request.contextPath}/findStudentByPageServlet?currentPage=${i}&rows=5&s_id=${condition.s_id[0]}&s_name=${condition.s_name[0]}"><li class="page-li">${i}</li></a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pb.currentPage == pb.totalPage}">
                    <a href="javascript:return false;">
                        </c:if>
                        <c:if test="${pb.currentPage != pb.totalPage}">
                        <a href="${pageContext.request.contextPath}/findStudentByPageServlet?currentPage=${pb.currentPage+1}&rows=5&s_id=${condition.s_id[0]}&s_name=${condition.s_name[0]}">
                            </c:if>
                            <li class="page-li">下一页</li></a>
                </ul>

                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px;">
                    <legend>共${pb.totalCount}条记录，共${pb.totalPage}页</legend>
                </fieldset>
                <jsp:include page="/footer.jsp"></jsp:include>
            </div>
        </div>
    </div>


<script type="text/javascript">
    $("#nav li:nth-child(2) dl dd:nth-child(1)").addClass("layui-this");
    $("#nav li:nth-child(2)").addClass("layui-nav-itemed");
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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
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
                <a><cite>增加教师</cite></a>
            </span>
            <form class="layui-form" action="${pageContext.request.contextPath}/addTeacherInfoServlet" style="padding-top: 50px" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">工号</label>
                    <div class="layui-input-block">
                        <input type="text" name="teacher-id" required lay-verify="required" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">学院</label>
                    <div class="layui-input-block">
                        <select name="selectCollege">

                            <option selected></option>

                            <c:forEach items="${collegeLists}" var="collegeList">
                                <option value="${collegeList.college}">${collegeList.college}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">系别</label>
                    <div class="layui-input-block">
                        <select name="selectDepartment" lay-search>
                            <option selected></option>
                            <c:forEach items="${departmentLists}" var="departmentList">
                                <option>${departmentList.department}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">班级</label>
                    <div class="layui-input-block">
                        <select name="selectClass" lay-search>
                            <option selected></option>
                            <c:forEach items="${classLists}" var="classList">
                                <option>${classList.cclass}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="teacher-name" id="teacher-name" placeholder="" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">

                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="teacher-sex" id="idsex" value="男" title="男">
                            <input type="radio" name="teacher-sex" id="idsex2" value="女" title="女">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">文化程度</label>
                        <div class="layui-input-block">
                            <input type="text" name="teacher-education" id="teacher-education" placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">职称</label>
                        <div class="layui-input-block">
                            <input type="text" name="teacher-title" id="teacher-title" placeholder="" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
                        <button class="layui-btn layui-btn-primary" type="reset">重置</button>
                        <span style="padding-left: 20px;">${update_msg}</span>
                    </div>
                </div>
            </form>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>


<script type="text/javascript">
    $("#nav li:nth-child(3) dl dd:last-child").addClass("layui-this");
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
    layui.use('form', function(){

    });
</script>
</body>
</html>




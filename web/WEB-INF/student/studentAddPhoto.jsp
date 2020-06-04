<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/file.css">
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
                <a><cite>修改头像</cite></a>
            </span>
            <p style="text-align: center;">
                <img id="sphoto" src="${pageContext.request.contextPath}/showPhotoServlet" style="border: solid #009688;padding: 10px;margin: 20px;text-align: center;width: 100px;">

            </p>
            <p style="text-align: center;">
                <span id="filename"></span>
                <span id="filesize"></span>
            </p>
            <form name="formf" method="post" enctype="multipart/form-data" style="text-align: center;">
                    <a href="javascript:;" class="file">选择文件
                        <input id="selectfiles" accept="image/jpeg,image/gif" type="file" name="myfile">
                    </a>
                    <a href="javascript:;" class="file" type="submit">开始上传
                        <input type="submit"  id="postfiles" value="upload">
                    </a>
                </form>
            <p style="text-align: center;">
                <span id="msg">${update_msg}</span>
            </p>
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

<script>
    //Demo
    layui.use('form', function(){

    });
</script>
<script>
    $('#selectfiles').change(function(e){
        // console.log($(this).val());//val()获取到的是完整的文件路径值；C:\fakepath\js-dom.png

        //前端替换图片
        var fileObj = document.getElementById("selectfiles").files[0];
        var filepath = window.URL.createObjectURL(fileObj);
        $('#sphoto').attr('src',filepath);

        $('#news').text("");

        var fileMsg = e.currentTarget.files;

        var fileName = fileMsg[0].name;

        var fileSize = fileMsg[0].size;

        var fileType = fileMsg[0].type;

        $('#filename').text(fileName);
        $('#filesize').text('('+getfilesize(fileSize)+')');
        $('#msg').text('');

        function getfilesize(size) {
            if (!size)
                return "";

            var num = 1024.00; //byte

            if (size < num)
                return size + "B";
            if (size < Math.pow(num, 2))
                return (size / num).toFixed(2) + "K"; //kb
            if (size < Math.pow(num, 3))
                return (size / Math.pow(num, 2)).toFixed(2) + "M"; //M
            if (size < Math.pow(num, 4))
                return (size / Math.pow(num, 3)).toFixed(2) + "G"; //G
            return (size / Math.pow(num, 4)).toFixed(2) + "T"; //T
        }

    });
    $('#postfiles').click(function(){
        var fileInput = $('#selectfiles').get(0).files[0];
        if (fileInput == null) {
            alert("请先选择文件！");
            return;
        } else {
            document.formf.action="${pageContext.request.contextPath}/uploadImageServlet";
        }
    });
</script>

</body>
</html>


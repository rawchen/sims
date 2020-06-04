<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <title>文件传输</title>
    <link rel="stylesheet" href="./css/file.css"/>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <script src="./layui.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
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
                <a>管理员</a>
                <a>系统管理</a>
                <a><cite>文件发布</cite></a>
            </span>
            <p> &nbsp;</p>

            <div id="center-file" style="padding-left: 41%;">
                <h2>文件上传</h2>
                <ol>
                    <li>可上传任意大小任意类型文件 </li>
                </ol>
                <br>
                <form enctype="multipart/form-data" method="POST"  name="formf">
                    <h4>请选择上传文件：</h4>
                    <div id="ossfile"><span id="filename"></span>
                        <span id="filesize"></span>
                        <b>
                            <span id="percentage"></span>
                        </b>
                        <div class="progress"><div class="progress-bar" style="width: 100%;"></div></div></div>

                    <br/>


                    <div id="container">


                        <a href="javascript:;" class="file">选择文件
                            <input id="selectfiles" type="file" name="myfile">
                        </a>

                        <a href="javascript:;" class="file" type="submit">开始上传
                            <input type="submit"  id="postfiles" value="upload">
                        </a>
                    </div>
                    <p> </p>
                    <span id="news">${news}</span>
                </form>
            </div>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
    $("#nav li:nth-child(5) dl dd:nth-child(3)").addClass("layui-this");
    $("#nav li:nth-child(5)").addClass("layui-nav-itemed");
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.init();
    });
</script>
<script>
    $('#selectfiles').change(function(e){
        // console.log($(this).val());//val()获取到的是完整的文件路径值；C:\fakepath\js-dom.png
        $('#news').text("");
        var fileMsg = e.currentTarget.files;

        var fileName = fileMsg[0].name;

        var fileSize = fileMsg[0].size;

        var fileType = fileMsg[0].type;

        $('#filename').text(fileName);
        $('#filesize').text('('+getfilesize(fileSize)+')');
        $('#percentage').text('0%');
        $('.progress-bar').css("width","0%");

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
        } else {
            document.formf.action="${pageContext.request.contextPath}/uploadServlet";

        }
        $('.inp_file').val(null);
    });

</script>
</html>
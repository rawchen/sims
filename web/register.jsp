<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册页</title>
    <link rel="stylesheet" href="./css/layui.css">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/login.css">
    <link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon" />
</head>
<body>
<div class="frame-main">
    <div class="login-main">
        <header class="layui-elip">学生信息管理系统</header>

        <!-- 表单选项 -->
        <form class="layui-form" id="registerForm" action="${pageContext.request.contextPath}/registerServlet" method="post">
            <div class="layui-input-inline">
                <!-- 用户名 -->
                <div class="layui-inline" style="width: 100%">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username"></label>
                    <input type="text" id="user" value="${studentid}" name="studentid" required  lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
                </div>

            </div>
            <!-- 密码 -->
            <div class="layui-input-inline">
                <div class="layui-inline" style="width: 100%">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password"></label>
                    <input type="password" id="pwd" value="${password}" name="password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <!-- 确认密码 -->
            <div class="layui-input-inline">
                <div class="layui-inline" style="width: 100%">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password"></label>
                    <input type="password" id="rpwd" value="${repassword}" name="repassword" required  lay-verify="required" placeholder="请确认密码" autocomplete="off" class="layui-input">
                </div>
            </div>

            <div class="layui-input-inline" style="width: 56%;">
                <label class="layadmin-user-login-icon layui-icon layui-icon-vercode"></label>
                <input type="password" id="verifycode" name="verifycode" required lay-verify="required" placeholder="验证码" autocomplete="off"
                       class="layui-input">
            </div>
            <a href="javascript:refreshCode()">
                <img style="padding-left: 14px; margin-top: -15px;" src="${pageContext.request.contextPath}/checkCodeServlet" title="刷新验证码" id="vcode" draggable="false">
            </a>


            <div class="layui-input-inline login-btn" style="width: 100%">
                <button type="submit" lay-submit lay-filter="sub" class="layui-btn">注册</button>
            </div>
            <hr style="width: 100%" />
            <p style="width: 100%">
                <a href="login.jsp" class="fl">立即登录</a>
            <div class="tooltip">
                <span class="tooltiptext">${msg}</span>
            </div>
                <a href="forget.jsp" class="fr">忘记密码？</a></p>
            <i class="layui-icon" id="ri" style="color: green;font-weight: bolder; position: relative; left: 200px; top: -265px;" hidden></i>
            <i class="layui-icon" id="wr" style="color: red; font-weight: bolder; position: relative; left: 200px; top: -265px;" hidden>ဆ</i>
            <i class="layui-icon" id="pri" style="color: green;font-weight: bolder; position: relative; left: 180px; top: -213px;" hidden></i>
            <i class="layui-icon" id="pwr" style="color: red; font-weight: bolder; position: relative; left: 180px; top: -213px;" hidden>ဆ</i>
            <i class="layui-icon" id="rpri" style="color: green;font-weight: bolder; position: relative; left: 160px; top: -160px;" hidden></i>
            <i class="layui-icon" id="rpwr" style="color: red; font-weight: bolder; position: relative; left: 160px; top: -160px;" hidden>ဆ</i>
        </form>
    </div>
    <span id="s_id"></span>
</div>
<footer style="position:absolute;bottom:0;width:100%;height:30px; text-align: center;">© 2018-2019.YOYLING.COM</footer>

<script src="layui.js"></script>
<script type="text/javascript">
    function refreshCode() {
        var vcode = document.getElementById("vcode");
        vcode.src = "${pageContext.request.contextPath}/checkCodeServlet?time="+new Date().getTime();
    }
</script>
<script type="text/javascript">
    layui.use(['form','jquery','layer'], function () {
        var form   = layui.form;
        var $      = layui.jquery;
        var layer  = layui.layer;
        //添加表单失焦事件
        //验证表单
        $('#user').blur(function() {
            var studentid = $(this).val();
            $.get("findStudentServlet",{studentid:studentid},function (data) {
                if (data.studentExsit) {
                    $('#wr').removeAttr('hidden');
                    $('#ri').attr('hidden','hidden');
                    layer.open({
                        title: '错误',content: data.msg,icon: 2
                    });
                    $('#user').val("");

                } else {
                }
            });
        });


        // 为密码添加正则验证
        $('#pwd').blur(function() {
            var reg = /^[\w]{3,12}$/;
            if(!($('#pwd').val().match(reg))){
                //layer.msg('请输入合法密码');
                $('#pwr').removeAttr('hidden');
                $('#pri').attr('hidden','hidden');
                layer.msg('请输入3-6位合法密码');
                $('#pwd').val("");
            }else {
                $('#pri').removeAttr('hidden');
                $('#pwr').attr('hidden','hidden');
            }
        });
        $('#user').blur(function() {
            var reg = /^[0-9]{10}$/;
            if(!($('#user').val().match(reg))){
                //layer.msg('请输入合法密码');
                $('#wr').removeAttr('hidden');
                $('#ri').attr('hidden','hidden');
                layer.msg('请输入10位数字学号');
                $('#user').val("");
            }else {
                $('#ri').removeAttr('hidden');
                $('#wr').attr('hidden','hidden');
            }
        });



        //验证两次密码是否一致
        $('#rpwd').blur(function() {
            if($('#pwd').val() != $('#rpwd').val() || $('#rpwd').val()=='' || $('#pwd').val()==''){
                $('#rpwr').removeAttr('hidden');
                $('#rpri').attr('hidden','hidden');
                // layer.msg('两次输入密码不一致!');
                $('#rpwd').val("");
            }else{
                $('#rpri').removeAttr('hidden');
                $('#rpwr').attr('hidden','hidden');
            };
        });
    });
</script>
</body>
</html>
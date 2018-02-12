<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/2/6
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div>
    <h2>登录</h2>
    账号：<input type="text" id="userName">
    密码：<input type="password" id="pwd">
    <input type="submit" value="登录" onclick="login()">
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
<script>
    function login() {
        let data ={
            userName:$("#userName").val(),
            pwd:$("#pwd").val(),
        };
        $.ajax({
            url:"/login",
            type:"post",
            data,
            success(data){
                if(data.mes.type){
                    window.location.href = "/index"
                }
            }
        })
    }
</script>
</body>
</html>

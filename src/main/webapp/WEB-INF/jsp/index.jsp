<%@ page language='java' contentType='text/html; charset=UTF-8' %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>app</title>
<body>
    <button onclick="login()">登录</button>
    <button onclick="isLogin()">判断登录</button>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
<script>
    function login() {
        $.ajax({
            url:"/login",
            type:"post",
            data:{
                userName:"528386631",
                pwd:"0"
            },
            success:function (data) {
                console.log(data)
            }
        })
    }
    function isLogin() {
        $.ajax({
            url:"/isLogin",
            type:"post",
            data:{
                userName:"528386631",
                pwd:"0"
            },
            success:function (data) {
                console.log(data)
            }
        })
    }
</script>
</body>
</html>

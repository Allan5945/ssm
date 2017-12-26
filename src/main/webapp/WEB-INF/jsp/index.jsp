<%@ page language='java' contentType='text/html; charset=UTF-8' %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>app</title>
<body>
    <button onclick="login()">登录</button>
    <button onclick="init()">获取数据</button>
    <button onclick="addItemData()">插入数据</button>
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
    function init() {
        $.ajax({
            url:"/initData",
            type:"post",
            success:function (data) {
                console.log(data)
            }
        })
    }
    function addItemData() {
        $.ajax({
            url:"/addItemData",
            type:"post",
            data:{
                sdata:"2017.1.1",
                edata:"2018.2.1",
                zk:"7",
                bz:"6"
            },
            success:function (data) {
                console.log(data)
            }
        })
    }
</script>
</body>
</html>

<%@ page language='java' contentType='text/html; charset=UTF-8' %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>app</title>
<body>
    <button onclick="login('528386631')">登录528386631</button>
    <button onclick="login('352563349')">登录352563349</button></br>
    <button onclick="init()">获取数据</button></br>
    <button onclick="clockInStart()">开始打卡</button>
    <button onclick="addItemData()">结束打卡</button></br>
    <button onclick="deleteItemData()">删除数据</button></br>
    <button onclick="webscoket()">连接ws</button></br>
    <button onclick="sendWebscoket()">发送消息</button></br>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
<script>
    var ws;
    var userId = "";
    function login(user) {
        $.ajax({
            url:"/login",
            type:"post",
            data:{
                userName:user,
                pwd:"0"
            },
            success:function (data) {
                userId = data.mes.data[0].id;
                console.log(data)
            }
        })
    }
    function init() {
        $.ajax({
            url:"/initData",
            type:"post",
            headers: {
                Origin: "application/json; charset=utf-8"
            },
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
    function deleteItemData() {
        $.ajax({
            url:"/deleteItemData",
            type:"post",
            data:{
                columId:10
            },
            success:function (data) {
                console.log(data)
            }
        })
    };
    function webscoket() {
        ws = new WebSocket('ws://localhost:8000/websocket?' + userId);
        ws.onopen = function (event) {
            console.log("打开连接");
        };
        ws.onclose = function (event) {
            console.log("关闭连接");
        };
        ws.onmessage = function (event) {
            console.log("收到消息",event.data);
        };
        ws.onerror = function (event) {
            console.log("程序出错了")
        };
    }

    function sendWebscoket() {
        var df = 1;
        if (userId == 1){
            df = 2;
        }
        $.ajax({
            url:"/sendMes",
            type:"post",
            data:{
                df:df
            },
            success:function (data) {
//                console.log(data)
            }
        })
    }

    function clockInStart() {
        $.ajax({
            url:"/clockInStart",
            type:"post",
            data:{
                bz:"准备学习一哈哈"
            },
            success:function (data) {
                console.log(data)
            }
        })
    }
</script>
</body>
</html>

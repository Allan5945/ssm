<%@ page language='java' contentType='text/html; charset=UTF-8' %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <style>
        div{
            color: #5fcd9e;
            color: #2f2fff;
        }
    </style>
<body>
<div id="box">
    <div id="list-hys">
        <h4>历史打卡记录</h4>
        <ul id="list-hys-item"></ul>
    </div>
    <div id="begin-box">
        <h3>开始打卡</h3>
        备注：<input type="text" id="begin-box-bz">
        <input type="button" value="开始打卡" onclick="beginDk()">
    </div>
    <div id="begin-ing"></div>
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
<script src="static/js/index.js"></script>
</body>
</html>

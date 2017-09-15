<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<link rel="icon" href="http://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=img&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&cs=320009444,2072114424&os=2919588744,2276738289&simid=140401568,672352480&pn=2&rn=1&di=186645036270&ln=1977&fr=&fmq=1505436696847_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fimg0.ph.126.net%2F5hSGjvSCnM13ynwBuRvOYQ%3D%3D%2F6619286498607028755.jpg&rpstart=0&rpnum=0&adpicid=0" type="image/gif" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
<script src="https://cdn.bootcss.com/jquery/2.1.0-rc1/jquery.min.js"></script>
<%--<h3>45555</h3>--%>
<%--<h5>dddd</h5>--%>
</body>
<script>
	$.ajax({
		url:"/authCode",
		 type: 'post',
	    dataType:'jsonp',
	    jsonp: "callback",
	    data: {
	        "type":'0',
	        "mobilePhone": $("#tel").val()
	    },
	    success:function(data){
	       console.log(data);
	    }
	});
	$.ajax({
		url:"/login",
		 type: 'post',
	   
	    success:function(data){
	       console.log(data);
	    }
	});
</script>
</html>
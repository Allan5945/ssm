<%@ page language='java' contentType='text/html; charset=UTF-8' %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>主页</title>
<body>
<div id="box">
    <ul>
        <li></li>
    </ul>
</div>


<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
<script>
    function initData() {
        $.ajax({
            url:"/initData",
            type:"post",
            success:function (data) {
                console.log(data)
            }
        })
    }
    $.ajax({
        url:"/initDatas",
        type:"post",
        success:function (data) {
            if(!data.unfinishedType){
                initData();
            }else{
                location.href = "/progress"
            }
        }
    })

</script>
</body>
</html>

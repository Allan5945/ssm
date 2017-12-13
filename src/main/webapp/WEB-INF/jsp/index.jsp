
<%@ page language='java' contentType='text/html; charset=UTF-8'%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>app</title>
  <link href="static/css/main-e3ca2e152e1c949b27e3.css" rel="stylesheet"></head>
  <body>
    <div id="app"></div>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=TDmhTStuIIhX3LsAf3bNZV60SZoloqdC"></script>
  <script type="text/javascript" src="static/main-e3ca2e152e1c949b27e3.js"></script>
    <script>
       var websocket = new WebSocket("ws://localhost:8087/websocket");
    </script>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2020/5/13
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <h3>${hello}</h3>
    <h4>现在时间是：${time}</h4>
    <br><input id="get1" type="button" value="获取单个对象"/>
    <div id="message1"></div>
    <br><input id="get2" type="button" value="获取多个对象"/>
    <div id="message2"></div>
    <br><input id="get3" type="button" value="获取浏览器相关信息"/>
    <div id="message3"></div>
    <script src='./webjars/jquery/3.4.1/jquery.min.js'></script>
    <script src="./js/ajax.js"></script>
</body>
</html>

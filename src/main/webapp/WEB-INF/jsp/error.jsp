<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2020/5/13
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>错误页面</title>
    <style>
        #div1 {
            width:500px;
            border:1px solid lightgray;
            margin:100px auto;
            padding:80px
        }
    </style>
</head>
<body>
  <div id="div1">
      系统出现异常
      <br>
      异常原因：${exception}
      <br>
      异常地址：${url}
  </div>
</body>
</html>

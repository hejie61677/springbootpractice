<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2020/5/21
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="./css/styleForm.css">
</head>
<body>
    <div>
       <form action="uploadSubmit" enctype="multipart/form-data" method="post">
           <table align="center">
               <tr class="first">
                   <td>选择图片</td>
                   <td>
                       <input type="file" name="file" accept="image/*"/>
                   </td>
               </tr>
               <tr class="second">
                    <td class="centerTD" colspan="2">
                        <input type="submit" value="提交"/>
                    </td>
               </tr>
           </table>
       </form>
    </div>
</body>
</html>

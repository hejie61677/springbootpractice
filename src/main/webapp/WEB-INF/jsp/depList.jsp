<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2020/5/14
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>机构列表</title>
    <style>
        table tr td{
            border: 1px solid orange;
        }
        table{
            border-collapse: collapse;
            padding: 2px;
            text-align: left;
        }
        tr.first{
            text-align: center;
            font-weight: bolder;
            font-size: 15px;
            background-color: deepskyblue;
        }
        tr.second1{
            text-align: left;
            font-size: 13px;
            background-color: beige;
         }
        tr.second2{
            text-align: left;
            font-size: 13px;
            background-color: azure;
        }
        td{
            width: 300px;
        }
        td.hideTd{
            display: none;
        }
    </style>
</head>
<body>
    <table align="center">
        <tr class="first">
            <td>机构号</td>
            <td>机构名称</td>
            <td>上级机构</td>
            <td class="hideTd">整合</td>
        </tr>
        <c:forEach items="${deps}" var="dep" varStatus="status">
            <c:if test="${status.count%2 == 0}">
                <tr class="second1">
            </c:if>
            <c:if test="${status.count%2 != 0}">
                <tr class="second2">
            </c:if>
                <td>${dep.cur_dep_no}</td>
                <td>${dep.dep_name}</td>
                <td>${dep.cur_up_br_no}</td>
                <td class="hideTd">${dep.toString()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

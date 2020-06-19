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
    <title>股东列表</title>
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
            <td>股东号</td>
            <td>股东名称</td>
            <td>股东证件</td>
            <td class="hideTd">整合</td>
        </tr>
        <c:forEach items="${page.content}" var="stock" varStatus="status">
            <c:if test="${status.count%2 == 0}">
                <tr class="second1">
            </c:if>
            <c:if test="${status.count%2 != 0}">
                <tr class="second2">
            </c:if>
                <td>${stock.client_no}</td>
                <td>${stock.client_name}</td>
                <td>${stock.certifno}</td>
                <td class="hideTd">${stock.toString()}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                <a href="?start=0">[首页]</a>
                <a href="?start=${page.number - 1}">[上一页]</a>
                <a href="?start=${page.number + 1}">[下一页]</a>
                <a href="?start=${page.totalPages - 1}">[末页]</a>
            </td>
        </tr>
    </table>
</body>
</html>

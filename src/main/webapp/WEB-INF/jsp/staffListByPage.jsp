<%--
  Created by IntelliJ IDEA.
  User: hejie
  Date: 2020/5/20
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>职工列表</title>
    <link type="text/css" rel="styleSheet"  href="./css/styleTable.css" />
</head>
<body>
    <table align="center">
        <tr class="first">
            <td>职工号</td>
            <td>职工名称</td>
            <td>账户</td>
            <td>户名</td>
            <td>开户行</td>
            <td class="hideTd">整合</td>
        </tr>
        <c:forEach items="${page.list}" var="staff" varStatus="status">
            <c:if test="${status.count%2 == 0}">
                <tr class="second1">
            </c:if>
            <c:if test="${status.count%2 != 0}">
                <tr class="second2">
            </c:if>
                <td>${staff.staff_no}</td>
                <td>${staff.name}</td>
                <td>${staff.ac_no}</td>
                <td>${staff.ac_name}</td>
                <td>${staff.ac_br_name}</td>
                <td class="hideTd">${staff.toString()}</td>
            </tr>
        </c:forEach>
        <tr>
            <td class="centerTD" colspan="6">
                当前页数：${page.pageNum}/总页数：${page.pages}
                <a href="?start=1">[首页]</a>
                <a href="?start=${page.pageNum-1}">[上一页]</a>
                <a href="?start=${page.pageNum+1}">[下一页]</a>
                <a href="?start=${page.pages}">[尾页]</a>
            </td>
        </tr>
    </table>
</body>
</html>

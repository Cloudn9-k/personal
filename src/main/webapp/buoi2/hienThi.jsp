<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tonga
  Date: 09/07/2025
  Time: 2:05 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Them thong tin nuoc hoa
<form action="/buoi2/them" method="post">
    ten<input type="text" name="ten"><br>
    slg<input type="text" name="soLuong"><br>
    gia <input type="text" name="gia"><br>
    <button>Submit</button>
</form>
Thong tin nuoc hoa
<table>
    <thead>
    <tr>
        <th> id</th>
        <th>ten</th>
        <th>so luong</th>
        <th> gia</th>
        <th> hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSach}" var="nh">
        <tr>
            <td>${nh.id}</td>
            <td>${nh.ten}</td>
            <td>${nh.soLuong}</td>
            <td>${nh.gia}</td>
            <td>
                <a href="/buoi2/chi-tiet?id=${nh.id}">Chi tiet</a>
                <a href="/buoi2/view-update?id=${nh.id}">View update</a>
                <a href="/buoi2/xoa?id=${nh.id}">xoa</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>

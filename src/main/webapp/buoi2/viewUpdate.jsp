<%--
  Created by IntelliJ IDEA.
  User: Tonga
  Date: 11/07/2025
  Time: 12:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    sua thong tin
    <form action="/buoi2/update" method="post">
        id <input type="text" name="id" value="${nuocHoa.id}"><br>
        ten <input type="text" name="ten" value="${nuocHoa.ten}"><br>
        so luong <input type="text" name="soLuong" value="${nuocHoa.soLuong}"><br>
        gia <input type="text" name="gia" value="${nuocHoa.gia}"><br>
        <button>Submit</button>
    </form>
</body>
</html>

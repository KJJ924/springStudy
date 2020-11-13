<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-11-04
  Time: 오후 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>미용실 정보</title>
</head>
<body>
    <table border="1">
        <th>미용실 이름</th>
        <th>미용실 주소</th>
        <th>미용실 전번</th>

        <tr>
            <td>${shops.storeName}</td>
            <td>${shops.local}</td>
            <td>${shops.phoneNumber}</td>
        </tr>



    </table>
</body>
</html>

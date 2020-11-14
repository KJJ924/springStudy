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
    <title>미용실 상세페이지</title>
</head>
<body>
<h1>${beautyShop.storeName}</h1>
    <table border="1">
        <tr>
            <th>미용실 이름</th>
            <th>미용실 주소</th>
            <th>미용실 전번</th>
        </tr>
        <tr>
            <td>${beautyShop.storeName}</td>
            <td>${beautyShop.local}</td>
            <td>${beautyShop.phoneNumber}</td>
        </tr>
    </table>
<h2>메뉴판</h2>
    <table border="1">
        <tr>
            <th>이름</th>
            <th>가격</th>
        </tr>
        <c:forEach var="menu" items="${beautyShop.menu.menu}">
            <tr>
                <td>${menu.key}</td>
                <td>${menu.value}</td>
            </tr>
        </c:forEach>
    </table>
<h3>미용사</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>특기</th>
        </tr>
        <c:forEach var="designer" items="${beautyShop.designerList}">
        <tr>
            <td>${designer.id}</td>
            <td>${designer.name}</td>
            <td>${designer.specialty}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>

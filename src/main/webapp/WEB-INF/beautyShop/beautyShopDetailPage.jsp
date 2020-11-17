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
    <%@ include file="/WEB-INF/includes/header.jsp"%>
</head>
<body>
<%@ include file="/WEB-INF/includes/navbar.jsp"%>
<div class="container" style="margin-top: 100px"
<form action="/saveOrderData" method="post">
    <input type="hidden" name="shopId" value="${beautyShop.DB_Id}">
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
            <th>선택</th>
            <th>이름</th>
            <th>가격</th>
        </tr>
        <c:forEach var="menu" items="${beautyShop.menu.menu}">

            <tr>
                <%-- 메뉴 이름이랑 가격 동시에보내야하는데 당장 생각이 안나므로 그냥 히든으로 --%>
                <input type="hidden" name="menuName" value="${menu.key}">
                <input type="hidden" name="price" value="${menu.value}">
                <td><input type="radio"></td>
                <td>${menu.key}</td>
                <td>${menu.value}</td>
            </tr>
        </c:forEach>
    </table>
<h3>미용사</h3>
    <table border="1">
        <tr>
            <th>선택</th>
            <th>ID</th>
            <th>이름</th>
            <th>특기</th>
        </tr>
        <c:forEach var="designer" items="${beautyShop.designerList}">
        <tr>
            <td><input type="radio" name="designerId" value="${designer.id}"></td>
            <td>${designer.id}</td>
            <td>${designer.name}</td>
            <td>${designer.specialty}</td>
        </tr>
        </c:forEach>
    </table>
    예약 날짜 : <input type='date' name='reservationDate'/>
    <input type="submit" value="예약하기">
</form>
<%@ include file="/WEB-INF/includes/footer.jsp"%>
</body>
</html>

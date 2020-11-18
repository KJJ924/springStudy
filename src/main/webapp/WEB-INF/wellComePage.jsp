<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-10-26
  Time: 오후 7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="includes/header.jsp" %>
    <title>Wellcome Page</title>
</head>

<body>

<%@include file="includes/navbar.jsp"%>
<!-- contents zone -->
<div class="container" style="margin-top:100px">
    <c:choose>
        <c:when test="${not empty shops}">
            <c:forEach var="shop" items="${shops}">
            <table class="table  table-hover">
                <tr>
                    <th>번호</th>
                    <th>미용실 이름</th>
                    <th>미용실 주소</th>
                </tr>
                <tr>
                    <td>${shop.DB_Id}</td>
                    <td ><a href="/beautyShopDetailPage?id=${shop.DB_Id}">${shop.storeName}</a> </td>
                    <td>${shop.local}</td>
                </tr>
            </table>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h1>등록된 미용실이 없습니다.</h1>
        </c:otherwise>
    </c:choose>
</div>

<%@ include file="includes/footer.jsp" %>

</body>
</html>

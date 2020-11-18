<%--
  Created by IntelliJ IDEA.
  User: 조경록
  Date: 2020-11-16
  Time: 오후 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>내 예약현황</title>
    <%@ include file="/WEB-INF/includes/header.jsp"%>
</head>
<body>
<%@ include file="/WEB-INF/includes/navbar.jsp"%>
<main role="main">
    <br><br><br><br><br><br><br><br><br>
    <div class="container text-center">
        <!-- 디자인 뭘로할지 고민중; 추천좀해주세여 -->
        <!-- 미용실 이름, 미용사 이름 필요.. 수정 예정. -->
        <c:if test="${empty orderList}">
            <blockquote class="blockquote text-center">
                <p class="mb-0">예약 건수가 없습니다.</p>
                <footer class="blockquote-footer">관리자</footer>
            </blockquote>
        </c:if>
    <c:forEach items="${orderList}" var="order">
        미용실 : ${order.shopId}<br>
        미용사 : ${order.designerId}<br>
        시술 메뉴 : ${order.menuName}<br>
        가격 : ${order.price}<br>
        시술예정 날짜 : ${order.reservationDate}<br>
        예약하신 날짜 : ${order.orderDate}<br>
    </c:forEach>
    </div>
</main>
<%@ include file="/WEB-INF/includes/footer.jsp"%>
</body>
</html>

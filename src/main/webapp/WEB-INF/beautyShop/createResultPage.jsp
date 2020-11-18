<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-11-04
  Time: 오후 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>미용실 등록 결과</title>
    <%@include file="/WEB-INF/includes/header.jsp"%>
</head>
<body>
<%@include file="/WEB-INF/includes/navbar.jsp"%>
    <%-- ${Fisrt.Second} --%>
    <!-- 도트(.) 연산자 혹은 접근 연산자라고 함.
         First : 맵 혹은 자바 빈
         Second : 맵의 키 혹은 자바 빈의 프라퍼티(멤버변수)

         First가 객체(자바 빈)에 해당하는 경우엔 getter 메소드에 해당하는 Second를 호출한 결과를 반환한다.
         결론 -> 멤버를 직접 참조하는게 아니라 getter 메소드를 통해서 들고온다.
     -->
    <h1 style="margin-top: 100px">미용실 상세 정보</h1>
        <table border="1">
            <tr>
                <th>미용실 이름</th>
                <th>미용실 주소</th>
                <th>미용실 전번</th>
            </tr>
            <tr>
                <td>${shop.storeName}</td>
                <td>${shop.local}</td>
                <td>${shop.phoneNumber}</td>
            </tr>
        </table>
    <h1>미용실 메뉴판</h1>
        <table border ="1">
            <tr>
                <th>미용실 메뉴</th>
                <th>가격</th>
            </tr>
            <c:forEach var="entry" items="${shop.menu.menu}" varStatus="status">
                <tr>
                    <td>${entry.key}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
        </table>
    <h1>디자이너 목록</h1>
        <table border="1">
            <tr>
                <th>미용사</th>
                <th>특기</th>
            </tr>
            <c:forEach var="designer" items="${shop.designerList}" varStatus="status">
                <tr>
                    <td>${designer.name}</td>
                    <td>${designer.specialty}</td>
                </tr>
            </c:forEach>
        </table>
    <%@include file="/WEB-INF/includes/footer.jsp"%>
</body>

</html>

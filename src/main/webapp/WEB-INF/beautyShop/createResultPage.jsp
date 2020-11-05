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
</head>
<body>
    <table>
        <tr>
            <td>미용실 이름 :${shop.storeName}</td><br><br><br><br>
            <td>미용실 주소 :${shop.local}</td><br><br><br><br><br>
            <td>미용실 전번 :${shop.phoneNumber}</td><br><br><br><br><br>
            <c:forEach var="entry" items="${shop.menu.menu}" varStatus="status">
                <td>미용실 메뉴 : ${entry.key}</td><br><br><br><br>
                <td>가격: ${entry.value}</td><br><br><br><br>
            </c:forEach>

        </tr>

    </table>
</body>
</html>

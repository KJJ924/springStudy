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
    <%-- ${Fisrt.Second} --%>
    <!-- 도트(.) 연산자 혹은 접근 연산자라고 함.
         First : 맵 혹은 자바 빈
         Second : 맵의 키 혹은 자바 빈의 프라퍼티(멤버변수)

         First가 객체(자바 빈)에 해당하는 경우엔 getter 메소드에 해당하는 Second를 호출한 결과를 반환한다.
         결론 -> 멤버를 직접 참조하는게 아니라 getter 메소드를 통해서 들고온다.
     -->
    <table border="1">
        <tr>
            <td>미용실 이름 :${shop.storeName}</td>
            <td>미용실 주소 :${shop.local}</td>
            <td>미용실 전번 :${shop.phoneNumber}</td>
        </tr>
    </table>
    <table border ="1">
        <tr>
            <c:forEach var="entry" items="${shop.menu.menu}" varStatus="status">
                <td>미용실 메뉴 : ${entry.key}</td>
                <td>가격: ${entry.value}</td>
            </c:forEach>
        </tr>
    </table>
    <table>
        <tr>
            <c:forEach var="designer" items="${shop.designerList.designerList}" varStatus="status">
                <td>미용사 : ${designer.name}</td>
                <td>특기 : ${designer.specialty}</td>
            </c:forEach>
        </tr>

    </table>

</body>
</html>

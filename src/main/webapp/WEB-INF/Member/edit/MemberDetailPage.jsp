<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-10-28
  Time: 오후 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>상세정보</title>
    <%@ include file="/WEB-INF/includes/header.jsp"%>
</head>
<body>
<div class="container">

    <!-- 오류뜸.. 왜지????? 수정 예정, 일단 다른거부터-->
    <form class="form-signin" action="/editMember" method="post">
        <h2 class="form-signin-heading">회원정보 수정</h2>
        <label class="">ID</label>
        <input type="text" class="form-control" value="${member.id}" disabled>
        <label class="">Password</label>
        <input type="password" name="pw" id="pw" class="form-control" placeholder="Your Password" required autofocus>
        <label class="">Name</label>
        <input type="text" id="name" class="form-control" value="${member.name}" disabled>
        <label class="">Age</label>
        <input type="number" id="age" class="form-control" value="${member.age}"disabled>
        <a href="/loginForm">이미 아이디가 있어요!</a><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">회원정보 수정</button>
    </form>

</div> <!-- /container -->

<%--<form method="post" action="/editMember">--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <th>회원ID:</th>--%>
<%--            <td>${member.id}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>이름</th>--%>
<%--            <td>${member.name}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>나이</th>--%>
<%--            <td>${member.age}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>비밀번호</th>--%>
<%--            <td><input type="password" name="pw" placeholder="수정할 비밀번호를 입력하세요"></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--    <input type="submit" value="회원정보 변경">--%>
<%--</form>--%>
<%@ include file="/WEB-INF/includes/footer.jsp"%>
</body>
</html>

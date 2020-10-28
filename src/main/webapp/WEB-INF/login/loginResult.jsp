<%--
  Created by IntelliJ IDEA.
  User: i
  Date: 2020-10-28
  Time: 오후 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty UserDB_id}">
            <h1>로그인성공</h1>
            <a href="/memberEdit">회원정보 수정하기</a>
            <a href="/logOut">로그아웃</a>
            <a href="/">wellComePage 로 가기</a>
        </c:when>
        <c:otherwise>
            <script lang="javascript">
                alert('아이디가 없거나 패스워드가 맞지 않아 로그인에 실패하셨습니다.');
                location.href='http://localhost:8080/loginForm';
            </script>

        </c:otherwise>
    </c:choose>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-10-26
  Time: 오후 7:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>wellComePage</h1>
<c:choose>
    <c:when test="${not empty UserDB_id}">
        <a href="/logOut">로그아웃</a>
    </c:when>
    <c:otherwise>
        <a href="/loginForm">로그인 바로가기</a><br>
        <a href="/signUp">회원가입</a>
    </c:otherwise>
</c:choose>
</body>
</html>

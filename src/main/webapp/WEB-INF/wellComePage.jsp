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
    <%@ include file="/WEB-INF/includes/header.jsp" %>
    <title>Wellcome Page</title>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">미용실</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <div class="starter-template" style="align-content: center; margin:100px;">
        <h1>Wellcome!</h1>
        <p class="lead">
            <c:choose>
                <c:when test="${not empty UserDB_id}">
                    <a href="/memberEdit">회원정보 수정하기</a><br>
                    <a href="/logOut">로그아웃</a>
                </c:when>
                <c:otherwise>
                    <a href="/loginForm">로그인 바로가기</a><br>
                    <a href="/signUp">회원가입</a>
                </c:otherwise>
            </c:choose>
        </p>
    </div>

</div>
<%@ include file="/WEB-INF/includes/footer.jsp" %>

</body>
</html>

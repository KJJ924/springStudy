<%--
  Created by IntelliJ IDEA.
  User: 조경록
  Date: 2020-11-17
  Time: 오후 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="/">미용실</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BeautyShop">미용실 등록하기</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/beautyShopOrder">내 예약현황</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">준비중</a>
                </li>
            </ul>
            <ul class="navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${not empty UserDB_id}">
                        <li><a class ="nav-link" href="/memberEdit">회원정보 수정하기</a></li>
                        <li><a class ="nav-link" href="/logOut">로그아웃</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a class ="nav-link" href="/loginForm">로그인 바로가기</a></li>
                        <li><a class ="nav-link"`href="/signUp">회원가입</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
</header>
<%--
  Created by IntelliJ IDEA.
  User: 조경록
  Date: 2020-11-17
  Time: 오후 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li><a href="/BeautyShop">미용실 등록하기</a></li>
                <li><a href="/beautyShopOrder">내 예약현황</a></li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <c:choose>
                    <c:when test="${not empty UserDB_id}">
                        <li class="pull-right"><a href="/memberEdit">회원정보 수정하기</a></li>
                        <li class="pull-right"><a href="/logOut">로그아웃</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="pull-right"><a href="/loginForm">로그인 바로가기</a></li>
                        <li class="pull-right"><a href="/signUp">회원가입</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>


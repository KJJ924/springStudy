<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-10-26
  Time: 오후 7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="/WEB-INF/includes/header.jsp" %>
    <title>로그인페이지</title>
    <link href="/resources/css/signin.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <form class="form-signin" action="/loginPost" method="post">
        <h2 class="form-signin-heading">로그인</h2>
        <label for="id" class="">ID</label>
        <input type="text" name="id" id="id" class="form-control" placeholder="Your ID" required autofocus>
        <label for="pw" class="">Password</label>
        <input type="password" name="pw" id="pw" class="form-control" placeholder="Your Password" required>
        <a href="/signUp">혹시 회원이 아니신가요?</a><br>
        <a href="#" onclick="alert('아직 해당기능은 구현이 안됐습니다 ㅎ')">아이디/패스워드 분실</a><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>

</div> <!-- /container -->
<%@ include file="/WEB-INF/includes/footer.jsp" %>
</body>
</html>


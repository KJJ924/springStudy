<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-10-26
  Time: 오후 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <%@ include file="/WEB-INF/includes/header.jsp" %>
    <link href="/resources/css/signin.css" rel="stylesheet">
    <title>회원가입</title>
</head>
<body>

<spring:hasBindErrors name="member">
    <c:if test="${errors.hasFieldErrors('name')}">
        <spring:message
                code="${errors.getFieldError('name').codes[0]}"
                text="${errors.getFieldError('name').defaultMessage}"
        />
    </c:if>
    <c:if test="${errors.hasFieldErrors('age')}">
        <spring:message
                code="${errors.getFieldError('age').codes[0]}"
                text="${errors.getFieldError('age').defaultMessage}"
        />
    </c:if>
</spring:hasBindErrors>
<div class="container">

    <form class="form-signin" action="/signUpMember" method="post">
        <h2 class="form-signin-heading">회원가입</h2>
        <label for="id" class="">ID</label>
        <input type="text" name="id" id="id" class="form-control" placeholder="Your ID" required autofocus>
        <label for="pw" class="">Password</label>
        <input type="password" name="pw" id="pw" class="form-control" placeholder="Your Password" required>
        <label for="name" class="">Name</label>
        <input type="text" name="name" id="name" class="form-control" placeholder="Your Name" required>
        <label for="age" class="">Age</label>
        <input type="number" name="age" id="age" class="form-control" placeholder="Your age" required>
        <a href="/loginForm">이미 아이디가 있어요!</a><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up!</button>
    </form>

</div> <!-- /container -->
<%@ include file="/WEB-INF/includes/footer.jsp" %>

</body>
</html>




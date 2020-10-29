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
    <title>Title</title>
</head>
<body>

<spring:hasBindErrors name="member">
    <c:if test="${errors.hasFieldErrors('name')}">
        <spring:message
                code="${errors.getFieldError('name').codes[0]}"
                text="${errors.getFieldError('name' ).defaultMessage}"
        />
    </c:if>
    <c:if test="${errors.hasFieldErrors('age')}">
        <spring:message
                code="${errors.getFieldError('age').codes[0]}"
                text="${errors.getFieldError('age').defaultMessage}"
        />
    </c:if>
</spring:hasBindErrors>
<form method="post" action="/signUpMember">
    <table border="1">
        <tr>
            <th>아이디</th>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <th>패스워드</th>
            <td><input type="password" name="pw"></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>나이</th>
            <td><input type="text" name="age"></td>
        </tr>
    </table>
    <input type="submit" value="가입하기">
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-10-26
  Time: 오후 7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>로그인 폼</title>
</head>
<body>
<h1>로그인 </h1>
<p><c:out value="${msg}"/></p>
<p>
    <c:if test="${not empty member.id}">
        ID: <c:out value="${member.id}"/><br>
    </c:if>
    <c:if test="${not empty member.pw}">
        PW: <c:out value="${member.pw}"/>
    </c:if>
</p>
<form mehtod="GET" action="/loginComplete">
<table border="1">
    <tr>
        <th>ID</th>
        <td><input type="text" name="id"></td>
    </tr>
    <tr>
        <th>PW</th>
        <td><input type="password" name="pw"></td>
    </tr>
    <input type="submit" value="로그인">
</table>
</form>
<a href="<c:url value="/signform"/>">회원가입</a>
</body>
</html>

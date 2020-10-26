<%--
  Created by IntelliJ IDEA.
  User: 조경록
  Date: 2020-10-27
  Time: 오전 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1>회원가입 </h1>
<form mehtod="POST" action="#">
    <table border="1">
        <tr>
            <th>ID</th>
            <td><input type="text" name="sign_id"></td>
        </tr>
        <tr>
            <th>PW</th>
            <td><input type="password" name="sign_pw"></td>
        </tr>
        <tr>
            <th>Age</th>
            <td><input type="text" name="sign_age"></td>
        </tr>
        <input type="submit" value="회원가입">
    </table>
</form>

</body>
</html>

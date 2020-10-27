<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-10-26
  Time: 오후 7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 폼</title>
</head>
<body>
<h1>로그인 </h1>
<form method="post">
    <table border="1">
        <tr>
            <th>ID</th>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <th>PW</th>
            <td><input type="password" name="pw"></td>
        </tr>
    </table>
    <input type="submit" value="로그인">
</form>
</body>
</html>

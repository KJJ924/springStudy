<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-10-28
  Time: 오후 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세정보</title>
</head>
<body>
<form method="post" action="/editMember">
    <table border="1">
        <tr>
            <th>회원ID:</th>
            <td>${member.id}</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>${member.name}</td>
        </tr>
        <tr>
            <th>나이</th>
            <td>${member.age}</td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pw" placeholder="수정할 비밀번호를 입력하세요"></td>
        </tr>

    </table>
    <input type="submit" value="회원정보 변경">
</form>
</body>
</html>

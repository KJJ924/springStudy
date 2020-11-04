<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-11-04
  Time: 오후 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>미용실 생성 폼!!!</title>
</head>
<body>
<form action="/BeautyShop" method="post">
    <center>
    <table>
        <tr>
            <th>미용실 이름</th>
            <td><input type="text" name="storeName"></td>
        </tr>
        <tr>
            <th>주소</th>
            <td><input type="text" name="local"></td>
        </tr>
        <tr>
            <th>미용실 전화번호</th>
            <td><input type="tel" name="phonNumber" ></td>
        </tr>
    </table>

    <input type="submit" value="다음">
    </center>
</form>
</body>
</html>

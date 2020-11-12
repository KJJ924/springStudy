<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>미용실 리스트</title>
</head>
<body>
<form name="hiddenForm" action="/beautyShopDetailPage" method="post">
    <input type="hidden" name="beautyDB_id" value=""/>
</form>
    <table border="1">
        <th>미용실 이름</th>
        <th>미용실 주소</th>
        <th>미용실 전번</th>
        <c:forEach var="shop" items="${shops}">
            <tr>
                <%-- 고려해야할것. hidden으로 하면 shop마다 db_id가 다를텐데, 그걸 다 같은 이름 hidden form으로 저장하면 안되잖아--%>
                <%-- 미용실 상세페이지로 갈때 그 미용실의 db_id만 들고올수있게끔 만들어야함.. --%>
                <%-- 오케이 방법찾은듯 --%>
                    <%-- row 마다 id가 다른데 굳이 이렇게 할필요 없어요 --%>
                    <%-- --%>
<%--                <td><a href="" onclick="dbIdSubmit(${shop.DB_Id})">${shop.storeName}</a></td>--%>
                <td><a href="/beautyShopDetailPage?id=${shop.DB_Id}">${shop.storeName}</a> </td>
                <td>${shop.local}</td>
                <td>${shop.phoneNumber}</td>
            </tr>
        </c:forEach>
    </table>
    <script>
        function dbIdSubmit(db_id){
            const form = document.hiddenForm;
            form.beautyDB_id.value = db_id;
            form.submit();
        }
    </script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: rlawo
  Date: 2020-11-05
  Time: 오후 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>디자이너 등록 페이지!</title>

    <script type="text/javascript">
        var count = 0;
        function addForm(){
            var addedFormDiv = document.getElementById("addedFormDiv");
            var str = "";
            // input name에 속성명[idx].속성 으로 지정하면 VO 객체에서 List 형태로 받을수 있댄다. 신기하네..
            str+="<br>디자이너 이름-"+count+" <input type='text' name='designerList["+count+"].name'>";
            str+="<br>특기-"+count+" <input type='text' name='designerList["+count+"].specialty'>";
            // 추가할 폼(에 들어갈 HTML)
            var addedDiv = document.createElement("div"); // 폼 생성
            addedDiv.id = "added_"+count; // 폼 Div에 ID 부여 (삭제를위해)
            addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
            addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
            count++;
            document.baseForm.count.value=count;
            // 다음 페이지에 몇개의 폼을 넘기는지 전달하기 위해 히든 폼에 카운트 저장
        }
        function delForm(){
            var addedFormDiv = document.getElementById("addedFormDiv");
            if(count >1){ // 현재 폼이 두개 이상이면
                var addedDiv = document.getElementById("added_"+(--count));
                // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴
                addedFormDiv.removeChild(addedDiv); // 폼 삭제
            }else{ // 마지막 폼만 남아있다면
                document.baseForm.reset(); // 폼 내용 삭제
            }
        }
    </script>
    <%@include file="/WEB-INF/includes/header.jsp"%>
</head>
<body onload="addForm();">
<%@include file="/WEB-INF/includes/navbar.jsp"%>
<div class="container" style="margin-top: 100px">
    <form name="baseForm" action="/registerDesigner" method="post">
        <input type="hidden" name="count" value="0">
        <div id="addedFormDiv"></div><BR> <!-- 폼을 삽입할 DIV -->
        <input type="Button" value="추가" onclick="addForm()">
        <input type="Button" value="삭제" onclick="delForm()">
        <input type="Submit" value="완료">
    </form>
</div>
<%@include file="/WEB-INF/includes/footer.jsp"%>
</body>
</html>

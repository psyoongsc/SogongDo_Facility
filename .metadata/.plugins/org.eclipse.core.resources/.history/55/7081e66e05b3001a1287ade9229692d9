<%--
  Created by IntelliJ IDEA.
  User: Herase
  Date: 2020-06-03
  Time: 오후 8:56
  To change this template use File | Settings | File Templates.
--%>

<%--
 모둘 설계자 : 김인환

 검토자 : 박성용, 김주현
 검토 날짜: 06/05

 수정 일자: 06/05
 수정 내용: text input에 readonly 속성 추가
 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <title>권한 수정 페이지</title>
</head>
<body>

<div>
    <form action="Update" name = "updatef">
        <label>id <input type="text" name="id_text" id="inp1" readonly></label>
        <br>
        <select name="authority">
            <option value="A">A</option>
            <option value="M">M</option>
        </select>
        <input type="submit" value="수정">
        <button onclick="closef()">취소</button>
    </form>
</div>
<script>
    var sampletext;
    function receive_id(){
        sampletext = window.opener.document.getElementById("recieve_id").value;
        document.updatef.id_text.value = sampletext;
    }
    receive_id();

    function closef() {
        window.opener.parent.location.reload();
        self.close();
    }
</script>
</body>
</html>

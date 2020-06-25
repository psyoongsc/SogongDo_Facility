<%@ page import="java.util.List" %>
<%@ page import="Authority_Mgmt.persistance.AuthorityDTO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <title>권한 등록 페이지</title>
</head>
<body>
<div>
    <form action="/SogongDo_Management_System/Authority/enroll">
        <label>id <input type="text" name="id_text" required></label>
        <br>
        <label>권한id(정수형) <input type="text" name="authoirity_Id" required></label>
        <input type="submit" value="등록">
        <button onclick="closef()">취소</button>
    </form>
</div>
<script>
    function closef() {
            window.opener.parent.location.reload();
            self.close();
    }
</script>
</body>
</html>
<%@ page import="java.util.List" %>
<%@ page import="persistance.AuthorityDTO" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <title>권한 등록 페이지</title>
</head>
<body>
<div>
    <form action="Enroll">
        <label>id <input type="text" name="id_text" required></label>
        <br>
        <select name="authority">
            <option value="A">A</option>
            <option value="M">M</option>
        </select>
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
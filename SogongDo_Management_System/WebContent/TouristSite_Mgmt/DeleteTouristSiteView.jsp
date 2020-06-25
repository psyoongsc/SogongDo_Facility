<%--
    모듈 설계자 : 이희수

    검토자 : 박성용
    검토 날짜: 2020/06/12

    수정 일자 :
    수정 내용 :
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>관광지 삭제</title>
</head>
<body>
<%
	String id = request.getParameter("tourist_site_id");
	String name = request.getParameter("tourist_site_name");
%>
	<form name = "deleteForm" , method="GET">
	 	<input type="hidden" name="tourist_site_id" value=<%=id %> />
	 	다음 관광지를 삭제 하시겠습니까? <br><br>
	 	<fieldset>
	 	<label>관광지 ID : &nbsp;<%=id %> </label> <br>
		<label>관광지 이름 : &nbsp;<%=name %> </label>
	 	</fieldset>
	</form>
	<br>
	<input type="button" onclick="doSubmit()" value="삭제">
    <button onclick="window.self.close()">취소</button>
</body>
<script>
function doSubmit()
{
	window.opener.name = "main";
	document.deleteForm.target = "main";
	document.deleteForm.action="/SogongDo_Management_System/TouristSite/delete";
	document.deleteForm.submit();
	window.self.close();
}
</script>
</html>
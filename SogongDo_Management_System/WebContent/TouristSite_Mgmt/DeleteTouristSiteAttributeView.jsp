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
<title>관광지 속성 삭제</title>
</head>
<body>
<%
	String id = request.getParameter("tourist_site_id");
%>
	<form name="deleteForm" , method="GET">
		<input type="hidden" name="tourist_site_id" value=<%=id %>> 
		해당 관광지의 속성을 삭제 하시겠습니까? <br> <br>
	</form>
	<input type="button" onclick="doSubmit()" value="삭제">
	<button onclick="window.self.close()">취소</button>
</body>
<script>
	function doSubmit() {
		window.opener.name = "attributes_main";
		document.deleteForm.target = "attributes_main";
		document.deleteForm.action = "/SogongDo_Management_System/TouristSite/Attribute/delete";
		document.deleteForm.submit();
		window.self.close();
	}
</script>
</html>
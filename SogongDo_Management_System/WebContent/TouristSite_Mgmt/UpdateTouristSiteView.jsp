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
<title>관광지 수정</title>
</head>
<body>
<h2>관광지 수정</h2>
<%
	String id = request.getParameter("tourist_site_id");
	String name = request.getParameter("tourist_site_name");
%>
	<form name = "updateForm", method="GET">
        <fieldset>
            <legend>관광지 정보</legend>
            <div>         
               <input type="hidden" name="tourist_site_id" value=<%=id %> >
               <label>관광지 이름 &nbsp;&nbsp;<input type="text" name="tourist_site_name" value=<%=name %> autofocus></label>               
            </div>
        </fieldset>
	</form>
	<br>
	<input type="button" onclick="doSubmit()" value="수정">
    <button onclick="window.self.close()">취소</button>
</body>
<script>
function validateCheck()
{
	if(document.updateForm.tourist_site_name.value == '')
	{
	self.alert("입력란을 채워주세요.")
	return false;
	}
	else if(!/^[가-힣a-zA-Z0-9]+[가-힣a-zA-Z0-9\s]+$/.test(document.updateForm.tourist_site_name.value))
	{
	self.alert("한글,영어,숫자로만 입력해주세요.")
	return false;
	}
	else if(document.updateForm.tourist_site_name.value.length >30)
	{
	self.alert("관광지 이름은 30자까지만 등록할 수 있습니다.")
	return false;
	}
	return true;
}
function doSubmit()
{
	if(validateCheck() == true)
	{
	window.opener.name = "main";
	document.updateForm.target = "main";
	document.updateForm.action="/SogongDo_Management_System/TouristSite/update";
	document.updateForm.submit();
	window.self.close();
	}
}
</script>
</html>
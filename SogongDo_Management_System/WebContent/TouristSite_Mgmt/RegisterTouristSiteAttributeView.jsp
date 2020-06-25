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
<title>관광지 속성 등록</title>
</head>
<body>
<%
	String id = request.getParameter("tourist_site_id");
%>
	<form name = "registerForm", method="GET">
        <h1>관광지 속성 등록</h1>
        <fieldset>
            <legend>관광지 속성</legend>
            <div>
                <input type="hidden" name="tourist_site_id" value=<%=id %>> 
             	<label>주소 &nbsp;&nbsp;<input type="text" name="tourist_site_address" autofocus></label> <br>
             	<label>연락처 &nbsp;&nbsp;<input type="text" name="tourist_site_phone_number"></label> <br>
                <label>사업자등록번호&nbsp;&nbsp;<input type="text" name="registration_number"></label> <br>
                <label>대표자 이름&nbsp;&nbsp;<input type="text" name="representative_name"></label> <br>
            </div>
        </fieldset>
	</form>
	<br>
	<input type="button" onclick="doSubmit()" value="등록">
    <button onclick="window.self.close()">취소</button>
</body>
<script>
function validateCheck()
{
	// 주소
	if(document.registerForm.tourist_site_address.value == '')
	{
	self.alert("주소를 입력해주세요")
	return false;
	}
	else if(!/^[가-힣a-zA-Z0-9]+[가-힣a-zA-Z0-9\s]+$/.test(document.registerForm.tourist_site_address.value))
	{
	self.alert("주소는 한글,영어,숫자로만 입력해주세요.")
	return false;
	}
	else if(document.registerForm.tourist_site_address.value.length >70)
	{
	self.alert("주소는 70자까지만 등록할 수 있습니다.")
	return false;
	}
	// 연락처
	if(document.registerForm.tourist_site_phone_number.value == '')
	{
	self.alert("연락처를 입력해주세요")
	return false;
	}
	else if(!/^[0-9]+$/.test(document.registerForm.tourist_site_phone_number.value))
	{
	self.alert("연락처는 숫자로만 입력해주세요.")
	return false;
	}
	else if(document.registerForm.tourist_site_phone_number.value.length >20)
	{
	self.alert("연락처는 20자까지만 등록할 수 있습니다.")
	return false;
	}
	// 사업자등록번호
	if(document.registerForm.registration_number.value == '')
	{
	self.alert("사업자등록번호를 입력해주세요")
	return false;
	}
	else if(!/^[0-9]+$/.test(document.registerForm.registration_number.value))
	{
	self.alert("사업자등록번호는 숫자로만 입력해주세요.")
	return false;
	}
	else if(document.registerForm.registration_number.value.length >11)
	{
	self.alert("사업자등록번호는 11자까지만 등록할 수 있습니다")
	return false;
	}
	// 대표자 이름
	if(document.registerForm.representative_name.value == '')
	{
	self.alert("대표자 이름을 입력해주세요")
	return false;
	}
	else if(!/^[가-힣a-zA-Z]+$/.test(document.registerForm.representative_name.value))
	{
	self.alert("대표자 이름은 한글 혹은 영어로 입력해주세요.")
	return false;
	}
	else if(document.registerForm.representative_name.value.length >20)
	{
	self.alert("대표자 이름은 20자까지만 등록할 수 있습니다")
	return false;
	}
	return true;
}
function doSubmit()
{
	if(validateCheck() == true)
	{
	window.opener.name = "attributes_main";
	document.registerForm.target = "attributes_main";
	document.registerForm.action = "/SogongDo_Management_System/TouristSite/Attribute/enroll";
	document.registerForm.submit();
	window.self.close();
	}
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시설속성 등록</title>
</head>
<body>
<form action="/SogongDo_Management_System/Facility/Attribute/enroll" method="Post" name="enrollForm">
	<fieldset id="enrollBox">
		<legend>시설속성 등록</legend>
		<label for="Tourist_Site_Name">관광지명</label>
		<input type="text" name="Tourist_Site_Name" id="Tourist_Site_Name"/><br/>
		<label for="Facility_Name">시설명</label>
		<input type="text" name="Facility_Name" id= "Facility_Name"/><br/>
		<label for="Facility_State">시설상태</label>
		<input type="text" name="Facility_State" id= "Facility_State"/><br/>
		<label for="Facility_Manager">시설관리자</label>
		<input type="text" name="Facility_Manager" id= "Facility_Manager"/><br/>
		<label for="Facility_PhoneNumber">시설전화번호</label>
		<input type="text" name="Facility_PhoneNumber" id= "Facility_PhoneNumber"/><br/>
		
		<input type="button" value="등록"	 onClick="checkData()"/>
		<input type="reset" value="취소"/>
	</fieldset>
</form>
</body>

<script type="text/javascript">
	function checkData(){
		var enroll = document.enrollForm;
		
		var tName = document.getElementById('Tourist_Site_Name').value;
		var fName = document.getElementById('Facility_Name').value;
		var fState = document.getElementById('Facility_State').value;
		var fManager = document.getElementById('Facility_Manager').value;
		var fPhoneNumber = document.getElementById('Facility_PhoneNumber').value;
		if(tName == ""){ //빈칸인 경우
			alert("관광지명을 입력해주세요");
		}else if(fName ==""){
			alert("시설명을 입력해주세요");
		}else if(fState ==""){
			alert("시설상태를 입력해주세요");
		}else if(fManager ==""){
			alert("시설관리자를 입력해주세요");
		}else if(fPhoneNumber ==""){
			alert("시설전화번호를 입력해주세요");
		}else{
			enroll.submit();
			alert("등록 되었습니다!");
			window.opener.location.reload();
		}
	}
</script>
</html>
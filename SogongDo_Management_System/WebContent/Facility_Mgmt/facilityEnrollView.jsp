<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시설 등록</title>
<style>
	#enrollBox{ width:300px;}
	#enrollBox label{ display: block; width:300px; float:left;}
</style>
</head>
<body>
<form action="/SogongDo_Management_System/Facility/enroll" method="Post" name="enrollForm">
	<fieldset id="enrollBox">
		<legend>시설 등록</legend>
		<label for="Tourist_Site_Name">관광지명</label>
		<input type="text" name="Tourist_Site_Name" id="Tourist_Site_Name"/><br/>
		<label for="Facility_Name">시설명</label>
		<input type="text" name="Facility_Name" id= "Facility_Name"/><br/>
		
		<input type="button" value="등록"	onClick = "checkData()"/>
		<input type="reset" value="취소"/>
	</fieldset>
</form>
</body>

<script type="text/javascript">
	function checkData(){
		var enroll = document.enrollForm;
		
		var tName = document.getElementById('Tourist_Site_Name').value;
		var fName = document.getElementById('Facility_Name').value;
		if(tName == ""){ //빈칸인 경우
			alert("관광지명을 입력해주세요");
		}else if(fName ==""){
			alert("시설명을 입력해주세요");
		}else{
			enroll.submit();
			opener.window.location.reload();
			alert("등록 되었습니다!");
		}
	}
</script>
</html>
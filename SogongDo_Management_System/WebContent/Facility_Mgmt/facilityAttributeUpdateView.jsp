<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String tName = request.getParameter("tName");
	int fID = Integer.parseInt(request.getParameter("fID").trim());
	String fName = request.getParameter("fName");
	int fStatus = Integer.parseInt(request.getParameter("fStatus").trim());
	String fManager = request.getParameter("fManager");
	String fPhoneNumber = request.getParameter("fPhoneNumber");
%>

<form action="/SogongDo_Management_System/Facility/Attribute/update" method="Post" name="enrollForm">
	<fieldset id="enrollBox">
		<legend>시설 수정</legend>
		<label for="Tourist_Site_Name">관광지명</label>
		<input readonly type="text" name="Tourist_Site_Name" value=<%=tName %> id="Tourist_Site_Name"/><br/>
		<label for="Facility_Name">시설명</label>
		<input readonly type="text" name="Facility_Name" value=<%=fName %> id= "Facility_Name"/><br/>
		<label for="Facility_State">시설상태</label>
		<input type="text" name="Facility_Status" value=<%=fStatus %> id= "Facility_State"/><br/>
		<label for="Facility_Manager">시설관리자</label>
		<input type="text" name="Facility_Manager" value=<%=fManager %> id= "Facility_Manager"/><br/>
		<label for="Facility_PhoneNumber">시설전화번호</label>
		<input type="text" name="Facility_PhoneNumber" value=<%=fPhoneNumber %> id= "Facility_PhoneNumber"/><br/>
		<input type="hidden" name="Facility_ID" value=<%=fID %> id= "Facility_ID"/><br/>
		
		<input type="button" value="수정"	onClick = "checkData()"/>
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
			alert("수정 되었습니다!");
			window.opener.location.reload();
			self.close();
		}
	}
</script>
</html>
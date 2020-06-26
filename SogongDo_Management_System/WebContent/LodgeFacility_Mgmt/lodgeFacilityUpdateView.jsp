<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙박시설 수정</title>
<style>
	#enrollBox{ width:300px;}
	#enrollBox label{ display: block; width:300px; float:left;}
</style>
</head>
<body>
<%
	String tName = request.getParameter("tName");
	int lfID = Integer.parseInt(request.getParameter("lfID").trim());
	String fName = request.getParameter("fName");
	int lNum = Integer.parseInt(request.getParameter("lNum"));
	int rNum = Integer.parseInt(request.getParameter("rNum"));
%>
<form action="/SogongDo_Management_System/Facility/Lodge/update" method="Post" name="enrollForm">
	<fieldset id="enrollBox">
		<legend>시설 수정</legend>
		<label for="Tourist_Site_Name">관광지명</label>
		<input readonly type="text" name="Tourist_Site_Name" value=<%=tName %> id="Tourist_Site_Name"/><br/>
		<label for="Facility_Name">시설명</label>
		<input readonly type="text" name="Facility_Name" value=<%=fName %> id= "Facility_Name"/><br/>
		<label for="Lodge_Number">동</label>
		<input type="text" name="Lodge_Number" value=<%=lNum %> id= "Lodge_Number"/><br/>
		<label for="Room_Number">호</label>
		<input type="text" name="Room_Number" value=<%=rNum %> id= "Room_Number"/><br/>
		<input type="hidden" name="Lodge_Facility_ID" value=<%=lfID %> id= "Lodge_Facility_ID"/><br/>
		
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
		var lNum = document.getElementById('Lodge_Number').value;
		var rNum = document.getElementById('Room_Number').value;
		if(tName == ""){ //빈칸인 경우
			alert("관광지명을 입력해주세요");
		}else if(fName ==""){
			alert("시설명을 입력해주세요");
		}else if(lNum ==""){
			alert("동을 입력해주세요");
		}else if(rNum ==""){
			alert("호를 입력해주세요");
		}else{
			enroll.submit();
			opener.window.location.reload();
			alert("수정 되었습니다!");
			self.close();
		}
	}
</script>
</html>
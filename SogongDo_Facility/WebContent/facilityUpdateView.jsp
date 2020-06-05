<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ü� ����</title>
<style>
	#enrollBox{ width:300px;}
	#enrollBox label{ display: block; width:300px; float:left;}
</style>
</head>
<body>

<%
	String tName = request.getParameter("tName");
	int fID = Integer.parseInt(request.getParameter("fID").trim());
	String fName = request.getParameter("fName");
		
%>
<form action="updateFacility" method="Post" name="enrollForm">
	<fieldset id="enrollBox">
		<legend>�ü� ����</legend>
		<label for="Tourist_Site_Name">��������</label>
		<input readonly type="text" name="Tourist_Site_Name" value=<%=tName %> id="Tourist_Site_Name"/><br/>
		<label for="Facility_Name">�ü���</label>
		<input type="text" name="Facility_Name" value=<%=fName %> id= "Facility_Name"/><br/>
		<label for="Facility_ID">�ü�ID</label>
		<input type="hidden" name="Facility_ID" value=<%=fID %> id= "Facility_ID"/><br/>
		
		<input type="button" value="����"	onClick = "checkData()"/>
		<input type="reset" value="���"/>
	</fieldset>
</form>
</body>

<script type="text/javascript">
	function reloadParentPage(){
			window.opener.location.reload();
	}
	
	function checkData(){
		var enroll = document.enrollForm;
		
		var tName = document.getElementById('Tourist_Site_Name').value;
		var fName = document.getElementById('Facility_Name').value;
		if(tName == ""){ //��ĭ�� ���
			alert("���������� �Է����ּ���");
		}else if(fName ==""){
			alert("�ü����� �Է����ּ���");
		}else{
			enroll.submit();
			alert("��� �Ǿ����ϴ�!");
		}
	}
</script>
</html>
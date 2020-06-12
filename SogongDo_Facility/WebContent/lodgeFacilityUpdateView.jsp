<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���ڽü� ����</title>
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
<form action="updateLodgeFacility" method="Post" name="enrollForm">
	<fieldset id="enrollBox">
		<legend>�ü� ����</legend>
		<label for="Tourist_Site_Name">��������</label>
		<input readonly type="text" name="Tourist_Site_Name" value=<%=tName %> id="Tourist_Site_Name"/><br/>
		<label for="Facility_Name">�ü���</label>
		<input readonly type="text" name="Facility_Name" value=<%=fName %> id= "Facility_Name"/><br/>
		<label for="Lodge_Number">��</label>
		<input type="text" name="Lodge_Number" value=<%=lNum %> id= "Lodge_Number"/><br/>
		<label for="Room_Number">ȣ</label>
		<input type="text" name="Room_Number" value=<%=rNum %> id= "Room_Number"/><br/>
		<input type="hidden" name="Lodge_Facility_ID" value=<%=lfID %> id= "Lodge_Facility_ID"/><br/>
		
		<input type="button" value="����"	onClick = "checkData()"/>
		<input type="reset" value="���"/>
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
		if(tName == ""){ //��ĭ�� ���
			alert("���������� �Է����ּ���");
		}else if(fName ==""){
			alert("�ü����� �Է����ּ���");
		}else if(lNum ==""){
			alert("���� �Է����ּ���");
		}else if(rNum ==""){
			alert("ȣ�� �Է����ּ���");
		}else{
			enroll.submit();
			alert("���� �Ǿ����ϴ�!");
			self.close();
		}
	}
</script>
</html>
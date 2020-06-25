<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
		<legend>�ü� ����</legend>
		<label for="Tourist_Site_Name">��������</label>
		<input readonly type="text" name="Tourist_Site_Name" value=<%=tName %> id="Tourist_Site_Name"/><br/>
		<label for="Facility_Name">�ü���</label>
		<input readonly type="text" name="Facility_Name" value=<%=fName %> id= "Facility_Name"/><br/>
		<label for="Facility_State">�ü�����</label>
		<input type="text" name="Facility_Status" value=<%=fStatus %> id= "Facility_State"/><br/>
		<label for="Facility_Manager">�ü�������</label>
		<input type="text" name="Facility_Manager" value=<%=fManager %> id= "Facility_Manager"/><br/>
		<label for="Facility_PhoneNumber">�ü���ȭ��ȣ</label>
		<input type="text" name="Facility_PhoneNumber" value=<%=fPhoneNumber %> id= "Facility_PhoneNumber"/><br/>
		<input type="hidden" name="Facility_ID" value=<%=fID %> id= "Facility_ID"/><br/>
		
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
		var fState = document.getElementById('Facility_State').value;
		var fManager = document.getElementById('Facility_Manager').value;
		var fPhoneNumber = document.getElementById('Facility_PhoneNumber').value;
		if(tName == ""){ //��ĭ�� ���
			alert("���������� �Է����ּ���");
		}else if(fName ==""){
			alert("�ü����� �Է����ּ���");
		}else if(fState ==""){
			alert("�ü����¸� �Է����ּ���");
		}else if(fManager ==""){
			alert("�ü������ڸ� �Է����ּ���");
		}else if(fPhoneNumber ==""){
			alert("�ü���ȭ��ȣ�� �Է����ּ���");
		}else{
			enroll.submit();
			alert("���� �Ǿ����ϴ�!");
			self.close();
		}
	}
</script>
</html>
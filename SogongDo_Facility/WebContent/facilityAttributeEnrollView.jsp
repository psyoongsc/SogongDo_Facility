<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ü��Ӽ� ���</title>
</head>
<body>
<form action="enrollFacilityAttribute" method="Post" name="enrollForm">
	<fieldset id="enrollBox">
		<legend>�ü��Ӽ� ���</legend>
		<label for="Tourist_Site_Name">��������</label>
		<input type="text" name="Tourist_Site_Name" id="Tourist_Site_Name"/><br/>
		<label for="Facility_Name">�ü���</label>
		<input type="text" name="Facility_Name" id= "Facility_Name"/><br/>
		<label for="Facility_State">�ü�����</label>
		<input type="text" name="Facility_State" id= "Facility_State"/><br/>
		<label for="Facility_Manager">�ü�������</label>
		<input type="text" name="Facility_Manager" id= "Facility_Manager"/><br/>
		<label for="Facility_PhoneNumber">�ü���ȭ��ȣ</label>
		<input type="text" name="Facility_PhoneNumber" id= "Facility_PhoneNumber"/><br/>
		
		<input type="button" value="���"	 onClick="checkData()"/>
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
			alert("��� �Ǿ����ϴ�!");
		}
	}
</script>
</html>
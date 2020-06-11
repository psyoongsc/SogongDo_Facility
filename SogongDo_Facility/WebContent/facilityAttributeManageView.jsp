<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="Facility_Management.persistence.FacilityAttributeDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td></td>
				<td>ID</td>
				<td>��������</td>
				<td>�ü���</td>
				<td>����</td>
				<td>������</td>
				<td>��ȭ��ȣ</td>
			</tr>
		</thead>
		<%
			List<FacilityAttributeDTO> list = (List<FacilityAttributeDTO>) request.getAttribute("facilityAttributeList");
			for(FacilityAttributeDTO dto : list) {
				pageContext.setAttribute("dto", dto);
		%>
			<tr>
				<td><input type="checkbox" class="checkBox"></td>
				<td class="id">${ dto.facilityID }</td>
				<td class="tName">${ dto.touristSiteName }</td>
				<td class="fName">${ dto.facilityName }</td>
				<td class="fState">${ dto.facilityState }</td>
				<td class="fManager">${ dto.facilityManager }</td>
				<td class="fPhoneNumber">${ dto.facilityPhoneNumber }</td>
			</tr>
		<%}%>
	</table>
	<form align="center" method="GET">
		<input type="button" value= "�ü����" id="btnEnroll" onclick="fEnroll()">
		<input type="button" value= "�ü�����" id="btnUpdate" onclick="fUpdate()">
		<input type="button" value= "�ü�����" id="btnDelete" onclick="fDelete()">
	</form>
</body>

<script>
	function fEnroll() { //���
	    var url = "/SogongDo_Facility/facilityAttributeEnrollView.jsp";
	    var name = "facilityEnrollView";
	    var option = "width = 500, height = 230, top = 100, left = 200, location = no"
	    
	   	window.open(url, name, option);
	}
	function fUpdate() { //����
		var url = "/SogongDo_Facility/facilityAttributeUpdateView.jsp?";
		var name = "facilityUpdateView";
		var option = "width = 500, height = 200, top = 100, left = 200, location = no"
		
		var cnt = 0;
		var ci;
		
		const chBox = document.querySelectorAll(".checkBox");
		const fId = document.querySelectorAll(".id");
		const tName = document.querySelectorAll(".tName");
		const fName = document.querySelectorAll(".fName");
		const fState = document.querySelectorAll(".fState");
		const fManager = document.querySelectorAll(".fManager");
		const fPhoneNumber = document.querySelectorAll(".fPhoneNumber");
		
		for(var i=0; i<chBox.length; i++) {
			if(chBox[i].checked) {
				cnt++;
				ci = i;
			}
		}
		if(cnt == 0) {
			alert("�׸��� �������ּ���.");
		} else if (cnt > 1) {
			alert("�׸��� �ϳ��� �������ּ���.");
		} else {
			url += "fID=" + fId[ci].innerText + "&tName=" + tName[ci].innerText + "&fName=" + fName[ci].innerText
			 + "&fStatus=" + fState[ci].innerText + "&fManager=" + fManager[ci].innerText + "&fPhoneNumber=" + fPhoneNumber[ci].innerText;

			window.open(url, name, option);
		}
	}
	function fDelete() { //����
		var url = "/SogongDo_Facility/facilityAttributeDeleteView.jsp?";
		var name = "facilityDeleteView";
		var option = "width = 360, height = 200, top = 100, left = 200, location = no"
		
		var cnt = 0;
		var ci = 0;
		
		const chBox = document.querySelectorAll(".checkBox");
		const fId = document.querySelectorAll(".id");
		
		for(var i=0; i<chBox.length; i++) {
			if(chBox[i].checked) {
				cnt++;
			}
		}
		if(cnt == 0) {
			alert("�׸��� �������ּ���.");
		} else {
			url += "cnt=" + cnt;
			for(var i = 0; i<chBox.length; i++) {
				if (chBox[i].checked) {
					url += "&fID" + ci++ + "=" + fId[i].innerText;
				}
			}
			
			var ox = confirm("�ü� �Ӽ������� ���� �����Ͻðڽ��ϱ�?");
			if(ox){
				window.open(url, name, option);
			}
		}
	}
</script>
</html>
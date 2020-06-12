<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="LodgeFacility_Management.persistence.LodgeFacilityDTO"%>
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
				<td>��</td>
				<td>ȣ</td>
			</tr>
		</thead>
		<%
			List<LodgeFacilityDTO> list = (List<LodgeFacilityDTO>) request.getAttribute("lodgeFacilityList");
			for(LodgeFacilityDTO dto : list) {
				pageContext.setAttribute("dto", dto);
		%>
			<tr>
				<td><input type="checkbox" class="checkBox"></td>
				<td class="id">${ dto.lodgeFacilityID }</td>
				<td class="tName">${ dto.touristSiteName }</td>
				<td class="fName">${ dto.facilityName }</td>
				<td class="lNum">${ dto.lodgeNumber }</td>
				<td class="rNum">${ dto.roomNumber }</td>
			</tr>
		<%}%>
	</table>
	<form align="center" action="#", method="GET">
		<input type="button" value= "�ü����" id="btnEnroll" onclick="fEnroll()">
		<input type="button" value= "�ü�����" id="btnUpdate" onclick="fUpdate()">
		<input type="button" value= "�ü�����" id="btnDelete" onclick="fDelete()">
	</form>
</body>

<script>
	function fEnroll() { //���
	    var url = "/SogongDo_Facility/lodgeFacilityEnrollView.jsp";
	    var name = "lodgeFacilityEnrollView";
	    var option = "width = 500, height = 260, top = 100, left = 200, location = no"
	    
	   	window.open(url, name, option);
	}
	function fUpdate() { //����
		var url = "/SogongDo_Facility/lodgeFacilityUpdateView.jsp?";
		var name = "lodgeFacilityUpdateView";
		var option = "width = 500, height = 270, top = 100, left = 200, location = no"
		
		var cnt = 0;
		var ci;
		
		const chBox = document.querySelectorAll(".checkBox");
		const lfId = document.querySelectorAll(".id");
		const tName = document.querySelectorAll(".tName");
		const fName = document.querySelectorAll(".fName");
		const lNum = document.querySelectorAll(".lNum");
		const rNum = document.querySelectorAll(".rNum");
		
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
			url += "lfID=" + lfId[ci].innerText + "&tName=" + tName[ci].innerText + "&fName=" + fName[ci].innerText + "&lNum=" + lNum[ci].innerText + "&rNum=" + rNum[ci].innerText;

			window.open(url, name, option);
		}
	}
	function fDelete() { //����
		var url = "/SogongDo_Facility/lodgeFacilityDeleteView.jsp?";
		var name = "lodgeFacilityDeleteView";
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
			
			var ox = confirm("���ڽü� ������ ���� �����Ͻðڽ��ϱ�?");
			if(ox){
				window.open(url, name, option);
			}
		}
	}
</script>
</html>
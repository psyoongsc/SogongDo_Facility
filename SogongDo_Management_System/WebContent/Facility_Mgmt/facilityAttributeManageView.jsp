<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Facility_Mgmt.persistence.FacilityAttributeDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시설 속성 관리</title>
    <style>
		body{
		    margin: 0;
		    padding: 0;
		    text-align: center;
		}
		
		th, td {
		    padding: 8px;
		    text-align: center;
		    border-bottom: 1px solid;
		    border: 1px solid;
		}
		
		thead th{
		    background-color: #E4F7BA;
		}

		table {
		    position: relative;
		    margin: 10px 5px;
		    border-collapse: collapse;
		    display: inline-block;
		    overflow:auto;
		}
		
		tbody tr:hover {background-color:#f5f5f5;}

        th, td {
            border: 1px solid #ddd;
            border-collapse: collapse;
        }

        .bt {
            position: relative;
		    border-radius: 12px;
		    background-color: #4CAF50;
		    border: none;
		    left: 10%;
		    color: white;
		    padding: 15px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    margin: 4px 2px;
		    cursor: pointer;
        }
    </style>
</head>
<body>
<%@ include file="../head_banner.jsp" %>
<h3>시설 속성 관리</h3>
	<table>
		<thead>
			<tr>
				<th></th>
				<th>ID</th>
				<th>관광지명</th>
				<th>시설명</th>
				<th>상태</th>
				<th>관리자</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
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
				<td class="fState">${ dto.facilityStatus }</td>
				<td class="fManager">${ dto.facilityManager }</td>
				<td class="fPhoneNumber">${ dto.facilityPhoneNumber }</td>
			</tr>
		<%}%>
		</tbody>
	</table>
	<form align="center" method="GET">
		<input class="bt" type="button" value= "시설속성 등록하기" id="btnEnroll" onclick="fEnroll()">
		<input class="bt" type="button" value= "시설속성 수정하기" id="btnUpdate" onclick="fUpdate()">
		<input class="bt" type="button" value= "시설속성 삭제하기" id="btnDelete" onclick="fDelete()">
	</form>
</body>

<script>
	function fEnroll() { //등록
	    var url = "/SogongDo_Management_System/Facility_Mgmt/facilityAttributeEnrollView.jsp";
	    var name = "facilityEnrollView";
	    var option = "width = 500, height = 250, top = 100, left = 200, location = no"
	    
	   	window.open(url, name, option);
	}
	function fUpdate() { //수정
		var url = "/SogongDo_Management_System/Facility_Mgmt/facilityAttributeUpdateView.jsp?";
		var name = "facilityUpdateView";
		var option = "width = 500, height = 250, top = 100, left = 200, location = no"
		
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
			alert("항목을 선택해주세요.");
		} else if (cnt > 1) {
			alert("항목을 하나만 선택해주세요.");
		} else {
			url += "fID=" + fId[ci].innerText + "&tName=" + tName[ci].innerText + "&fName=" + fName[ci].innerText
			 + "&fStatus=" + fState[ci].innerText + "&fManager=" + fManager[ci].innerText + "&fPhoneNumber=" + fPhoneNumber[ci].innerText;

			window.open(url, name, option);
		}
	}
	function fDelete() { //삭제
		var url = "/SogongDo_Management_System//Facility_Mgmt/facilityAttributeDeleteView.jsp?";
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
			alert("항목을 선택해주세요.");
		} else {
			url += "cnt=" + cnt;
			for(var i = 0; i<chBox.length; i++) {
				if (chBox[i].checked) {
					url += "&fID" + ci++ + "=" + fId[i].innerText;
				}
			}
			
			var ox = confirm("시설 속성정보를 정말 삭제하시겠습니까?");
			if(ox){
				window.open(url, name, option);
			}
		}
	}
</script>
</html>
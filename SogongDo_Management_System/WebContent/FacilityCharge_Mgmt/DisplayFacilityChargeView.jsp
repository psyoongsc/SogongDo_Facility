<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="FacilityCharge_Mgmt.persistance.FacilityChargeDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>시설 요금 관리</title>
<style>
table {
	text-align: center;
}
</style>
</head>
<body>
	<form name="selectItem" method="POST">
		<table  width="700" border="2" bordercolor="lightgray" align="center">
			<tr>
				<th>선택</th>
				<th>관광지명</th>
				<th>시설명</th>
				<th>요금</th>
			</tr>
			<%
				List<FacilityChargeDTO> list = (List<FacilityChargeDTO>) request.getAttribute("FacilityChargeDto");
				for (FacilityChargeDTO dto : list) {
					pageContext.setAttribute("dto", dto);
			%>
				<tr>
					<td><input type="radio" name="chargeID" value=${dto.chargeID}></td>
					<td>${dto.touristSiteName}</td>
					<td>${dto.facilityName}</td>
					<td>${dto.charge}</td>
				</tr>
			<%}%>
		</table>
		
		<div>
			<input type="button" value="등록" onclick="location.href='/SogongDo_Management_System/FacilityCharge_Mgmt/EnrollFacilityChargeView.jsp'">
			<input type="button" value="수정" onClick="mySubmit(1)"/>
			<input type="button" value="삭제" onClick="mySubmit(2)"/>
		</div>
	</form>
	
	<script>
	function mySubmit(index) {
		var checkRadio = document.getElementsByName('chargeID');
		var count = 0;
		for(var i=0; i<checkRadio.length; i++){
			if(checkRadio[i].checked == true) count++;
		}
		if(count > 0){
			if(index==1){
				document.selectItem.action="/SogongDo_Management_System/Facility/Charge/update";
			}
			if(index==2){
				if (confirm("정말 삭제하시겠습니까?") == true){
					document.selectItem.action="/SogongDo_Management_System/Facility/Charge/delete";
				}else{
					return false;
				}
			}
			document.selectItem.submit();
		}
		else{
			alert("항목을 체크하세요.");
		}
	}
    </script>
</body>
</html>
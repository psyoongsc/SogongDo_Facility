<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="persistance.FacilityChargeDiscountDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>시설 요금 할인 관리</title>
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
				<th>시설명</th>
				<th>할인사유</th>
				<th>할인율</th>
			</tr>
			<%
				List<FacilityChargeDiscountDTO> list = (List<FacilityChargeDiscountDTO>) request.getAttribute("FacilityChargeDiscountDto");
				for (FacilityChargeDiscountDTO dto : list) {
					pageContext.setAttribute("dto", dto);
			%>
				<tr>
					<td><input type="radio" name="chargeID" value=${dto.chargeID}></td>
					<td>${dto.facilityName}</td>
					<td>${dto.discountReason}</td>
					<td>${dto.discountRate}%</td>
				</tr>
			<%}%>
		</table>
		
		<div>
			<input type="button" value="등록" onclick="location.href='/Sogongdo/EnrollFacilityChargeDiscountView.jsp'">
			<input type="button" value="수정" onClick="mySubmit(1)"/>
			<input type="button" value="삭제" onClick="mySubmit(2)"/>
		</div>
	</form>
	
	<script>
	function mySubmit(index) {
		if(index==1){
			document.selectItem.action="/Sogongdo/facilityCharge/discount/update";
		}
		if(index==2){
			if (confirm("정말 삭제하시겠습니까?") == true){
				document.selectItem.action="/Sogongdo/facilityCharge/discount/delete";
			}else{
				return false;
			}
		}
		document.selectItem.submit();
	}
    </script>
</body>
</html>
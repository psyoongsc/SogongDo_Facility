<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="FacilityCharge_Mgmt.persistance.FacilityChargeDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <form action="/Sogongdo/facilityCharge/enroll">
	<div>
		<select name="touristSite">
			<%
			List<FacilityChargeDTO> list = (List<FacilityChargeDTO>) request.getAttribute("FacilityChargeDto");
			for (FacilityChargeDTO dto : list) {
				pageContext.setAttribute("dto", dto);
			%>
				<option>${dto.touristSiteName}</option>
			<%}%>
		</select>
	</div>
	<div>
		<select name="facility">
			<%
			for (FacilityChargeDTO dto : list) {
				pageContext.setAttribute("dto", dto);
			%>
				<option>${dto.facilityName}</option>
			<%}%>
		</select>
	</div>
	<div>
		<input type="text" name="charge"><br>
	</div>
	<div>
		<input type="submit" value="등록">
		<input type="button" onclick="history.back()" value="취소">
	</div>
	</form> --%>
	<form action="/SogongDo_Management_System/Facility/Charge/enroll" method="POST">
		<label>관광지ID </label><input type="text" name="touristSite"><br>
		<label>시설ID </label><input type="text" name="facility"><br>
		<label>요금 </label><input type="text" name="charge"><br>
		<input type="submit" value="등록">
		<input type="button" onclick="history.back()" value="취소">
	</form>
	
</body>
</html>
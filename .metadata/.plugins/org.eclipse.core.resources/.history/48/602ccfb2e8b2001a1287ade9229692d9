<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="persistance.FacilityChargeDTO"%>
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
	<form action="/Sogongdo/facilityCharge/discount/enroll" method="POST">
		<input type="text" name="chargeID"><br>
		<input type="text" name="discountReason"><br>
		<input type="text" name="discountRate"><br>
		<input type="submit" value="등록">
		<input type="button" onclick="history.back()" value="취소">
	</form>
	
</body>
</html>
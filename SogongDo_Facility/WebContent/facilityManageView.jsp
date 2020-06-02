<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="Facility_Management.FacilityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>관광지명</td>
				<td>시설명</td>
			</tr>
		</thead>
		<%
			List<FacilityDTO> list = (List<FacilityDTO>) request.getAttribute("facilityDto");
			for(FacilityDTO dto : list) {
		%>
			<tr>
				<td><%= dto.getTouristStie() %></td>
				<td><%= dto.getFacility() %></td>
			</tr>
		<%}%>
	</table>
</body>
</html>
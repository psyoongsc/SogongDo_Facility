<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="Facility_Management.persistence.FacilityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form align="center" action="enrollFacility", method="GET">
		<input type="button" value= "상품등록" id="btnEnroll" onclick="loadEnroll()">
	</form>
	<table border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
				<td>관광지명</td>
				<td>시설명</td>
			</tr>
		</thead>
		<%
			List<FacilityDTO> list = (List<FacilityDTO>) request.getAttribute("facilityList");
			for(FacilityDTO dto : list) {
				pageContext.setAttribute("dto", dto);
		%>
			<tr>
				<td>${ dto.touristSiteName }</td>
				<td>${ dto.facilityName }</td>
				<td><a href="/SogongDo_Facility/facilityUpdateView.jsp?tName=<%=dto.getTouristSiteName() %>&fID=<%=dto.getFacilityID() %>
                        &fName=<%=dto.getFacilityName()%>" >수정</a></td>
                <td><a href="/SogongDo_Facility/facilityDeleteView.jsp?id=<%=dto.getFacilityID() %>" >삭제</a></td>
			</tr>
		<%}%>
	</table>
</body>

<script>
	function loadEnroll() { //등록
		
	    var url = "/SogongDo_Facility/facilityEnrollView.jsp";
	    var name = "facilityEnrollView";
	    var option = "width = 500, height = 400, top = 100, left = 200, location = no"
	   	window.open(url, name, option);
	}
</script>
</html>
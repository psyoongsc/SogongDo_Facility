<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="Facility_Management.persistence.FacilityDAO"%>
<%@ page import="Facility_Management.persistence.FacilityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	FacilityDAO productDAO = new FacilityDAO();
	
	productDAO.deleteFacilityInfo(new FacilityDTO("", Integer.parseInt(id), ""));
	response.sendRedirect("/SogongDo_Facility/facility/");
%>
</body>
</html>
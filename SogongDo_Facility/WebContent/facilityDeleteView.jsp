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
	FacilityDAO productDAO = new FacilityDAO();

	int length = Integer.parseInt(request.getParameter("cnt"));
	
	for (int i=0; i<length; i++) {
		String id = request.getParameter("fID" + i);
		productDAO.deleteFacilityInfo(new FacilityDTO("", Integer.parseInt(id), ""));
	}
%>
<script type="text/javascript">
	self.close();
</script>
</body>
</html>
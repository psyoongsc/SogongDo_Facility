<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Facility_Mgmt.persistence.FacilityDAO"%>
<%@ page import="Facility_Mgmt.persistence.FacilityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	opener.window.location.reload();
	self.close();
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Facility_Mgmt.persistence.FacilityAttributeDAO"%>
<%@ page import="Facility_Mgmt.persistence.FacilityAttributeDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	FacilityAttributeDAO productDAO = new FacilityAttributeDAO();

	int length = Integer.parseInt(request.getParameter("cnt"));
	
	for (int i=0; i<length; i++) {
		String id = request.getParameter("fID" + i);
		productDAO.deleteFacilityAttributeInfo(new FacilityAttributeDTO("", Integer.parseInt(id), "", 0, "", ""));
	}
%>
<script type="text/javascript">
window.opener.location.reload();
	self.close();
</script>
</body>
</html>
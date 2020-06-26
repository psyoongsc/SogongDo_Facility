<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="LodgeFacility_Mgmt.persistence.LodgeFacilityDAO"%>
<%@ page import="LodgeFacility_Mgmt.persistence.LodgeFacilityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	LodgeFacilityDAO productDAO = new LodgeFacilityDAO();

	int length = Integer.parseInt(request.getParameter("cnt"));
	
	for (int i=0; i<length; i++) {
		String id = request.getParameter("fID" + i);
		productDAO.deleteLodgeFacilityInfo(new LodgeFacilityDTO("", 0, "", Integer.parseInt(id), 0, 0));
	}
%>
<script type="text/javascript">
opener.window.location.reload();
	self.close();
</script>

</body>
</html>
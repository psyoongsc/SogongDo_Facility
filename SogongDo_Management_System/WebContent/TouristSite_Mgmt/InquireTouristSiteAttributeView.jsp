<%--
    모듈 설계자 : 이희수

    검토자 : 박성용
    검토 날짜: 2020/06/12

    수정 일자 :
    수정 내용 :
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import = "TouristSite_Mgmt.persistance.TouristSiteAttributeDTO" %>
	<%@ page import = "TouristSite_Mgmt.persistance.TouristSiteDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>관광지 속성 조회</title>
</head>
<body>
<h2>관광지 속성</h2>
	<table border="1" cellpadding="5">
	<%
		TouristSiteAttributeDTO attribute = (TouristSiteAttributeDTO) request.getAttribute("attribute");
			TouristSiteDTO touristSite = (TouristSiteDTO) request.getAttribute("touristSite");
	%>
		<tr>
			<th>관광지 ID</th>
			<th>${touristSite.tourist_site_id}</th>
		</tr>
		<tr>
			<th>관광지 이름</th>
			<th>${touristSite.tourist_site_name}</th>
		</tr>
		<tr>
			<th>주소</th>
			<th>${attribute.tourist_site_address}</th>
		</tr>
		<tr>
			<th>전화번호</th>
			<th>${attribute.tourist_site_phone_number}</th>
		</tr>
		<tr>
			<th>사업자번호</th>
			<th>${attribute.registration_number}</th>
		</tr>
		<tr>
			<th>대표자 이름</th>
			<th>${attribute.representative_name}</th>
		</tr>
	</table>
	<br>
	<%
		if(attribute == null) {
	%>
		<button
			onclick="window.open('/SogongDo_Management_System/TouristSite_Mgmt/RegisterTouristSiteAttributeView.jsp?tourist_site_id=<%=touristSite.getTourist_site_id() %>','관광지 속성 등록','width=450,height=300,location=no,status=no');">속성
			등록</button>
			<%} else { %>
		<button
			onclick="window.open('/SogongDo_Management_System/TouristSite_Mgmt/UpdateTouristSiteAttributeView.jsp?tourist_site_id=<%=touristSite.getTourist_site_id() %>','관광지 속성 수정','width=450,height=300,location=no,status=no');">속성
			수정</button>
		<button
			onclick="window.open('/SogongDo_Management_System/TouristSite_Mgmt/DeleteTouristSiteAttributeView.jsp?tourist_site_id=<%=touristSite.getTourist_site_id() %>','관광지 속성 삭제','width=380,height=100,location=no,status=no');">속성
			삭제</button>
			<% } %>
</body>
</html>
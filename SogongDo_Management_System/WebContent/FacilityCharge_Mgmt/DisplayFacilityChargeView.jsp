<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="FacilityCharge_Mgmt.persistance.FacilityChargeDTO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시설 요금 관리</title>
    <style>
		body{
		    margin: 0;
		    padding: 0;
		    text-align: center;
		}
		
		th, td {
		    padding: 8px;
		    text-align: center;
		    border-bottom: 1px solid;
		    border: 1px solid;
		}
		
		thead th{
		    background-color: #E4F7BA;
		}

		table {
		    position: relative;
		    margin: 10px 5px;
		    border-collapse: collapse;
		    display: inline-block;
		    overflow:auto;
		}
		
		tbody tr:hover {background-color:#f5f5f5;}

        th, td {
            border: 1px solid #ddd;
            border-collapse: collapse;
        }

        .bt {
            position: relative;
		    border-radius: 12px;
		    background-color: #4CAF50;
		    border: none;
		    left: 10%;
		    color: white;
		    padding: 15px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    margin: 4px 2px;
		    cursor: pointer;
        }
    </style>
</head>
<body>
<%@ include file="../head_banner.jsp" %>
<h3>시설 요금 관리</h3>
	<form name="selectItem" method="POST">
		<table>
		<thead>
			<tr>
				<th>선택</th>
				<th>관광지명</th>
				<th>시설명</th>
				<th>요금</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<FacilityChargeDTO> list = (List<FacilityChargeDTO>) request.getAttribute("FacilityChargeDto");
				for (FacilityChargeDTO dto : list) {
					pageContext.setAttribute("dto", dto);
			%>
				<tr>
					<td><input type="radio" name="chargeID" value=${dto.chargeID}></td>
					<td>${dto.touristSiteName}</td>
					<td>${dto.facilityName}</td>
					<td>${dto.charge}</td>
				</tr>
			<%}%>
		</tbody>
		</table>
		
		<div>
			<input class="bt" type="button" value="요금정보 등록하기" onclick="location.href='/SogongDo_Management_System/FacilityCharge_Mgmt/EnrollFacilityChargeView.jsp'">
			<input class="bt" type="button" value="요금정보 수정하기" onClick="mySubmit(1)"/>
			<input class="bt" type="button" value="요금정보 삭제하기" onClick="mySubmit(2)"/>
		</div>
	</form>
	
	<script>
	function mySubmit(index) {
		var checkRadio = document.getElementsByName('chargeID');
		var count = 0;
		for(var i=0; i<checkRadio.length; i++){
			if(checkRadio[i].checked == true) count++;
		}
		if(count > 0){
			if(index==1){
				document.selectItem.action="/SogongDo_Management_System/Facility/Charge/update";
			}
			if(index==2){
				if (confirm("정말 삭제하시겠습니까?") == true){
					document.selectItem.action="/SogongDo_Management_System/Facility/Charge/delete";
				}else{
					return false;
				}
			}
			document.selectItem.submit();
		}
		else{
			alert("항목을 체크하세요.");
		}
	}
    </script>
</body>
</html>
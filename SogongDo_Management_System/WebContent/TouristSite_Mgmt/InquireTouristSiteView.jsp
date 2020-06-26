<%--
    모듈 설계자 : 이희수

    검토자 : 박성용
    검토 날짜: 2020/06/12

    수정 일자 :
    수정 내용 :
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import = "java.util.*" %>
	<%@ page import = "TouristSite_Mgmt.persistance.TouristSiteDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>관광지 관리</title>
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
	<form action="/SogongDo_Management_System/inquireTouristSite" , method="GET">
		<h3>관광지 목록</h3>
		<%-- 
			<label>관광지 이름&nbsp;:&nbsp;<input type="text" name="name"
				autofocus></label>
			<button class="bt" type='submit'>검색하기</button>
			<br>
			<br>
			--%>
			<table>
			<thead>
				<tr>
					<th>관광지 ID</th>
					<th>관광지 이름</th>
					<th>속성</th>
					<th>작업</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<TouristSiteDTO> temp = (List<TouristSiteDTO>) request.getAttribute("tourist_site_list");
							if(temp !=null) {
								for (int i = 0; i < temp.size(); i++) {
				%>
					<tr>
						<td><%=temp.get(i).getTourist_site_id() %></td>
						<td><%=temp.get(i).getTourist_site_name() %></td>
						<td>
							<button class="bt" type="button"
								onclick="window.open('/SogongDo_Management_System/TouristSite/Attribute/view?tourist_site_id=<%=temp.get(i).getTourist_site_id() %>','관광지  속성 조회','width=450,height=400,location=no,status=no');">조회</button>
						</td>
						<td>
							<button class="bt" type="button"
								onclick="window.open('/SogongDo_Management_System/TouristSite_Mgmt/UpdateTouristSiteView.jsp?tourist_site_id=<%=temp.get(i).getTourist_site_id() %>&tourist_site_name=<%=temp.get(i).getTourist_site_name() %>','관광지 수정','width=450,height=200,location=no,status=no');">수정</button>
							<button class="bt" type="button"
								onclick="window.open('/SogongDo_Management_System/TouristSite_Mgmt/DeleteTouristSiteView.jsp?tourist_site_id=<%=temp.get(i).getTourist_site_id() %>&tourist_site_name=<%=temp.get(i).getTourist_site_name() %>','관광지 삭제','width=400,height=180,location=no,status=no');">삭제</button>
						</td>
					</tr>
					<%
						} }
					%>
			</tbody>
			</table>
	</form>
	<br>
	<button class="bt" style="left: 10%"
		onclick="window.open('/SogongDo_Management_System/TouristSite_Mgmt/RegisterTouristSiteView.jsp','관광지 등록','width=450,height=200,location=no,status=no');">관광지
		등록하기</button>
</body>

</html>
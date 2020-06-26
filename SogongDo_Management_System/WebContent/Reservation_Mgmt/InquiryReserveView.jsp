<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Reservation_Mgmt.persistance.*" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>예약 정보 관리</title>
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
<h3>숙박 예약 관리</h3>
        <div class="content">
        
            <table>
                <thead>
                    <tr>
                       <th class="a">All</th>
						<th class="b">No</th>
						<th class="c">예약시작</th>
						<th class="d">예약종료</th>
						<th class="e">시설명</th>
						<th class="f">인원</th>
						<th class="g">성함</th>
						<th class="h">연락처</th>
						<th class="i">예약시간</th>
                    </tr>
                </thead>
                <tbody>
					<%
						ArrayList<ReservationDTO> list = (ArrayList<ReservationDTO>) request.getAttribute("reserve");
								if(list != null) {				
									for (ReservationDTO dto : list) {
										pageContext.setAttribute("reserve", dto);
					%>
					 <tr>
                       	<td><input class="ch" type="checkbox"></td>
                       	<td class="id"><%= dto.getReservation_ID() %></td>
                       	<td><%= dto.getReservation_Start()%></td>
						<td><%= dto.getReservation_End()%></td>
						<td><%= dto.getFacilities_Name()%></td>
						<td><%= dto.getHeadCount()%></td>
						<td><%= dto.getReservation_Name() %></td>
						<td><%= dto.getReservation_Phone_Number() %></td>
						<td><%= dto.getReservation_Date() %></td>
                    </tr>
					<%}}%>
                </tbody>
            </table>
          

        </div>
        <div>
            <button class="bt register">숙박예약 등록하기</button>
           	<button class="bt delete">숙박예약 삭제하기</button>
			<button class="bt update">숙박예약 수정하기</button>
        </div>

          


	<script>
	window.addEventListener("load",function(){
		
		const registerbtn = document.querySelector(".register");
		const deletebtn = document.querySelector(".delete");
		const updatebtn = document.querySelector(".update");
		const chbox = document.querySelectorAll(".ch");
		const id = document.querySelectorAll(".id");

		registerbtn.addEventListener("click",()=>{
			//새로운 창 뜨도록 하기
			window.open("../Reservation_Mgmt/RegisterReserveView.jsp","예약 정보 등록","width=500, height=400, left=300, top=300");
		})
		
		deletebtn.addEventListener("click",()=>{
			//체크박스에 체크한 id가져오기
			var ids = new Array();
			for(var i=0; i<chbox.length; i++){
				if(chbox[i].checked==true){
					ids.push(id[i].innerText);
				}
			}
			if(ids.length==0){
				alert('삭제할 정보를 선택하세요');
			}else{
				
				//삭제컨트롤러에 전송
				var ox = confirm("예약 정보를 삭제하시겠습니까?");
				if(ox){
					var url = "/SogongDo_Management_System/Reservation/delete?";
					url += "cnt="+ids.length+"&";
					for(var i=0;i<ids.length;i++){
						url += "id"+i+"="+ids[i]+"&"
					}
					window.location.href = url;
				}
			}
		})
		
		updatebtn.addEventListener("click",()=>{
			// 새로운 창 뜨도록 하기
			var cnt = 0;
			var up;
			for(var i=0; i<chbox.length; i++){
				if(chbox[i].checked==true){
					cnt++;
					up = id[i].innerText;
				}
			}
			if(cnt==0){
				alert('수정할 정보를 선택하세요');
			}
			else if(cnt==1){
				//System.out.pritnln("update 넘길 ID : " + up);
				
				window.open("/SogongDo_Management_System/Reservation/update/view?id="+up,"예약 정보 수정","width=500, height=400, left=300, top=300");
			}else{
				alert('하나만 선택');
			}
		})
		
	})
	</script>
</body>
</html>
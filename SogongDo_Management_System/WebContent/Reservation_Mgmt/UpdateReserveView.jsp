<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Reservation_Mgmt.persistance.*"%>
<!DOCTYPE html>
<html>
<head>
<title>예약 정보 수정</title>
</head>
<body>
	<%
		ReservationDTO dto = (ReservationDTO) request.getAttribute("dto");
		pageContext.setAttribute("dto", dto);
	
		String ri = dto.getReservation_ID();
		out.println(ri);
	%>
	
	
	<form action = "/SogongDo_Management_System/Reservation/update">
	<fieldset>
	   <div>
                <label>수정할 ReservationName</label>
                <input name="ri" type="text" id="reseveName"  value='<%= ri %>' readonly>
            </div>
	
		<div>
			<label for = "reserveName">예약인 성함</label><input name = "rName" type = "text" id = "reserveName" value = '<%=dto.getReservation_Name() %>'>
		</div>
		<div>
			<label for = "reservePnum">예약인 연락처</label><input name = "pnum" type = "text" id = "reservePnum" value='<%=dto.getReservation_Phone_Number()%>'>
		</div>
		<div>
			<label for = "facilitiesName">시설 명</label><input name = "fName" type = "text" id = "facilitiesName" value='<%=dto.getFacilities_Name()%>'>
			<label for = "reserveCnt">예약 인원</label><input name = "cnt" type = "text" id = "reserveCnt" value='<%=dto.getHeadCount()%>'>
		</div>
		<div>
			<label>예약기간 
			<input type = "date" name = "start" id = "startD" value='<%=dto.getReservation_Start()%>'>
			~ <input type = "date" name = "end" id = "endD" value=<%=dto.getReservation_End()%>></label>
		</div>
		<div>
			<label>차량
			<input type="text" name="cNum" id="carNum" <%=dto.getCar_Num()%>>
       		<input type="text" name="cName" id="carName"<%=dto.getCar_Name()%>></label>
		</div>
	</fieldset>
	
	  <input type="submit" value="수정" class="update">
      <input type="reset" value="취소" class="reset">

</form>
</body>
</html>
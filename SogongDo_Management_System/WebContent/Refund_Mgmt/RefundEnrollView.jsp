<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Refund_Mgmt.persistance.RefundDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환불내역 등록</title>
</head>
<body>

<form action="/SogongDo_Management_System/Refund/enroll" method="Post" name="enrollForm">
	<fieldset >
		<legend>환불내역 등록</legend>
		<label for="Reservation_ID">예약 ID</label>
		<input type="text" name="Reservation_ID" id="Reservation_ID"/><br/>
		<label for="Refund_Amount">환불 금액</label>
		<input type="text" name="Refund_Amount" id= "Refund_Amount"/><br/>
		<label for="Refund_Method">환불 방법</label>
		<input type="text" name="Refund_Method" id="Refund_Method"/><br/>
		<label for="Refund_Date">환불 날짜</label>
		<input type="text" name="Refund_Date" id="Refund_Date"/><br/>
		<label for="Refund_Account">환불 계좌</label>
		<input type="text" name="Refund_Account" id="Refund_Account"/><br/>
		
		<input type="button" value="등록"	onClick = "checkData()"/>
		<input type="reset" value="취소"/>
	</fieldset>
</form>
	<%
		String result = (String)request.getAttribute("checkEnroll");
	 	if(result != null && !result.isEmpty()){
	 		if(result.equals("1")){
	%>
	<script>
			
			(function(){
				alert("등록 성공");
				window.opener.location.reload();
			})();
	</script>
	<%		
			}else if(result.equals("0")){
	%>
	<script>
			(function(){
				alert("등록 실패");
			})();
	</script>
	<%
			}else if(result.equals("-1")){
				
	%>
		<script>
			(function(){
				alert("등록 실패 : 동일한 환불내역 존재");
			})();
		</script>
	<% 
			}
	 	} 
	 %>
</body>

<script type="text/javascript">
	
	function checkData()
	{
		var enroll = document.enrollForm;
		
		var reservation = document.getElementById('Reservation_ID').value;
		var amount = document.getElementById('Refund_Amount').value;
		var method = document.getElementById('Refund_Method').value;
		var date = document.getElementById('Refund_Date').value;
		var account = document.getElementById('Refund_Account').value;
		
		if(reservation == ""){
			alert("예약 ID를 입력해주세요");
		}else if(isNaN(amount)){
			alert("예약 ID가 숫자가 아닙니다");
		}else if(amount == ""){
			alert("환불 금액을 입력하세요");
		}else if(method ==""){
			alert("환불 방법을 입력하세요");
		}else if(date ==""){
			alert("환불 날짜을 입력하세요");
		}else if(account ==""){
			alert("환불 금액을 입력하세요");
		}else if(amount < 0){
			alert("환불 금액에 0보다 큰 값을 입력하세요");
		}else if(isNaN(amount)){
			alert("환불 금액이 숫자가 아닙니다");
		}else{
			enroll.submit();
		}
	}
	


</script>

</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Payment_Mgmt.persistance.PaymentDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제내역 수정</title>
</head>
<body>

<form action="/SogongDo_Management_System/Payment/update" method="Post" name="updateForm">
	<fieldset id="updateBox">
		<legend>환불내역 등록</legend>
		<%
			String reservation = request.getParameter("reservation");
			String charge = request.getParameter("charge");
			String discount = request.getParameter("discount");
			String method = request.getParameter("method");
			String amount = request.getParameter("amount");
			String date = request.getParameter("date");
			
			
		%>
		<label for="Reservation_ID">예약 ID</label>
		<input type="text" name="Reservation_ID" id="Reservation_ID" value=<%=reservation %>><br/>
		<label for="Charge_ID">요금 ID</label>
		<input type="text" name="Charge_ID" id="Charge_ID" value=<%=charge %>><br/>
		<label for="Discount_Id">할인 할인 ID</label>
		<input type="text" name="Discount_Id" id="Discount_Id" value=<%=discount %>><br/>
		<label for="Payment_Method">결제 방법</label>
		<input type="text" name="Payment_Method" id="Payment_Method" value=<%=method %>><br/>
		<label for="Payment_Amount">결제 금액</label>
		<input type="text" name="Payment_Amount" id="Payment_Amount" value=<%=amount %>><br/>
		<label for="Payment_Date">결제 날짜</label>
		<input type="text" name="Payment_Date" id="Payment_Date" value=<%=date %>><br/>
		
		<input type="button" value="수정"	onClick = "checkData()"/>
		<input type="reset" value="취소"/>
	</fieldset>
</form>
	<%
		String result = (String)request.getAttribute("updateCheck");
	 	if(result != null && !result.isEmpty()){
	 		if(result.equals("1")){
	%>
	<script>
		
		(function(){
			alert("수정 성공");
			window.opener.location.reload();
			self.close();
		})();
	</script>
	<%		
		}else if(result.equals("0")){
	%>
	<script>
		(function(){
			alert("수정 실패");
			self.close();
		})();
	</script>
	<%
			}
	 	} 
	 %>


<script type="text/javascript">
	function checkData(){
		var update = document.updateForm;
		
		var reservation = document.getElementById('Reservation_ID').value;
		var charge = document.getElementById('Charge_ID').value;
		var discount = document.getElementById('Discount_Id').value;
		var method = document.getElementById('Payment_Method').value;
		var amount = document.getElementById('Payment_Amount').value;
		var date = document.getElementById('Payment_Date').value;
		
		
		if(reservation == ""){
			alert("예약 ID를 입력해주세요");
		}else if(isNaN(reservation)){
			alert("예약 ID가 숫자가 아닙니다");
		}else if(charge == ""){ 
			alert("요금 ID를 입력하세요");
		}else if(isNaN(charge)){
			alert("요금 ID가 숫자가 아닙니다");
		}else if(isNaN(charge)){
			alert("할인 ID가 숫자가 아닙니다");
		}else if(method ==""){
			alert("결제 방법을 입력하세요");
		}else if(amount ==""){
			alert("결제 금액을 입력하세요");
		}else if(date ==""){
			alert("결제 날짜을 입력하세요");
		}else if(amount < 0){
			alert("결제 금액에 0보다 큰값을 입력하세요");
		}else if(isNaN(amount)){
			alert("결제 금액이 숫자가 아닙니다");
		}else{
			update.submit();
		}
		
	}
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/SogongDo_Management_System/Facility/Charge/discount/update" method="POST">
		<label>할인사유 </label><input type="text" name="discountReason"><br>
		<label>할인율 </label><input type="text" name="discountRate"><br>
		<input type="submit" value="수정">
		<input type="button" onclick="history.back()" value="취소">
	</form>
</body>
</html>
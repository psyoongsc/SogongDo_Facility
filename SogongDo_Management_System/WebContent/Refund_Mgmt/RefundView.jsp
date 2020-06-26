<%@ page import = "java.util.List" %>
<%@ page import="Refund_Mgmt.persistance.RefundDTO"%>
<%@ page import="Refund_Mgmt.persistance.RefundDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <title>숙박시설 환불내역</title>
	
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
    <div>
        <div>
            <h3>숙박시설 환불내역</h3>
           	
           	
            <table class="Table">
                <thead>
                    <tr><th class="ch"></th>
                        <th>예약 ID</th>
                        <th>환불 금액</th>
                        <th>환불 방법</th>
                        <th>환불 날짜</th>
                        <th>환불 계좌</th>
                    </tr>
                </thead>
                <tbody>
                <%
                	List<RefundDTO> pdList = (List<RefundDTO>) request.getAttribute("refundList");
                                	for(RefundDTO dto : pdList){
                                		pageContext.setAttribute("dto", dto);
                %>
                
                
                    <tr>
                        <td class="ch">
                    	<input type="checkbox" name="columncheck" onclick="oneCheckbox(this)">
                		</td>
                        <td>${dto.reservation_ID}</td>
                        <td>${dto.refund_Amount}</td>
                        <td>${dto.refund_Method}</td>
                        <td>${dto.refund_Date}</td>
                        <td>${dto.refund_Account}</td>
                    </tr>
                
                <%} %>
            </tbody>
            </table>

        </div>
        <button class="bt" onclick="showEnrollView()">환불내역 등록하기</button>
        <button class="bt" onclick="deleteRefund()">환불내역 삭제하기</button>
        <button class="bt" onclick="updatePopUp()">환불내역 수정하기</button>
    </div>

</body>

<script>


function showEnrollView() { //등록
	
    var url = "/SogongDo_Management_System/Refund_Mgmt/RefundEnrollView.jsp";
    var title = "RefundEnrollView";
    var option = "width = 500, height = 400, top = 100, left = 200, location = no"
   	window.open(url, title, option);
}

function oneCheckbox(a){
	
    var obj = document.getElementsByName("columncheck");
    for(var i=0; i<obj.length; i++){
        if(obj[i] != a){
            obj[i].checked = false;
        }
    }
    
}

function deleteRefund()
{	
	var checkbox = $("input:checkbox[name=columncheck]:checked");
	checkbox.each(function(i) {
		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();
		
		var reservation = td.eq(1).text();
		var con_test = confirm(reservation+ "을(를) 정말로 삭제하겠습니까?");
		if(con_test) location.href = "/SogongDo_Management_System/Refund/delete?id="+reservation;
	});
	
}

function updatePopUp(){
	  
    var rowData = new Array();
	var tdArr = new Array();
	var checkbox = $("input:checkbox[name=columncheck]:checked");
	
	checkbox.each(function(i) {

		var tr = checkbox.parent().parent().eq(i);
		var td = tr.children();
		rowData.push(tr.text());
		
		var reservation = td.eq(1).text();
		var amount = td.eq(2).text();
		var method = td.eq(3).text();
		var date = td.eq(4).text();
		var account = td.eq(5).text();
		
		
		var url = "/SogongDo_Management_System/Refund_Mgmt/RefundUpdateView.jsp?reservation="+reservation+"&amount="+amount+"&method="+method+"&date="+date
		+"&account="+account;
	    var title = "RefundUpdateView";
	    var option = "width = 400, height = 300, top = 300, left = 700, location = no"
	   	window.open(url, title, option);
	});
}

</script>

</html>

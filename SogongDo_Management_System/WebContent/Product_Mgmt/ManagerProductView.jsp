<%@ page import = "java.util.List" %>
<%@ page import="Product_Mgmt.persistance.ProductDTO"%>
<%@ page import="Product_Mgmt.persistance.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 관리</title>
	
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
     <h3>상품 관리</h3>
    	
     <table>
         <thead>
             <tr>
                 <th>상품 코드</th>
                 <th>상품명</th>
                 <th>상품 분류</th>
                 <th>상품 가격</th>
                 <th>상품 수량</th>
                 <th>수정</th>
                 <th>삭제</th>
             </tr>
         </thead>
         <%
         	List<ProductDTO> pdList = (List<ProductDTO>) request.getAttribute("productList");
                                         	for(ProductDTO dto : pdList){
                                         		pageContext.setAttribute("dto", dto);
         %>
         
         <tbody>
             <tr>
                 <td>${dto.product_ID}</td>
                 <td>${dto.product_Name}</td>
                 <td>${dto.product_Kinds}</td>
                 <td>${dto.product_Price}</td>
                 <td>${dto.product_Stock}</td>
                 <td><Button type="button" class="bt" onclick="window.open('/SogongDo_Management_System/Product_Mgmt/UpdateProductView.jsp?id=<%=dto.getProduct_ID() %>&name=<%=dto.getProduct_Name() %>&kinds=<%=dto.getProduct_Kinds()%>&price=<%=dto.getProduct_Price()%>&stock=<%=dto.getProduct_Stock()%>', '상품 수정하기', 'width=450,height=400,location=no,status=no');">수정</Button></td>
                 <td onclick = "deleteProduct(<%=dto.getProduct_ID() %>)"><Button class="bt">삭제</Button></td>
             </tr>
         </tbody>
         <%} %>
     </table>
 
	 <form method="GET">
	    		<input class="bt" style="left:14%" type="button" value= "상품정보 등록하기" id="btnEnroll" onclick="showEnrollView()">
	 </form>

</body>

<script>


function showEnrollView() { //등록
	
    var url = "../Product_Mgmt/EnrollProductView.jsp";
    var title = "EnrollProductView";
    var option = "width = 500, height = 400, top = 100, left = 200, location = no"
   	window.open(url, title, option);
}


function deleteProduct(id)
{	
	var con_test = confirm(id+ "을(를) 정말로 삭제하겠습니까?");
	if(con_test) location.href = "/SogongDo_Management_System/Product/delete?id="+id;
}

</script>

</html>

<!-- 
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

 -->

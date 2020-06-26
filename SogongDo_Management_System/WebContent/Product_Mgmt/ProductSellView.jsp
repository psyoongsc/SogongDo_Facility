<%@ page import = "java.util.List" %>
<%@ page import="Product_Mgmt.persistance.ProductSellDTO"%>
<%@ page import="Product_Mgmt.persistance.ProductSellDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 판매 실적 집계</title>
	
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
    </style>
	
</head>
<body>
<%@ include file="../head_banner.jsp" %>
<h3>상품 판매 집계</h3>
    <div class="m_contents">
 
        <div class="product_contents">
            <table class="productTb">
                <thead>
                    <tr>
                        <th>판매ID</th>
                        <th>상품ID</th>
                        <th>판매갯수</th>
                        <th>판매가격</th>
                        <th>합계</th> 
                        <th>판매일자</th>
                        <th>결제자</th>
                    </tr>
                </thead>
                <%
                	List<ProductSellDTO> list = (List<ProductSellDTO>) request.getAttribute("productSellList");
                                	for(ProductSellDTO productSell : list){
                                		pageContext.setAttribute("productSell", productSell);
                                		int sum = productSell.getQuantity() * productSell.getPrice();
                %>
                
                <tbody>
                    <tr>
                        <td>${productSell.sell_ID}</td>
                        <td>${productSell.product_ID}</td>
                        <td>${productSell.quantity}</td>
                        <td>${productSell.price}</td>
                        <td><%=sum %></td>
                        <td>${productSell.sell_Date}</td>
                        <td>${productSell.seller}</td>
                    </tr>
                </tbody>
                <%} %>
            </table>
        </div>
    </div>

</body>
</html>

<!-- 
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

 -->

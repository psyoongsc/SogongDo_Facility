<%@ page import = "java.util.List" %>
<%@ page import="Product_Mgmt.persistance.ProductDTO"%>
<%@ page import="Product_Mgmt.persistance.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 정보</title>
	
   	<link href="${pageContext.request.contextPath}/css/UPV.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="m_contents">
        <div class="search_contents">
            <form action="/SogongDo_Management_System/Product_Mgmt/UserProductSearchView.jsp", method="post">
                <input type="text" name="searchText">
                <input type="submit" value="상품명 검색">
            </form>

        </div>
        <div class="product_contents">
            <h4>상품 목록</h4>
            <table class="productTb">
                <thead>
                    <tr>
                        <th>상품 코드</th>
                        <th>상품명</th>
                        <th>상품 분류</th>
                        <th>상품 가격</th>
                        <th>상품 수량</th>
                    </tr>
                </thead>
                         
                <%
                   	request.setCharacterEncoding("UTF-8");
                    String productName = request.getParameter("searchText");
                                     	
                    ProductDAO productDAO = new ProductDAO();
                    List<ProductDTO> searchList = productDAO.searchProduct(productName);
                    for(ProductDTO dto : searchList){
                        pageContext.setAttribute("dto", dto);
                 %>
                <tbody>
                    <tr>
                        <td>${dto.product_ID}</td>
                        <td>${dto.product_Name}</td>
                        <td>${dto.product_Kinds}</td>
                        <td>${dto.product_Price}</td>
                        <td>${dto.product_Stock}</td>
                    </tr>
                </tbody>
                <%} %>
            </table>
            <button type="button" onclick="reloadUserProductView()">목록</button>
        </div>
    </div>
</body>

<script>
	function reloadUserProductView()
	{
		location.href="/SogongDo_Management_System/Product/User/view";
	}
</script>

</html>

<!-- 
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

 -->
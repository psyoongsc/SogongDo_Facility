package Product_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Product_Mgmt.persistance.ProductDTO;
import Product_Mgmt.persistance.ProductDAO;

@WebServlet("/Product/User/view")
public class UserProductController extends HttpServlet{
	private ProductDAO productDAO = new ProductDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		requestDisplayProduct(req,resp);
	}
	
	protected void requestDisplayProduct (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ArrayList<ProductDTO> productList;
		productList = productDAO.displayProduct();
		
		req.setAttribute("productList", productList); //jsp �������� �ѱ��
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Product_Mgmt/UserProductView.jsp");
		dispatcher.forward(req, resp);
		
//		dispatcher.include(req, resp); //��� �̿� Ǫ�� ���, ��û jsp�� ���ƿ´�.
//		dispatcher = req.getRequestDispatcher("/footer.jsp");
//		dispatcher.include(req, resp);
		
	}

}

/*
<!-- 
��� ������ : �ڼ���
������ : �ڼ���, ����ȯ
���� ��¥: 2020-06-05
 -->
*/
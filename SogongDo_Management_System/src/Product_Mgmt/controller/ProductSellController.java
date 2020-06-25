package Product_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Product_Mgmt.persistance.ProductSellDTO;
import Product_Mgmt.persistance.ProductSellDAO;



//�Ǹ� ���� ����
@WebServlet("/Product/Sell/view")
public class ProductSellController extends HttpServlet{
	private ProductSellDAO productSellDAO = new ProductSellDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestDisplayProductSell(req, resp);
	}
	
	protected void requestDisplayProductSell(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ArrayList<ProductSellDTO> productSellList;
		productSellList = productSellDAO.displayProductSell();
		
		req.setAttribute("productSellList", productSellList); //jsp �������� �ѱ��
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Product_Mgmt/ProductSellView.jsp");
		dispatcher.forward(req, resp);
		
//		dispatcher.include(req, resp); //��� �̿� Ǫ�� ���, ��û jsp�� ���ƿ´�.
//		dispatcher = req.getRequestDispatcher("/footer.jsp");
//		dispatcher.include(req, resp);
	}

}

/*
��� ������ : �ڼ���
������ : �ڼ���, ����ȯ
���� ��¥: 2020-06-05
*/
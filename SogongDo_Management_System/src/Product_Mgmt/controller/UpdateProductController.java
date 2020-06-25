package Product_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Product_Mgmt.persistance.ProductDTO;
import Product_Mgmt.persistance.ProductDAO;

@WebServlet("/Product/update")
public class UpdateProductController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestUpdateProduct(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestUpdateProduct(req, resp);
	}

	private void requestUpdateProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		String id=req.getParameter("Product_ID");
        String name=req.getParameter("Product_Name");
        String kinds=req.getParameter("Product_Kinds");
        int price=Integer.parseInt(req.getParameter("Product_Price"));
        int stock=Integer.parseInt(req.getParameter("Product_Stock"));
        ProductDTO products = new ProductDTO(id,name,kinds,price,stock);
        
        ProductDAO productDAO = new ProductDAO();
        String updateCheck = Integer.toString(productDAO.updateProduct(products));
        req.setAttribute("updateCheck", updateCheck); //jsp �������� �ѱ��
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Product_Mgmt/UpdateProductView.jsp");
        dispatcher.forward(req, resp);
	}
}
/*
��� ������ : �ڼ���
������ : �ڼ���, ����ȯ
���� ��¥: 2020-06-05
���� ���� : 2020-06-08
���� ���� : updateProduct�� ��ȯ �� ����
*/
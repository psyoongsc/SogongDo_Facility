package Product_Mgmt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Product_Mgmt.persistance.ProductDAO;

@WebServlet("/Product/delete")
public class DeleteProductController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestDeleteProduct(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		requestDeleteProduct(req, resp);
	}

	private void requestDeleteProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		String id = req.getParameter("id");
		ProductDAO productDAO = new ProductDAO();
		productDAO.deleteProduct(id);

		resp.sendRedirect("/SogongDo_Management_System/Product/view");
	}
}
/*
모듈 설계자 : 박성용
검토자 : 박성용, 김인환
검토 날짜: 2020-06-05
*/
package Refund_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Refund_Mgmt.persistance.RefundDAO;

@WebServlet("/Refund/delete")
public class RefundDeleteController extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestDeleteRefund(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		requestDeleteRefund(req, resp);
	}

	public void requestDeleteRefund(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		String id = req.getParameter("id");
		RefundDAO RefundDAO = new RefundDAO();
		RefundDAO.deleteRefund(id);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/Refund/view");
		dispatcher.forward(req, resp);
	}
}
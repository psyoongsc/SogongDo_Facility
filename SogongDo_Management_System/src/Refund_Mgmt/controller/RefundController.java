package Refund_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Refund_Mgmt.persistance.RefundDAO;
import Refund_Mgmt.persistance.RefundDTO;

@WebServlet("/Refund/view")
public class RefundController  extends HttpServlet{
	public RefundDAO refundDAO = new RefundDAO();
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		requestDisplayRefund(req,resp);
		
	}
	public void requestDisplayRefund (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ArrayList<RefundDTO> refundList;
		refundList = refundDAO.selectRefund();
		
		req.setAttribute("refundList", refundList); 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Refund_Mgmt/RefundView.jsp");
		dispatcher.forward(req, resp);
		
	}

}

package Refund_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Refund_Mgmt.persistance.RefundDAO;
import Refund_Mgmt.persistance.RefundDTO;

@WebServlet("/Refund/update")
public class RefundUpdateController extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestUpdateRefund(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestUpdateRefund(req, resp);
	}

	public void requestUpdateRefund(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
		
		int reservation=Integer.parseInt(req.getParameter("Reservation_ID"));
        int amount=Integer.parseInt(req.getParameter("Refund_Amount"));
        String method=req.getParameter("Refund_Method");
        String date=req.getParameter("Refund_Date");
        String account=req.getParameter("Refund_Account");
        RefundDTO products = new RefundDTO(reservation,amount,method,date,account);
        
        RefundDAO refundDAO = new RefundDAO();
        String updateCheck = Integer.toString(refundDAO.updateRefund(products));
        req.setAttribute("updateCheck", updateCheck);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Refund_Mgmt/RefundUpdateView.jsp");
        dispatcher.forward(req, resp);
	}
}
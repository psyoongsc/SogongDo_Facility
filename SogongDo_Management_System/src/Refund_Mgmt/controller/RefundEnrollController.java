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

@WebServlet("/Refund/enroll")
public class RefundEnrollController  extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestEnrollRefund(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestEnrollRefund(req, resp);
	}

	public void requestEnrollRefund(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		RefundDTO refunds = new RefundDTO();
		refunds.setReservation_ID(Integer.parseInt(req.getParameter("Reservation_ID")));
		refunds.setRefund_Amount(Integer.parseInt(req.getParameter("Refund_Amount")));
		refunds.setRefund_Method(req.getParameter("Refund_Method"));
		refunds.setRefund_Date(req.getParameter("Refund_Date"));
		refunds.setRefund_Account(req.getParameter("Refund_Account"));
		     
		RefundDAO refundDAO = new RefundDAO();
        String checkEnroll = Integer.toString(refundDAO.enrollRefund(refunds));
        req.setAttribute("checkEnroll", checkEnroll);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Refund_Mgmt/RefundEnrollView.jsp");
        dispatcher.forward(req, resp);

	}
}

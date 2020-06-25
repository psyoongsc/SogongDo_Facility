package Payment_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Payment_Mgmt.persistance.PaymentDAO;
import Payment_Mgmt.persistance.PaymentDTO;

@WebServlet("/Payment/enroll")
public class PaymentEnrollController  extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestEnrollPayment(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestEnrollPayment(req, resp);
	}

	public void requestEnrollPayment(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		PaymentDTO payments = new PaymentDTO();
		payments.setReservation_ID(Integer.parseInt(req.getParameter("Reservation_ID")));
		payments.setCharge_ID(Integer.parseInt(req.getParameter("Charge_ID")));
		payments.setDiscount_Id(Integer.parseInt(req.getParameter("Discount_Id")));
		payments.setPayment_Method(req.getParameter("Payment_Method"));
		payments.setPayment_Amount(Integer.parseInt(req.getParameter("Payment_Amount")));
		payments.setPayment_Date(req.getParameter("Payment_Date"));
		     
        PaymentDAO paymentDAO = new PaymentDAO();
        String checkEnroll = Integer.toString(paymentDAO.enrollPayment(payments));
        req.setAttribute("checkEnroll", checkEnroll);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Payment_Mgmt/PaymentEnrollView.jsp");
        dispatcher.forward(req, resp);

	}
}

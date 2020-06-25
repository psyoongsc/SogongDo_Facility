package Payment_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Payment_Mgmt.persistance.PaymentDAO;
import Payment_Mgmt.persistance.PaymentDTO;

@WebServlet("/Payment/view")
public class PaymentController  extends HttpServlet{
	public PaymentDAO paymentDAO = new PaymentDAO();
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		requestDisplayPayment(req,resp);
		
	}
	public void requestDisplayPayment (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ArrayList<PaymentDTO> paymentList;
		paymentList = paymentDAO.selectPayment();
		
		req.setAttribute("paymentList", paymentList); 
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Payment_Mgmt/PaymentView.jsp");
		dispatcher.forward(req, resp);
		
		
	}

}

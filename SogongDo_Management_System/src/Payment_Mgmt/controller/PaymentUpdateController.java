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

@WebServlet("/Payment/update")
public class PaymentUpdateController extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestUpdatePayment(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestUpdatePayment(req, resp);
	}

	public void requestUpdatePayment(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		int reservation=Integer.parseInt(req.getParameter("Reservation_ID"));
		int charge=Integer.parseInt(req.getParameter("Charge_ID"));
		int discount=Integer.parseInt(req.getParameter("Discount_Id"));
        String method=req.getParameter("Payment_Method");
        int amount=Integer.parseInt(req.getParameter("Payment_Amount"));
        String date=req.getParameter("Payment_Date");
        PaymentDTO payments = new PaymentDTO(reservation,charge,discount,method,amount,date);
        
        PaymentDAO paymentDAO = new PaymentDAO();
        String updateCheck = Integer.toString(paymentDAO.updatePayment(payments));
        req.setAttribute("updateCheck", updateCheck);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Payment_Mgmt/PaymentUpdateView.jsp");
        dispatcher.forward(req, resp);
	}
}
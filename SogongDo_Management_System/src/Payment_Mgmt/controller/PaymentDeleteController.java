package Payment_Mgmt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Payment_Mgmt.persistance.PaymentDAO;

@WebServlet("/Payment/delete")
public class PaymentDeleteController extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestDeletePayment(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		requestDeletePayment(req, resp);
	}

	public void requestDeletePayment(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		String id = req.getParameter("id");
		PaymentDAO PaymentDAO = new PaymentDAO();
		PaymentDAO.deletePayment(id);

	}
}
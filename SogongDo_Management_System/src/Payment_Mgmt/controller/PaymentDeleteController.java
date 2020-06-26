package Payment_Mgmt.controller;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.server.RemoteCall;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Payment_Mgmt.persistance.PaymentDAO;
import sun.rmi.server.Dispatcher;

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

		RequestDispatcher dispatcher = req.getRequestDispatcher("/Payment/view");
		dispatcher.forward(req, resp);
	}
}
package Reserv_Cancel_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Reserv_Cancel_Mgmt.persistance.CancelDAO;
import Reserv_Cancel_Mgmt.persistance.CancelDTO;

@WebServlet("/Reservation/Cancel/update/view")
public class UpdateCancelViewController extends HttpServlet{
	private CancelDAO canceldao = new CancelDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String rID = req.getParameter("id");
		System.out.println("Á¶È¸ÇÒ ID : " + rID);
		CancelDTO dto = canceldao.inquiryC(rID);
		
		System.out.println("TEST : " + dto.getReservation_Name());
		
		req.setAttribute("dto", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Reserv_Cancel_Mgmt/UpdateCancelView.jsp");
		dispatcher.forward(req, resp);
	}
}

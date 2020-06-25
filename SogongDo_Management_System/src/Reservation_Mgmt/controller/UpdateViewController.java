package Reservation_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Reservation_Mgmt.persistance.ReservationDAO;
import Reservation_Mgmt.persistance.ReservationDTO;

@WebServlet("/Reservation/update/view")
public class UpdateViewController extends HttpServlet{
	private ReservationDAO reservedao = new ReservationDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String rID = req.getParameter("id");
		ReservationDTO dto = reservedao.inquiry(rID);

		req.setAttribute("dto", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Reservation_Mgmt/UpdateReserveView.jsp");
		dispatcher.forward(req, resp);
	}
}

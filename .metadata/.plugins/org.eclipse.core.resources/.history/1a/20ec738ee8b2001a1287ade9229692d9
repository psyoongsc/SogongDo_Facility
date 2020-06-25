package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.FacilityChargeDAO;
import persistance.FacilityChargeDTO;

@WebServlet("/facilityCharge/display")
public class DisplayFacilityChargeController extends HttpServlet{
	private FacilityChargeDAO FacilityChargeDAO = new FacilityChargeDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<FacilityChargeDTO> FacilityChargeDto;		
		FacilityChargeDto = FacilityChargeDAO.select();
		 
		req.setAttribute("FacilityChargeDto", FacilityChargeDto);		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/DisplayFacilityChargeView.jsp");
		dispatcher.forward(req, resp);
	}
}

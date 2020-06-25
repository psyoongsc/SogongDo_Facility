package FacilityCharge_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FacilityCharge_Mgmt.persistance.FacilityChargeDAO;
import FacilityCharge_Mgmt.persistance.FacilityChargeDTO;

@WebServlet("/Facility/Charge/view")
public class DisplayFacilityChargeController extends HttpServlet{
	private FacilityChargeDAO FacilityChargeDAO = new FacilityChargeDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<FacilityChargeDTO> FacilityChargeDto;		
		FacilityChargeDto = FacilityChargeDAO.select();
		 
		req.setAttribute("FacilityChargeDto", FacilityChargeDto);		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/FacilityCharge_Mgmt/DisplayFacilityChargeView.jsp");
		dispatcher.forward(req, resp);
	}
}

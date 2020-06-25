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

@WebServlet("/facilityCharge/update")
public class UpdateFacilityChargeController extends HttpServlet{
	private FacilityChargeDAO FacilityChargeDAO = new FacilityChargeDAO();
	private String sChargeID;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sTouristSite = req.getParameter("touristSite");
		String sFacility = req.getParameter("facility");
		String sCharge = req.getParameter("charge");
		
		if(sTouristSite==null) {
			sChargeID = req.getParameter("chargeID");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/UpdateFacilityChargeView.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			int chargeID = Integer.parseInt(sChargeID);
			int touristSite = Integer.parseInt(sTouristSite);
			int facility = Integer.parseInt(sFacility);
			int charge = Integer.parseInt(sCharge);
			
			FacilityChargeDAO.update(chargeID, touristSite, facility, charge);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/facilityCharge/display");
			dispatcher.forward(req, resp);
		}
	}
}
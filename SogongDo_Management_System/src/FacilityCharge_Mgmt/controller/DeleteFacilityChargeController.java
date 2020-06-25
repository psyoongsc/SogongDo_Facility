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

@WebServlet("/Facility/Charge/delete")
public class DeleteFacilityChargeController extends HttpServlet{
	private FacilityChargeDAO FacilityChargeDAO = new FacilityChargeDAO();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int chargeID = Integer.parseInt(req.getParameter("chargeID"));
		
		FacilityChargeDAO.delete(chargeID);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Facility/Charge/view");
		dispatcher.forward(req, resp);
	}
}
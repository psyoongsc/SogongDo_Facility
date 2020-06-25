package FacilityCharge_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FacilityCharge_Mgmt.persistance.FacilityChargeDiscountDAO;
import FacilityCharge_Mgmt.persistance.FacilityChargeDiscountDTO;

@WebServlet("/Facility/Charge/discount/delete")
public class DeleteDiscountController extends HttpServlet{
	private FacilityChargeDiscountDAO FacilityChargeDiscountDAO = new FacilityChargeDiscountDAO();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int chargeID = Integer.parseInt(req.getParameter("chargeID"));
		
		FacilityChargeDiscountDAO.delete(chargeID);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Facility/Charge/discount/view");
		dispatcher.forward(req, resp);
	}
}
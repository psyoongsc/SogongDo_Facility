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

@WebServlet("/Facility/Charge/discount/update")
public class UpdateDiscountController extends HttpServlet{
	private FacilityChargeDiscountDAO FacilityChargeDiscountDAO = new FacilityChargeDiscountDAO();
	private String sChargeID;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sDiscountReason = req.getParameter("discountReason");
		String sDiscountRate = req.getParameter("discountRate");
		
		if(sDiscountReason==null) {
			sChargeID = req.getParameter("chargeID");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/FacilityCharge_Mgmt/UpdateFacilityChargeDiscountView.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			int chargeID = Integer.parseInt(sChargeID);
			String discountReason = sDiscountReason;
			int discountRate = Integer.parseInt(sDiscountRate);
			
			FacilityChargeDiscountDAO.update(chargeID, discountReason, discountRate);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Facility/Charge/discount/view");
			dispatcher.forward(req, resp);
		}
	}
}
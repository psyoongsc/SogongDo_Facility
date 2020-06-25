package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.FacilityChargeDiscountDAO;
import persistance.FacilityChargeDiscountDTO;

@WebServlet("/facilityCharge/discount/update")
public class UpdateDiscountController extends HttpServlet{
	private FacilityChargeDiscountDAO FacilityChargeDiscountDAO = new FacilityChargeDiscountDAO();
	private String sChargeID;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sDiscountReason = req.getParameter("discountReason");
		String sDiscountRate = req.getParameter("discountRate");
		
		if(sDiscountReason==null) {
			sChargeID = req.getParameter("chargeID");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/UpdateFacilityChargeDiscountView.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			int chargeID = Integer.parseInt(sChargeID);
			String discountReason = sDiscountReason;
			int discountRate = Integer.parseInt(sDiscountRate);
			
			FacilityChargeDiscountDAO.update(chargeID, discountReason, discountRate);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/facilityCharge/discount/display");
			dispatcher.forward(req, resp);
		}
	}
}
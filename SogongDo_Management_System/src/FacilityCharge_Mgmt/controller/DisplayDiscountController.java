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

@WebServlet("/Facility/Charge/discount/view")
public class DisplayDiscountController extends HttpServlet{
	private FacilityChargeDiscountDAO FacilityChargeDiscountDAO = new FacilityChargeDiscountDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<FacilityChargeDiscountDTO> FacilityChargeDiscountDto;
		FacilityChargeDiscountDto = FacilityChargeDiscountDAO.select();
		 
		req.setAttribute("FacilityChargeDiscountDto", FacilityChargeDiscountDto);		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/FacilityCharge_Mgmt/DisplayFacilityChargeDiscountView.jsp");
		dispatcher.forward(req, resp);
	}
}

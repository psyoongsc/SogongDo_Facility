package Facility_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facility_Mgmt.persistence.FacilityAttributeDAO;
import Facility_Mgmt.persistence.FacilityAttributeDTO;

@WebServlet("/Facility/Attribute/enroll")
public class FacilityAttributeEnrollControl extends HttpServlet{
	private FacilityAttributeDAO facilityAttributeDAO = new FacilityAttributeDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String tName = req.getParameter("Tourist_Site_Name");
		String fName = req.getParameter("Facility_Name");
		int fState = Integer.parseInt(req.getParameter("Facility_State"));
		String fManager = req.getParameter("Facility_Manager");
		String fPhoneNumber = req.getParameter("Facility_PhoneNumber");
		
		facilityAttributeDAO.enrollFacilityAttributeInfo(new FacilityAttributeDTO(tName, 0, fName, fState, fManager, fPhoneNumber));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Facility_Mgmt/facilityAttributeEnrollView.jsp");
		dispatcher.forward(req, resp);
	}
}

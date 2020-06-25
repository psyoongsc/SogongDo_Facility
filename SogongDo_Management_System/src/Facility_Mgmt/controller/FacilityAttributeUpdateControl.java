package Facility_Mgmt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facility_Mgmt.persistence.FacilityAttributeDAO;
import Facility_Mgmt.persistence.FacilityAttributeDTO;

@WebServlet("/Facility/Attribute/update")
public class FacilityAttributeUpdateControl extends HttpServlet{
	private FacilityAttributeDAO facilityAttributeDAO = new FacilityAttributeDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
		
		String tName = req.getParameter("Tourist_Site_Name");
		int fID = Integer.parseInt(req.getParameter("Facility_ID"));
		String fName = req.getParameter("Facility_Name");
		int fStatus = Integer.parseInt(req.getParameter("Facility_Status"));
		String fManager = req.getParameter("Facility_Manager");
		String fPhoneNumber = req.getParameter("Facility_PhoneNumber");
		
		facilityAttributeDAO.updateFacilityAttributeInfo(new FacilityAttributeDTO(tName, fID, fName, fStatus, fManager, fPhoneNumber));
	}
}

package Facility_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facility_Mgmt.persistence.FacilityDAO;
import Facility_Mgmt.persistence.FacilityDTO;

@WebServlet("/Facility/update")
public class FacilityUpdateControl extends HttpServlet{
	private FacilityDAO facilityDAO = new FacilityDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
		
		String tName = req.getParameter("Tourist_Site_Name");
		int fID = Integer.parseInt(req.getParameter("Facility_ID"));
		String fName = req.getParameter("Facility_Name");
		
		facilityDAO.updateFacilityInfo(new FacilityDTO(tName, fID, fName));
	}
}

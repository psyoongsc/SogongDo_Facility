package Facility_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facility_Mgmt.persistence.FacilityDAO;
import Facility_Mgmt.persistence.FacilityDTO;

@WebServlet("/Facility/view")
public class FacilityManageControl extends HttpServlet{
	private FacilityDAO facilityDAO = new FacilityDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
		
		ArrayList<FacilityDTO> facilityList;
		facilityList = facilityDAO.displayFacilityInfo();
		
		req.setAttribute("facilityList", facilityList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Facility_Mgmt/facilityManageView.jsp");
		dispatcher.forward(req, resp);
	}
}

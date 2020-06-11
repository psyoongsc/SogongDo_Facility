package Facility_Management.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facility_Management.persistence.FacilityDAO;
import Facility_Management.persistence.FacilityDTO;

@WebServlet("/facility/")
public class FacilityManageControl extends HttpServlet{
	private FacilityDAO facilityDAO = new FacilityDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
		
		ArrayList<FacilityDTO> facilityList;
		facilityList = facilityDAO.displayFacilityInfo();
		
		req.setAttribute("facilityList", facilityList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/facilityManageView.jsp");
		dispatcher.forward(req, resp);
	}
}

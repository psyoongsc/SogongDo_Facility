package Facility_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facility_Mgmt.persistence.FacilityAttributeDAO;
import Facility_Mgmt.persistence.FacilityAttributeDTO;

@WebServlet("/Facility/Attribute/view")
public class FacilityAttributeManageControl extends HttpServlet{
	private FacilityAttributeDAO facilityAttributeDAO = new FacilityAttributeDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
		
		ArrayList<FacilityAttributeDTO> facilityAttributeList;
		facilityAttributeList = facilityAttributeDAO.displayFacilityAttributeInfo();
		
		req.setAttribute("facilityAttributeList", facilityAttributeList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Facility_Mgmt/facilityAttributeManageView.jsp");
		dispatcher.forward(req, resp);
	}
}

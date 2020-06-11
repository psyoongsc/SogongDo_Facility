package Facility_Management.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Facility_Management.persistence.FacilityAttributeDAO;
import Facility_Management.persistence.FacilityAttributeDTO;

@WebServlet("/facilityAttribute/")
public class FacilityAttributeManageControl extends HttpServlet{
	private FacilityAttributeDAO facilityAttributeDAO = new FacilityAttributeDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
		
		ArrayList<FacilityAttributeDTO> facilityAttributeList;
		facilityAttributeList = facilityAttributeDAO.displayFacilityAttributeInfo();
		
		req.setAttribute("facilityAttributeList", facilityAttributeList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/facilityAttributeManageView.jsp");
		dispatcher.forward(req, resp);
	}
}

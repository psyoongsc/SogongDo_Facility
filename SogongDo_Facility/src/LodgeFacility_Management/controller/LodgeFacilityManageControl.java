package LodgeFacility_Management.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LodgeFacility_Management.persistence.LodgeFacilityDAO;
import LodgeFacility_Management.persistence.LodgeFacilityDTO;

@WebServlet("/lodgeFacility")
public class LodgeFacilityManageControl extends HttpServlet {
	private LodgeFacilityDAO lodgeFacilityDAO = new LodgeFacilityDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		ArrayList<LodgeFacilityDTO> lodgeFacilityList;
		lodgeFacilityList = lodgeFacilityDAO.displayLodgeFacilityInfo();
		
		req.setAttribute("lodgeFacilityList", lodgeFacilityList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/lodgeFacilityManageView.jsp");
		dispatcher.forward(req, resp);
	}
}

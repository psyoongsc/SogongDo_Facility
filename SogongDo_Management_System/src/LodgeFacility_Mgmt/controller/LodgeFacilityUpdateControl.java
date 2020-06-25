package LodgeFacility_Mgmt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LodgeFacility_Mgmt.persistence.LodgeFacilityDAO;
import LodgeFacility_Mgmt.persistence.LodgeFacilityDTO;

@WebServlet("/Facility/Lodge/update")
public class LodgeFacilityUpdateControl extends HttpServlet {
	private LodgeFacilityDAO lodgeFacilityDAO = new LodgeFacilityDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		int lodgeFacilityID = Integer.parseInt(req.getParameter("Lodge_Facility_ID"));
		int lodgeNumber = Integer.parseInt(req.getParameter("Lodge_Number"));
		int roomNumber = Integer.parseInt(req.getParameter("Room_Number"));
		
		lodgeFacilityDAO.updateLodgeFacilityInfo(new LodgeFacilityDTO("", 0, "", lodgeFacilityID, lodgeNumber, roomNumber));
	}
}

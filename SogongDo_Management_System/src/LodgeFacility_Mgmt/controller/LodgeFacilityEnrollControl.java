package LodgeFacility_Mgmt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import LodgeFacility_Mgmt.persistence.LodgeFacilityDAO;
import LodgeFacility_Mgmt.persistence.LodgeFacilityDTO;

@WebServlet("/Facility/Lodge/enroll")
public class LodgeFacilityEnrollControl extends HttpServlet {
	private LodgeFacilityDAO lodgeFacilityDAO = new LodgeFacilityDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String tName = req.getParameter("Tourist_Site_Name");
		String fName = req.getParameter("Facility_Name");
		int lNum = Integer.parseInt(req.getParameter("Lodge_Number"));
		int rNum = Integer.parseInt(req.getParameter("Room_Number"));
		
		lodgeFacilityDAO.enrollLodgeFacilityInfo(new LodgeFacilityDTO(tName, 0, fName, 0, lNum, rNum));
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/LodgeFacility_Mgmt/lodgeFacilityEnrollView.jsp");
		dispatcher.forward(req, resp);
	}
}

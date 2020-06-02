package Facility_Management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/facility/*")
public class FacilityControl extends HttpServlet{
	private FacilityDAO facilityDAO = new FacilityDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] uri = req.getRequestURI().trim().split("/");
		ArrayList<FacilityDTO> facilityDto;

		if(uri[2].equals("enroll")) {
			
		} else if(uri[2].equals("update")) {
			
		} else if(uri[2].equals("delete")) {
			
		} else {
			facilityDto = facilityDAO.displayFacilityInfo();
			req.setAttribute("facilityDto", facilityDto);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/facilityManageView.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	public boolean formatCheck(FacilityDTO facilityInfo) {
		boolean isAvailable = false;
		
		return isAvailable;
	}
	
	public boolean essentialCheck(FacilityDTO facilityInfo) {
		boolean isAvailable = false;
		
		return isAvailable;
	}
	
	public boolean redundancyCheck(FacilityDTO facilityInfo) {
		boolean isAvailable = false;
		
		return isAvailable;
	}
}

package TouristSite_Mgmt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TouristSite_Mgmt.persistance.TouristSiteAttributeDTO;
import TouristSite_Mgmt.persistance.TouristSiteDAO;

@WebServlet("/TouristSite/Attribute/enroll")
public class RegisterTouristSiteAttributeController extends HttpServlet {
	private TouristSiteDAO ts = new TouristSiteDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		int tourist_site_id = Integer.parseInt(request.getParameter("tourist_site_id"));
		String tourist_site_name = request.getParameter("tourist_site_address");
		String tourist_site_phone_number = request.getParameter("tourist_site_phone_number");
		int registration_number = Integer.parseInt(request.getParameter("registration_number"));
		String representative_name = request.getParameter("representative_name");
		TouristSiteAttributeDTO temp = new TouristSiteAttributeDTO(tourist_site_id, tourist_site_name,tourist_site_phone_number,registration_number,representative_name);
		ts.insertAttribute(temp);
		response.sendRedirect("/SogongDo_Management_System/TouristSite/Attribute/view?tourist_site_id="+tourist_site_id);
	}
}
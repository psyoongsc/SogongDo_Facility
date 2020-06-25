package TouristSite_Mgmt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TouristSite_Mgmt.persistance.TouristSiteDAO;
import TouristSite_Mgmt.persistance.TouristSiteDTO;

@WebServlet("/TouristSite/update")
public class UpdateTouristSiteController extends HttpServlet{
	private TouristSiteDAO ts = new TouristSiteDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
			int tourist_site_id = Integer.parseInt(request.getParameter("tourist_site_id"));
			String tourist_site_name = request.getParameter("tourist_site_name");
			TouristSiteDTO temp = new TouristSiteDTO(tourist_site_id, tourist_site_name);
			ts.updateTouristSite(temp);

			response.sendRedirect("/SogongDo_Management_System/TouristSite/view");
	
}
}

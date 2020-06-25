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

import TouristSite_Mgmt.persistance.TouristSiteDAO;

@WebServlet("/TouristSite/Attribute/delete")
public class DeleteTouristSiteAttributeController extends HttpServlet {
	private TouristSiteDAO ts = new TouristSiteDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		int tourist_site_id = Integer.parseInt(request.getParameter("tourist_site_id"));
		ts.deleteAttribute(tourist_site_id);
	
		response.sendRedirect("/SogongDo_Management_System/TouristSite/Attribute/view?tourist_site_id="+tourist_site_id);
		}

}

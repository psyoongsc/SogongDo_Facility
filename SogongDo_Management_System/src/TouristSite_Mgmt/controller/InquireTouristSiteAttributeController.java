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
import TouristSite_Mgmt.persistance.TouristSiteDTO;

@WebServlet("/TouristSite/Attribute/view")
public class InquireTouristSiteAttributeController extends HttpServlet{
	private TouristSiteDAO ts = new TouristSiteDAO();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		int tourist_site_id = Integer.parseInt(request.getParameter("tourist_site_id"));
		TouristSiteDTO touristSite = null;
		TouristSiteAttributeDTO attribute = null;
		touristSite = ts.getTouristSite(tourist_site_id);
		attribute = ts.getAttribute(tourist_site_id);

		request.setAttribute("touristSite", touristSite);
		request.setAttribute("attribute", attribute);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TouristSite_Mgmt/InquireTouristSiteAttributeView.jsp");
		dispatcher.forward(request, response);
	}
}
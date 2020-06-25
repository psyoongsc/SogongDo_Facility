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
import TouristSite_Mgmt.persistance.TouristSiteDTO;

@WebServlet("/TouristSite/view")
public class InquireTouristSiteController extends HttpServlet {
	private TouristSiteDAO ts = new TouristSiteDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		List<TouristSiteDTO> tourist_site_list = null;
		
		
		if(request.getParameter("name") == null)
		{
			tourist_site_list = ts.getAllTouristSite();
		} 
		else
		{
			tourist_site_list = ts.getTouristSiteByName(request.getParameter("name"));
		}
		
		request.setAttribute("tourist_site_list", tourist_site_list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TouristSite_Mgmt/InquireTouristSiteView.jsp");
		dispatcher.forward(request, response);
		}

}

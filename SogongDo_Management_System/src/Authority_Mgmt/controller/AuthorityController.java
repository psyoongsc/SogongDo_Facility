package Authority_Mgmt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Authority_Mgmt.persistance.AuthorityDAO;
import Authority_Mgmt.persistance.AuthorityDTO;

/*
모둘 설계자 : 김인환
검토자 : 박성용, 김주현
검토 날짜: 06/05
수정 일자:
수정 내용:
*/


@WebServlet("/Authority/view")
public class AuthorityController  extends HttpServlet {
   private AuthorityDAO authorityDAO = new AuthorityDAO();

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       ArrayList<AuthorityDTO> authorityDto;
       authorityDto = authorityDAO.select();
       
       req.setAttribute("authorityDto",authorityDto);
       RequestDispatcher dispatcher = req.getRequestDispatcher("/Authority_Mgmt/AuthorityView.jsp");
       dispatcher.forward(req,resp);
   }
}
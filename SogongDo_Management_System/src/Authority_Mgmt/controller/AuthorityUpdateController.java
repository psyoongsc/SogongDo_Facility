package Authority_Mgmt.controller;
import java.io.IOException;

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
수정 일자: 06.05
수정 내용: 수정 누르고 다시 원래 수정화면으로 돌아가게 했음
*/



@WebServlet("/Authority/update")
public class AuthorityUpdateController extends HttpServlet{
   private AuthorityDAO authorityDAO = new AuthorityDAO();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("authoirity_Id"));
       String name = req.getParameter("id_text");
       AuthorityDTO dto = new AuthorityDTO(id, name);
       authorityDAO.update(dto);

       resp.sendRedirect("/SogongDo_Management_System/Authority_Mgmt/AuthorityUpdateView.jsp");
   }
}

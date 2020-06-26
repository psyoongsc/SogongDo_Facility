package Authority_Mgmt.controller;
import java.io.IOException;
import java.io.PrintWriter;

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



@WebServlet("/Authority/delete")
public class AuthorityDeleteController extends  HttpServlet {
   private AuthorityDAO authorityDAO = new AuthorityDAO();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("name"));
       String name = req.getParameter("id");
       AuthorityDTO dto = new AuthorityDTO(id, name);
       authorityDAO.delete(dto);
       
       PrintWriter out = resp.getWriter(); //선언
       
       String str="";
       str = "<script language='javascript'>";
       str += "opener.window.location.reload();";  //오프너 새로고침
       str += "self.close();";   // 창닫기
        str += "</script>";
       out.print(str);
   }
}
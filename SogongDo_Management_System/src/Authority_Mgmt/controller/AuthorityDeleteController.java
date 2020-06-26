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
��� ������ : ����ȯ
������ : �ڼ���, ������
���� ��¥: 06/05
���� ����:
���� ����:
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
       
       PrintWriter out = resp.getWriter(); //����
       
       String str="";
       str = "<script language='javascript'>";
       str += "opener.window.location.reload();";  //������ ���ΰ�ħ
       str += "self.close();";   // â�ݱ�
        str += "</script>";
       out.print(str);
   }
}
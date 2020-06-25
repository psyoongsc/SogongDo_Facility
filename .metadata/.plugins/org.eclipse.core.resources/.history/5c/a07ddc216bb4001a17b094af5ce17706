package Controller;

import persistance.AuthorityDAO;
import persistance.AuthorityDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/*
 모둘 설계자 : 김인환

 검토자 : 박성용, 김주현
 검토 날짜: 06/05

 수정 일자: 06.05
 수정 내용: 등록 누르고 다시 원래 등록화면으로 돌아가게 했음

 */




@WebServlet("/Enroll")
public class AuthorityEnrollController extends HttpServlet {
    private AuthorityDAO authorityDAO = new AuthorityDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("authoirity_Id"));
        String name = req.getParameter("id_text");
        AuthorityDTO dto = new AuthorityDTO(id, name);
        authorityDAO.insert(dto);

        resp.sendRedirect("AuthorityEnrollView.jsp");
    }
}



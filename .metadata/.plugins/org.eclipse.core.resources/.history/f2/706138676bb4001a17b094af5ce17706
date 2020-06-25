package Controller;

import persistance.AuthorityDAO;
import persistance.AuthorityDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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

 수정 일자:
 수정 내용:

 */


@WebServlet("/AuthorityView")
public class AuthorityController  extends HttpServlet {
    private AuthorityDAO authorityDAO = new AuthorityDAO();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<AuthorityDTO> authorityDto;
        authorityDto = authorityDAO.select();
        req.setAttribute("authorityDto",authorityDto);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/AuthorityView.jsp");
        dispatcher.forward(req,resp);
    }
}

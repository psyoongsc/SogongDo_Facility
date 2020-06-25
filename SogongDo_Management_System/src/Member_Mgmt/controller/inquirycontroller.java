package Member_Mgmt.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member_Mgmt.persistance.*;

@WebServlet("/Member/view")
public class inquirycontroller extends HttpServlet{
	private MemberDAO memberdao = new MemberDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<MemberDTO> member;
		member = memberdao.select();
		req.setAttribute("member", member);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Member_Mgmt/inquiry.jsp");
		dispatcher.forward(req, resp);
	}
}

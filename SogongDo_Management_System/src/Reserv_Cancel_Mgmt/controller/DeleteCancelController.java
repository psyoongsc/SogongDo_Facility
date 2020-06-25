package Reserv_Cancel_Mgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import Reserv_Cancel_Mgmt.persistance.CancelDAO;
import Reserv_Cancel_Mgmt.persistance.CancelDTO;

@WebServlet("/Reservation/Cancel/delete")
public class DeleteCancelController extends HttpServlet{
	private CancelDAO canceldao = new CancelDAO();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cnt= Integer.parseInt(req.getParameter("cnt"));
		String[] cancelIdArr = new String[cnt];
		for(int i=0; i<cnt; i++){
			cancelIdArr[i] = req.getParameter("id"+i);
		}
		int rs = canceldao.deleteC(cancelIdArr);
		PrintWriter out = resp.getWriter();
		
		if(rs==cnt){
			out.print("<script>alert('성공적으로 삭제되었습니다');var url =\"view\" ;window.location.href = url;</script>");
		}else{
			out.print("<script>alert('삭제가 실패되었습니다');var url =\"view\" ;window.location.href = url;</script>");
		}
	}
}

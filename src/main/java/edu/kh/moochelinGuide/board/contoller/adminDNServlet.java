package edu.kh.moochelinGuide.board.contoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.moochelinGuide.board.model.service.BoardService;

@WebServlet("/admin/notice/noticeDelete")
public class adminDNServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BoardService service = new BoardService();
			int boardNo = Integer.parseInt(req.getParameter("no"));
			
			int result = 0;
			result = service.noticeDelete(boardNo);
			
			resp.sendRedirect(req.getHeader("referer"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

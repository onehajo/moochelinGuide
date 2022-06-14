package edu.kh.moochelinGuide.board.contoller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.board.model.service.BoardService;
import edu.kh.moochelinGuide.member.model.vo.Member;

@WebServlet("/admin/inquiryList")
public class AdminILServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int array = Integer.parseInt(req.getParameter("array"));
			int cp = 1;
			
			if(req.getParameter("cp")!=null) {
				cp = Integer.parseInt(req.getParameter("cp"));
			}
				
			int MemberCd = 1;
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/adminIL.jsp");
			
			BoardService service = new BoardService();
			
			HttpSession session = req.getSession();
			Member member = (Member)session.getAttribute("loginMember");
			
			int boardNo = member.getMemberNo();
			Map<String, Object> map = service.boardList(boardNo, array,cp,MemberCd);
			
			req.setAttribute("array", array);
			req.setAttribute("boardList", map.get("boardList"));
			req.setAttribute("pagination", map.get("pagination"));
			
			dispatcher.forward(req, resp);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}

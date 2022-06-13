package edu.kh.moochelinGuide.board.contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.board.model.service.BoardService;
import edu.kh.moochelinGuide.board.model.service.ReplyService;
import edu.kh.moochelinGuide.board.model.vo.Board;
import edu.kh.moochelinGuide.member.model.vo.Member;

@WebServlet("/member/myPage/inquiryList")
public class InquiryLServlet extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	try {
		int array = Integer.parseInt(req.getParameter("array"));
		
	RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/inquiryList.jsp");
	
	List<Board> boardList = new ArrayList<Board>();
	
	BoardService service = new BoardService();
	
	HttpSession session = req.getSession();
	Member member = (Member)session.getAttribute("loginMember");
	
	int boardNo = member.getMemberNo();
	boardList = service.boardList(boardNo, array);

	req.setAttribute("array", array);
	req.setAttribute("boardList", boardList);
	
	dispatcher.forward(req, resp);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}

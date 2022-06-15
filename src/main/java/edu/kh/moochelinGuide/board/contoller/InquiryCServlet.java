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
import edu.kh.moochelinGuide.board.model.vo.BoardImage;
import edu.kh.moochelinGuide.board.model.vo.Reply;
import edu.kh.moochelinGuide.member.model.vo.Member;

@WebServlet("/member/myPage/inquiryList/inquiryContent")
public class InquiryCServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/inquiryContent.jsp");
		
		BoardService service = new BoardService();
		Board board = new Board();
		int boardNo = Integer.parseInt(req.getParameter("list"));
		int boardCd = 0;
		board = service.boardContent(boardNo,boardCd);
		req.setAttribute("board", board);
		System.out.println(board.getImageList());
		
		ReplyService service2 = new ReplyService();
		Reply reply = new Reply();
		List<Reply> list = new ArrayList<Reply>();
		reply.setBoardNo(boardNo);
		list = service2.replyList(reply);
		req.setAttribute("replyList", list);
		
		
		
		dispatcher.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			Member member = (Member)session.getAttribute("loginMember");
			String comment = req.getParameter("comment");
			int boardNo = Integer.parseInt(req.getParameter("list"));
			int boardCd = 99;
			Reply reply = new Reply();
			reply.setBoardNo(boardNo);
			reply.setContent(comment);
			reply.setMemberNo(member.getMemberNo());
			
			ReplyService service = new ReplyService();
			ReplyService service2 = new ReplyService();
			
			int result = service.replyRegist(reply);
			if(result>0) result=service2.boardUpdate(reply,boardCd);
		
			resp.sendRedirect("inquiryContent?list="+boardNo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

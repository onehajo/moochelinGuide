package edu.kh.moochelinGuide.board.contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.moochelinGuide.board.model.service.BoardService;
import edu.kh.moochelinGuide.board.model.vo.Board;

@WebServlet("/member/myPage/notice")
public class NoticeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/notice.jsp");
			int boardCd = 97;
			BoardService service = new BoardService();
			List<Board> list = new ArrayList<Board>();
			Map<String, Object> map = service.listNotice(boardCd);
			
			req.setAttribute("noticeList", map.get("noticeList"));
			req.setAttribute("imageList", map.get("imageList"));
			System.out.println(map.get("noticeList"));
			System.out.println(map.get("imageList"));
			dispatcher.forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

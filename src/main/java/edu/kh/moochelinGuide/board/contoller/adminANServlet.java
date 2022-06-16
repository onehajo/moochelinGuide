package edu.kh.moochelinGuide.board.contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.moochelinGuide.board.model.service.BoardService;
import edu.kh.moochelinGuide.board.model.vo.Board;
import edu.kh.moochelinGuide.board.model.vo.BoardImage;
import edu.kh.moochelinGuide.common.MyRenamePolicy;
import edu.kh.moochelinGuide.member.model.vo.Member;

@WebServlet("/admin/notice/noticeRegist")
public class adminANServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/noticeAdd.jsp");
		String type = req.getParameter("type");
		BoardService service = new BoardService();
		Board list = new Board();
		if(type.equals("modify")) {
			int boardNo = Integer.parseInt(req.getParameter("no"));
			list = service.noticeContent(boardNo);
		}
		if(list.getContent()!=null) {
		list.setContent(list.getContent().replaceAll("<br>", "\n"));
		}
		req.setAttribute("modify", list);
		
		dispatcher.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			int maxSize = 1024 * 1024 * 20;
			String root = session.getServletContext().getRealPath("/");
			String folderPath = "/resources/images/board/";
			String filePath = root + folderPath;
			String encoding = "UTF-8";
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
			Member member = (Member)session.getAttribute("loginMember");
			BoardService service = new BoardService();
			
			String type = mpReq.getParameter("type");
			String content = mpReq.getParameter("content");
			String title = mpReq.getParameter("title");
			
			int imageSt = 0;
			if(!mpReq.getParameter("imageSt").equals("")) {
				imageSt = Integer.parseInt(mpReq.getParameter("imageSt"));
			}
			
			int boardNo = 0;
			if(!mpReq.getParameter("no").equals("")) {
				boardNo = Integer.parseInt(mpReq.getParameter("no"));
			}
			
			int boardCode = 97;
			Enumeration<String> files = mpReq.getFileNames();
			BoardImage image = new BoardImage();
			
			while(files.hasMoreElements()) {
				String name = files.nextElement();
				String rename = mpReq.getFilesystemName(name);
				String original = mpReq.getOriginalFileName(name);
				if(rename!=null) {
					image.setImageOriginal(original);
					image.setImageReName(folderPath+rename);
					image.setImageLevel(Integer.parseInt(name));
					image.setBoardNo(boardNo);
				}
			}
			image.setImageSt(imageSt);
			
			Board board = new Board();
			board.setBoardNo(boardNo);
			board.setContent(content);
			board.setBoardTit(title);
			board.setBoardCode(boardCode);
			board.setMemberNo(member.getMemberNo());
			System.out.println(board);
			System.out.println(image);
			if(type.equals("regist")) {
			int result = service.boardRegist(board,image);
			resp.getWriter().print(result);
			}
			
			if(type.equals("modify")) {
				int result = service.noticeUpdate(board,image);
			}
			resp.sendRedirect("../notice");
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}

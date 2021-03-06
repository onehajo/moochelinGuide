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

@WebServlet("/member/myPage/inquiryList/inquiryRegist")
public class InquiryRServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/inquiryRegist.jsp");
		dispatcher.forward(req, resp);
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
		
		String content = mpReq.getParameter("explain");
		
		String title = null;
		int boardCode = 99;
		if(content.length() <= 15) title = content;
		else {
			title = content.substring(0, 15) + "...";
		}
		
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
			}
		}
		
		
		Board board = new Board();
		board.setMemberNo(member.getMemberNo());
		board.setContent(content);
		board.setBoardTit(title);
		board.setBoardCode(boardCode);
		
		BoardService service = new BoardService();
		int result = service.boardRegist(board,image);
		
		resp.getWriter().print(result);
		
		resp.sendRedirect("../inquiryList?array=1");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package edu.kh.moochelinGuide.comment.controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.comment.service.CommentService;
import edu.kh.moochelinGuide.comment.vo.Comment;

@WebServlet("/comment/*")
public class CommentListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/comment/").length());
		CommentService service = new CommentService();
		try {
			
			if(command.equals("list")) {
				
			
            // 쿼리스트링 영화번호
//            int movieNo = Integer.parseInt(req.getParameter("movieNo"));
            int movieNo = 12;
          
            int cp = 1;
            
            if(req.getParameter("cp") != null) {
                
                cp = Integer.parseInt(req.getParameter("cp"));
                
            }
            
            
           
            
            // 게시판 종류, 페이지네이션, 게시글 리스트
            // ** 게시글 리스트
            // 1페이지에 좋아요 top3 세개 출력
            // 2페이지부터 최신순인데...  다섯개? 여섯개?씩 출력할까? 세개 출력하면 뭔가 구려보임...
            
            Map<String, Object> map = service.selectComentList(movieNo,cp);
            
            //request 범위로 map을 세팅
            req.setAttribute("map", map);
            
            System.out.println(map);
            
            
            
            String path = "/WEB-INF/views/comment/comment_detail.jsp";
            
            RequestDispatcher dispatcher = req.getRequestDispatcher(path);
            
            dispatcher.forward(req, resp);
			}
			
			// 코멘트 등록
			if(command.equals("insert")) {
				
				String commentWrite = req.getParameter("commentWrite");
				int memberNo =Integer.parseInt(req.getParameter("loginmemberNo"));
				
				int movieNo = Integer.parseInt(req.getParameter("movieNo"));
				
				Comment comment = new Comment();
				
				comment.setCommentContent(commentWrite);
				comment.setMovieNo(movieNo);
				comment.setMemberNo(memberNo);
				
				//댓글 등록 서비스 호출
				int result = service.insertComment(comment);
				
				// 서비스 호출 결과를 그대로 응답 데이터로 보냄
				resp.getWriter().print(result);
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp); // POST로 전달된 요청을 doGet()으로 전달하여 수행
	}
}

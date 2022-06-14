package edu.kh.moochelinGuide.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.moochelinGuide.comment.service.CommentService;
import edu.kh.moochelinGuide.comment.vo.Comment;
import edu.kh.moochelinGuide.common.Util;
import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.movie.model.vo.Movie;

@WebServlet("/admin/comment/*")
public class AdminCommentController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String uri = req.getRequestURI();
		    String contextPath = req.getContextPath();
		    String command = uri.substring(  (contextPath + "/admin/comment/").length()  );
		    
		    // 1. 메인페이지 (검색창만)
		    if(command.equals("search")) {
			    String path = "/WEB-INF/views/comment/admin_comment.jsp";
			    req.getRequestDispatcher(path).forward(req, resp);
		    }
		    
		    // 2. 검색결과 출력 (제목검색)
		    if(command.equals("search/title")) {
		    	
		    	String query = req.getParameter("query");
		    	
		    	// XSS 방지 + 개행문자 처리
				query = Util.XSSHandling(query);
				query = Util.newLineHandling(query);
				
				// 검색 결과를 조회하는 서비스를 호출하여 영화 리스트 반환
				List<Movie> movieList = new MemberService().searchTitle(query); 
				
				// 검색된 영화의 코멘트수 vo 추가
				
				// GSON 라이브러리 이용, JSON형태로 변환 후 응답
				new Gson().toJson(movieList,resp.getWriter());				
				
		    }
		    
		    if(command.equals("select/comment")) {
		    	
		    	int movieNo = Integer.parseInt(req.getParameter("movieNo"));
		    		    	
		    	// 코멘트 리스트 조회
		    	List<Comment> cList = new CommentService().commentForAdmin(movieNo);
		    	
				new Gson().toJson(cList,resp.getWriter());	
		    	
		    }
		    
		    if(command.equals(("update"))) {
		    	
		    	int commentNo = Integer.parseInt(req.getParameter("commentNo"));
		    	int mode = Integer.parseInt(req.getParameter("mode"));
		    		    	
		    	int result = new CommentService().deleteComment(commentNo, mode);
		    	
		    	resp.getWriter().print(result);
		    }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    
	}	

}

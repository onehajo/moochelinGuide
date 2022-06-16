package edu.kh.moochelinGuide.movie.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.comment.vo.Comment;
import edu.kh.moochelinGuide.member.model.vo.Member;
import edu.kh.moochelinGuide.movie.model.service.MovieService;
import edu.kh.moochelinGuide.movie.model.vo.MovieDetail;
import edu.kh.moochelinGuide.movie.model.vo.MovieLike;
import edu.kh.moochelinGuide.movie.model.vo.Rating;

@WebServlet("/movie/detail/*")
public class MovieDetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring( (contextPath + "/movie/detail/").length());
		MovieService service = new MovieService();
		try {
			if(command.equals("select")) {
				int movieNo = Integer.parseInt( req.getParameter("no"));
		
		
		
		                     
				Map<String, Object> map = service.selectMovieDetail(movieNo);
		
				System.out.println(map);
		
				req.setAttribute("map", map);
		
				System.out.println(map);
				
				String path = "/WEB-INF/views/movie/movieDetail.jsp";
           
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
           
				dispatcher.forward(req, resp);
			}
			
			if(command.equals("insert")) {
				
				String commentWrite = req.getParameter("commentWrite");
				int memberNo =Integer.parseInt(req.getParameter("loginMemberNo"));
				
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
			
			
			if(command.equals("rating")) {
				int inputst =Integer.parseInt(req.getParameter("inputst"));
				
				int memberNo =Integer.parseInt(req.getParameter("loginMemberNo"));
				
				int movieNo = Integer.parseInt(req.getParameter("movieNo"));

				Rating rating = new Rating();
				
				rating.setInputst(inputst);
				rating.setLoginMemberNo(memberNo);
				rating.setMovieNo(movieNo);
				
				int result = service.rating(rating);
				
				resp.getWriter().print(result);
				
			}
			
			
			
			
			if(command.equals("like")) {
				
				int memberNo =Integer.parseInt(req.getParameter("loginMemberNo"));
				
				int movieNo = Integer.parseInt(req.getParameter("movieNo"));

				MovieLike movieLike = new MovieLike();
				
				
				int result = service.movieLike(memberNo, movieNo);
				
				resp.getWriter().print(result);
				
			}
		
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
}

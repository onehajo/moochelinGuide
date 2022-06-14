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

import edu.kh.moochelinGuide.member.model.vo.Member;
import edu.kh.moochelinGuide.movie.model.service.MovieService;
import edu.kh.moochelinGuide.movie.model.vo.MovieDetail;

@WebServlet("/movie/detail")
public class MovieDetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
		int movieNo = Integer.parseInt( req.getParameter("no"));
		
		MovieService service = new MovieService();
		
		
		Map<String, Object> map = service.selectMovieDetail(movieNo);
		
		
		
		req.setAttribute("map", map);
		
		
		String path = "/WEB-INF/views/movie/movieDetail.jsp";
           
        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
           
        dispatcher.forward(req, resp);
			
		
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		try {
//			
//			int result = 0;
//			
//			// 평가한 점수 파라미터 얻어오기
//			int ratingPoint = Integer.parseInt(req.getParameter("ratingPoint"));
//			// 영화번호 파라미터 얻어오기
//			int movieNo = Integer.parseInt( req.getParameter("no"));
//			
//			
//			HttpSession session = req.getSession();
//			// 세션에서 로그인 정보 얻어옴
//			Member loginMember = (Member)session.getAttribute("loginMember");
//			// 회원 번호
//			int memberNo = loginMember.getMemberNo();
//			MovieService service = new MovieService();
//			
//			// 평가한 점수 insert JDBC
//			result = service.movieEvaluate(movieNo, ratingPoint, memberNo);
//			
//			String path = "/WBE-INF/views/movie/movieDetail.jsp";
//			
//			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}

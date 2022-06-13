package edu.kh.moochelinGuide.movie.controller;

import java.io.IOException;

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
		
		MovieDetail detail = service.selectMovieDetail(movieNo);
		
		// 평가한 회원수 조회 해서 평균값 계산
		
		// 평가한 점수 조회
		
		String path = "/WBE-INF/views/movie/movieDetail.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int result = 0;
			
			int ratingPoint = Integer.parseInt(req.getParameter("ratingPoint"));
			int movieNo = Integer.parseInt( req.getParameter("no"));
			
			HttpSession session = req.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			
			int memberNo = loginMember.getMemberNo();
			
			MovieService service = new MovieService();
			
			result = service.movieEvaluate(movieNo, ratingPoint, memberNo);
			
			String path = "/WBE-INF/views/movie/movieDetail.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

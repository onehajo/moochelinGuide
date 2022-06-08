package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Member;
import edu.kh.moochelinGuide.movie.model.vo.Movie;

@WebServlet("/member/evaluation")
public class EvaluationServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			// 1. jsp에 요청 위임	
			String path = "/WEB-INF/views/member/evaluation.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		
//			// 1. 회원번호 얻어오기 => 이 회원이 평가한 적 없는 영화 중에서 랜덤!!!
//			HttpSession session = req.getSession();
//			Member loginMember = (Member)session.getAttribute("loginMember");
//			int memberNo = loginMember.getMemberNo();
//			
//			System.out.println("멤버번호: "+memberNo);
//			
//			// 2. 영화 db에서 랜덤으로 리스트 조회 (3개) --> 어떻게 해야할까 !!!!!!!
//			List<Movie> movieList = new MemberService().selectRandomMovie(memberNo);
//			
//			for(Movie m : movieList) {
//				System.out.println("영화 : " + m);
//			}
//								
//			// 3. 세팅해서 req에 저장
//			req.setAttribute("movieList", movieList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		double score = Integer.parseInt(req.getParameter("score"))*0.5;
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		int movieNo = Integer.parseInt(req.getParameter("movieNo"));
		
		System.out.println("score : "+score);
		System.out.println("memberNo : " + memberNo);
		System.out.println("movieNo : "+ movieNo);
		
		//int result = new MemberService().evaluation(memberNo, movieNo, score);
		
		int result = 1;
		
		resp.getWriter().print(result); 

	}

}


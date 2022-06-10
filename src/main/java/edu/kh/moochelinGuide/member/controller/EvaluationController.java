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
public class EvaluationController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
		
			// 1. 회원번호 얻어오기 => 이 회원이 평가한 적 없는 영화 중에서 랜덤!!!
			HttpSession session = req.getSession();
			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();
			
			// 2. 회원이 평가한 영화 개수 조회
			int count = new MemberService().evaluationCount(memberNo);
			req.setAttribute("evaluationCount", count);
			
			// 3. 영화 db에서 랜덤으로 리스트 조회 (3개)
			List<Movie> movieList = new MemberService().selectRandomMovie(memberNo);
			
			Movie movie0 = null;
			Movie movie1 = null;
			Movie movie2 = null;
			for(int i = 0; i<movieList.size(); i++) {
				if(movieList.size()==3) {
					
					movie0 = movieList.get(0);
					movie1 = movieList.get(1);
					movie2 = movieList.get(2);
										
					req.setAttribute("movieList", movieList);
					req.setAttribute("movie0", movie0);
					req.setAttribute("movie1", movie1);
					req.setAttribute("movie2", movie2);
					
				}else if(movieList.size()==2) {
					
					movie0 = movieList.get(0);
					movie1 = movieList.get(1);
										
					req.setAttribute("movieList", movieList);
					req.setAttribute("movie0", movie0);
					req.setAttribute("movie1", movie1);
					
				}else {
					
					movie0 = movieList.get(0);
										
					req.setAttribute("movieList", movieList);
					req.setAttribute("movie0", movie0);
					
				}
			}	
			
			// 1. jsp에 요청 위임	
			String path = "/WEB-INF/views/member/evaluation.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int mode = Integer.parseInt(req.getParameter("mode"));
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			int movieNo = Integer.parseInt(req.getParameter("movieNo"));
			double score = Integer.parseInt(req.getParameter("score"))*0.5;
						
			int result = new MemberService().evaluation(mode, memberNo, movieNo, score);
			
			resp.getWriter().print(result); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}


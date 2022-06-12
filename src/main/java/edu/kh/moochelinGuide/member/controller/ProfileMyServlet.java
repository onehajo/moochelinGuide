package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/member/profile/my")
public class ProfileMyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		헤더에서 프로필클릭 시 요청받는 주소.
		String path = "/WEB-INF/views/member/profile_my.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
		
		// 로그인 세션 불러오기 
		
		HttpSession session = req.getSession();
		
		// 맵에다가 키밸류넣기
		// 1) 평가한 영화 정보
		// 2) 찜한 영화 정보
		// 3) 취향분석 
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

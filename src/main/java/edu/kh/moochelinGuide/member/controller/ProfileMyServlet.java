package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/profile/my")
public class ProfileMyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		헤더에서 프로필클릭 시 요청받는 주소.
		String path = "/WEB-INF/views/member/profile_my.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
		
		
		
		
		
		
		
	}
	
}

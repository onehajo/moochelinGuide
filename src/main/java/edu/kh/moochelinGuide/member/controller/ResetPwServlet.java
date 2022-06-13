package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/resetPw")
public class ResetPwServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberEmail = req.getParameter("memberEmail");
		
		// 확인용
		//System.out.println(memberEmail);
		
		try {
			
			req.setAttribute("memberEmail",memberEmail);
			
			//HttpSession session = req.getSession();
			//session.setAttribute(memberEmail,"memberEmail");
			
			String path = "/WEB-INF/views/member/reset_pw.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}

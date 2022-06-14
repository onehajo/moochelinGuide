package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;

@WebServlet("/resetPw/*")
public class ResetPwServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String memberEmail = req.getParameter("memberEmail");
			
			String uri = req.getRequestURI();	
			String contextPath = req.getContextPath();
			String command = uri.substring(  (contextPath + "/resetPw/").length()  );	
			
			// 이메일 정보 세팅해서, 비번 재설정 페이지로 이동
			if(command.equals("page")){
				
				req.setAttribute("memberEmail",memberEmail);
				
				String path = "/WEB-INF/views/member/reset_pw.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			}
			
			
			// 비번 재설정
			if(command.equals("do")) {
				String resetPw = req.getParameter("inputResetPw");
				
				// 값확인
				System.out.println(resetPw);
				System.out.println(memberEmail);
				
				MemberService service = new MemberService();
				int result = service.resetPw(memberEmail,resetPw);
				
				HttpSession session = req.getSession();
				String message;
				
				System.out.println(result);
				
				if(result>0) {
					
					message = "비밀번호가 재설정되었습니다.";
					
					session.setAttribute("message", message);
					
					resp.sendRedirect(req.getContextPath());

				} else {
				
					message = "비밀번호 재설정에 실패하였습니다.";
					
					session.setAttribute("message", message);
					
					String path=req.getHeader("referer");
					resp.sendRedirect(path);
					
				}
				
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}

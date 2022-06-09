package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Member;

@WebServlet(urlPatterns = {"/login","/search/login"})
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memberEmail = req.getParameter("memberEmail");
		String memberPw = req.getParameter("memberPw");
		
		Member mem = new Member();
		mem.setMemberEmail(memberEmail);
		mem.setMemberPw(memberPw);
		
		try {
			MemberService service = new MemberService();
			Member member = service.login(mem);
			
			HttpSession session = req.getSession();
			
			if(member!=null) {
				session.setAttribute("loginMember", member);
				session.setMaxInactiveInterval(3600);
			}else {
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			}
				
			String path = null;
			path=req.getHeader("referer");
			resp.sendRedirect(path);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

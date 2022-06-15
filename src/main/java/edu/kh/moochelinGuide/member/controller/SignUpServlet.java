package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Member;

@WebServlet(urlPatterns = {"/signUp", "/search/signUp","/movie/signUp","/movie/detail/signUp"})
public class SignUpServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberName = req.getParameter("memberName");
		String memberEmail = req.getParameter("memberEmail");
		String memberPw = req.getParameter("memberPw");
		
		Member mem = new Member();
		mem.setMemberName(memberName);
		mem.setMemberEmail(memberEmail);
		mem.setMemberPw(memberPw);

		try {
			MemberService service = new MemberService();
			int result = service.signUp(mem);
			
			HttpSession session = req.getSession();
			
			if(result>0) { // 성공
				session.setAttribute("message", "회원가입 성공!!");
				
				// 회원가입 성공 시 바로 로그인
				Member member = service.login(mem);
				session.setAttribute("loginMember", member);
				
			} else {
				session.setAttribute("message", "회원가입 실패...");
			}
			
			String path = null;
			path=req.getHeader("referer");
			resp.sendRedirect(path);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

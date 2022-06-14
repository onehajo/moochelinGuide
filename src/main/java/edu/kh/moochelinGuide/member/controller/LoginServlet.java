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
			System.out.println(member.getMemberType());
			
			// 멤버 타입이 일반회원인 경우
			if(member.getMemberType().equals("M")) {
				
				String path = null;
				path=req.getHeader("referer");
				resp.sendRedirect(path);

			}else { // 멤버타입 어드민인 경우
				
				String path="/WEB-INF/views/admin/adminIndex.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

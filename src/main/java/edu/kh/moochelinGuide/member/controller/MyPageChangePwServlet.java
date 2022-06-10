package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Member;


@WebServlet("/member/myPage/changePw")
public class MyPageChangePwServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//	파일 [/WEB-INF/views/member/myPage-changePw.jsp]을(를) 찾을 수 없습니다.
		String path = "/WEB-INF/views/member/myPage_changePw.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//  파라미터(현재 비밀번호, 새 비밀번호) 얻어오기
		String currentPw  = req.getParameter("currentPw");
		String newPw = req.getParameter("newPw");
		
		
		// 로그인 회원 번호
		HttpSession session = req.getSession();		
		
				
		// 로그인 정보 얻어오기			
		// 로그인 회원
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		
		// 회원번호
		int memberNo = loginMember.getMemberNo();
		
		// 확인
		System.out.println(currentPw);
		System.out.println(newPw);
		System.out.println(memberNo);
//		엔크립트 필터에 비밀번호 필터 주석처리 되어있으니 나중에 꼭
//		꼭꼭꼭 주석푸시
		
		try {
			// 주소 넣을거야~
			String path = null;
			
			MemberService service = new MemberService();
			
			int result = service.changePw(currentPw, newPw, memberNo);
			
			if(result > 0) {
				
				session.setAttribute("message", "비밀번호 변경 성공!");
				
				path = "mod"; //메인으로 보내고 싶은데 "req.getContextPath()"; 맞는지?
				
			} else {
				
				session.setAttribute("message", "비밀번호 변경 실패!");
				
				path = "changePw"; 
		}
			
		resp.sendRedirect(path);
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		
	}
	
	

}

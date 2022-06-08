package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.vo.Member;
import edu.kh.moochelinGuide.member.model.service.MemberService;

@WebServlet("/member/myPage/secession/*")
public class MyPageSecessionController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
	    String contextPath = req.getContextPath();
	    String command = uri.substring(  (contextPath + "/member/myPage/secession/").length()  );
	    
	    System.out.println("command = "+command);
	    
	    if(command.equals("do")) {
	    	
			String path = "/WEB-INF/views/member/myPage_secession.jsp";
		    req.getRequestDispatcher(path).forward(req, resp);
	    	
	    }
	    
	}
	    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
	    String contextPath = req.getContextPath();
	    String command = uri.substring(  (contextPath + "/member/myPage/secession/").length()  );
	    
	    System.out.println("command = "+command);
	    
	    
	    try {
	    	
	    	MemberService service = new MemberService();
	    	
	    	// 1) check - 탈퇴 전 비밀번호 일치여부 검사
	    	if(command.equals("check")) {
	    		
	    		// 회원번호
	    		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
	    		
	    		// 비밀번호
	    		String inputPw = req.getParameter("inputPw");
	    		
	    		int result = service.secessionCheckPw(memberNo, inputPw);	   
	    		
	    		resp.getWriter().print(result); 
	    		
	    		
	    	}
	    	
	    	// 2) confirm - 탈퇴 여부 재확인페이지로 요청
	    	if(command.equals("confirm")) {
	    		
	    		String path = "/WEB-INF/views/member/myPage_secessionConfirm.jsp";
	    		req.getRequestDispatcher(path).forward(req, resp);
	    		
	    	}
	    	
	    	// 3) do - 탈퇴 진행
	    	if(command.equals("do")) {
	    		
	    		// 세션에 저장된 loginMember 객체에서 회원번호 얻어오기
	    		HttpSession session = req.getSession();
	    		Member loginMember = (Member)(session.getAttribute("loginMember"));
	    		int memberNo = loginMember.getMemberNo();
	    		
	    		req.setAttribute("memberNo", memberNo);
	    		

	    		
	    		// 회원 탈퇴 서비스 호출하여 결과 반환
	    		int result = service.myPageSecession(memberNo);
	    		
	    		String path = null;
	    		if(result>0) {
	    			
	    			// 현재 세션 제거
		    		session.invalidate();
		    		
		    		// 새로운 새션 얻어와 message세팅
		    		session = req.getSession();
		    		session.setAttribute("message", "회원 탈퇴 완료");
		    		
		    		// redirect할 경로 설정
		    		path = req.getContextPath();
	    			
	    		}else {
	    			session.setAttribute("message", "회원 탈퇴 실패");
	    			path = req.getContextPath() + "/member/myPage/secession/do";
	    		}
	    		
	    		resp.sendRedirect(req.getContextPath());
	    		
	    	}
	    	
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	   
	}

}

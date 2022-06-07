package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/myPage/*")
public class MyPageController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
	    String contextPath = req.getContextPath();
	    String command = uri.substring(  (contextPath + "/member/myPage/").length()  );
	    
		String path = "/WEB-INF/views/member/myPage_"+command+".jsp";
	    req.getRequestDispatcher(path).forward(req, resp);
	    
	}
	    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
	    String contextPath = req.getContextPath();
	    String command = uri.substring(  (contextPath + "/member/myPage/").length()  );
		
	    try {
	    	
	    	// 마이페이지 - 탈퇴
	    	if(command.equals("secession")) {
	    		
	    		String memberPw = req.getParameter("memberPw");
	    		
	    		// 파리미터 확인
	    		System.out.println("memberPw="+memberPw);
	    		
	    		// ajax로 비밀번호 일치여부 확인한 뒤
	    		
	    		// 탈퇴처리
	    		
	    		// session에 저장된 로그인정보 지우기	    		
	    		
	    		// 탈퇴 완료 후 index.jsp로 이동
	    		resp.sendRedirect(req.getContextPath());
	    		
	    	}
	    	
			// 요청 위임할 경로 설정
			// String path = "/WEB-INF/views/member/myPage_"+command+".jsp";
		    // 지정한 경로로 요청 위임
		    // req.getRequestDispatcher(path).forward(req, resp);
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	   
	}

}

package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/myPage/message/*")
public class MyPageMessageController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String uri = req.getRequestURI();
		
		String contextPath = req.getContextPath();
		
		String command = uri.substring(  (contextPath + "/member/myPage/message/").length()  );
		
		
		
		try {
			
		    
		    if(command.equals("list")) {
		    	
		    	
		    	
		    	
				String path = "/WEB-INF/views/member/myPage_message.jsp";
			    req.getRequestDispatcher(path).forward(req, resp);
		    	
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = null;
		path=req.getHeader("referer");
		resp.sendRedirect(path);
	}
	


}

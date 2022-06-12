package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.*;

@WebServlet("/member/myPage/message/*")
public class MyPageMessageController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String uri = req.getRequestURI();	
		String contextPath = req.getContextPath();
		String command = uri.substring(  (contextPath + "/member/myPage/message/").length()  );
		
		
		
		try {
			
		    
		    if(command.equals("list")) {
		    	

		    	
		    	HttpSession session = req.getSession();
		    	Member loginMember = (Member)(session.getAttribute("loginMember"));
		    	
				int memberNo = loginMember.getMemberNo(); // 회원번호 얻어오기
				
				MemberService service = new MemberService(); 
				List<Message> messageList = service.selectMessage(memberNo);
				

				req.setAttribute("messageList", messageList);
				
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

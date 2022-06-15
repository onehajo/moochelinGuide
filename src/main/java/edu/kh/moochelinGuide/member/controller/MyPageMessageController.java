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

import com.google.gson.Gson;

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
			
			// 세션에서 로그인 회원의 회원번호 얻어오기
			HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember"));
			int memberNo = loginMember.getMemberNo();
		    
			

			// 쪽지 리스트화면
			if(command.equals("list")) {
				
				// 쪽지 리스트 요청-반환받기
				MemberService service = new MemberService(); 
				List<Message> messageList = service.selectMessage(memberNo);
		    	
				// 파라미터 중 게시글 번호 얻어오기
				// int messageNo = Integer.parseInt(req.getParameter("no"));
				// System.out.println(messageNo);
				
				
				req.setAttribute("messageList", messageList);
				
				String path = "/WEB-INF/views/member/myPage_message.jsp";
			    req.getRequestDispatcher(path).forward(req, resp);
		    }
			
			
		    
		    
			// 쪽지 상세보기 팝업
		    if(command.equals("detail")) {
		    	
		    	// 쿼리스트링으로 받아오기. 왜 형변환 한줄로 정리 하면 오류나지??
		    	String no = req.getParameter("no");
		    	int messageNo = Integer.parseInt(no);
		    	String type = req.getParameter("type");
		    	
		    	// 확인용
		    	//System.out.println("쿼리스트링으로 메세지 넘버 :" +messageNo);

		    		
				// service에 메세지 내용 요청, 반환
		    	MemberService service = new MemberService();
				Message messageDetail = service.messageDetail(messageNo);
			    	
			    // messageDetail 반환 잘 되었는지
				//System.out.println("내용가져왔니 : "+messageDetail);
					
				// 전달할 값 - 1개의 받은 메세지 내용과 시간
				req.setAttribute("messageDetail", messageDetail);
				req.setAttribute("type", type);
				
				String path = "/WEB-INF/views/member/myPage_messageForm.jsp";
				req.getRequestDispatcher(path).forward(req, resp);

		    }
		    
		    	    
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

	    	HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember"));
			int memberNo = loginMember.getMemberNo(); // 회원번호 얻어오기
			
			
			String uri = req.getRequestURI();	
			String contextPath = req.getContextPath();
			String command = uri.substring((contextPath + "/member/myPage/message/").length());	
		
			
			// 쪽지 삭제하기 and 삭제한 후의 리스트 반환
			if(command.equals("delete")) {
				int messageNo = Integer.parseInt(req.getParameter("messageNo"));
				
				MemberService service = new MemberService();
				List<Message> messageList = service.deletetMessage(messageNo,memberNo);
				System.out.println("삭제확인"+messageNo);
				System.out.println("삭제확인"+memberNo);
				// 전달할 값(삭제후 메세지 리스트)
				req.setAttribute("messageList", messageList);
				
				resp.sendRedirect("list");
			}
			
			
			// 쪽지 보내기 세션에서 보내는 회원 번호 memberNo, 쪽지 받을 tergetNo, 쪽지내용 input 필요.
			if(command.equals("insert")) {
				
				int targetNo = Integer.parseInt(req.getParameter("targetNo"));
				String content = req.getParameter("content");
				
				System.out.println(content);
				System.out.println(memberNo);
				System.out.println(targetNo);
				
				MemberService service = new MemberService();
				int result = service.insertMessage(memberNo,targetNo,content);
				
				
				if(result>0) {
					session.setAttribute("message", "쪽지를 보냈습니다.");
				}

				
				resp.sendRedirect("list");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
    	
	}
	


}

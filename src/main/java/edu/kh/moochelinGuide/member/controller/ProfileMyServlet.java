package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Member;


@WebServlet("/member/profile/my")
public class ProfileMyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 1. 회원 정보 조회 - 해당 회원넘버에 맞는 정보필요.
			// 2. 해당 회원의 정보 가져오기 ( 1),2),3) 을 게시글 목록 조회로 생각하기. )
			//    회원번호가 1인 회원의 
			//	  1)평가한 영화 정보
			// 	  2) 찜한 영화 정보
			//    3) 취향분석 
			
//			// 쿼리스트링 -> 왜 필요하는지 아직 모르겠슈,,
//			String id = req.getParameter("id");
//			System.out.println(id);
			
			
			// 로그인 세션 불러오기 
			HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember"));
			
			// 회원번호
			int memberNo = loginMember.getMemberNo();	
			
			// 회원번호 확인용 - 나중에 삭제할것 
			System.out.println(memberNo); 
			
			
			// 멤버서비스에서 처리 
			MemberService service = new MemberService();
			
			// map이 Vo가 필요없데, 왜? 모름.
			Map<String, Object> map = service.profileMy(memberNo);
			
		
			// 확인(주석)
			// 왜 평가한 영화가 안담겨져있지? -> 들고옴 
//			System.out.println(map.get("evalMovie"));
			
			// req에 map 세팅 
			req.setAttribute("map", map);
			
			
			
//   	    요청 주소.
			String path = "/WEB-INF/views/member/profile_my.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

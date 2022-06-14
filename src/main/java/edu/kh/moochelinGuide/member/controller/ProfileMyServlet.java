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
import edu.kh.moochelinGuide.member.model.vo.Follow;
import edu.kh.moochelinGuide.member.model.vo.Member;


@WebServlet("/member/profile/my")
public class ProfileMyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// 로그인 회원번호 들고오기
			HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember"));

			int memberNo = loginMember.getMemberNo();
			int targetNo = Integer.parseInt(req.getParameter("memberNo"));
			
			
			// 멤버서비스에서 처리 
			MemberService service = new MemberService();
			
			if (targetNo != memberNo) { // 다른 회원 정보 조회
				
				memberNo = targetNo;
				
			}
			
			
			// 나/타인 번호로 서비스프로필 마이 처리
			// map이 Vo가 필요없데, 왜? 모름.
			Map<String, Object> map = service.profileMy(memberNo);
			
			
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

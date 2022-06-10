package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.moochelinGuide.member.model.service.MemberService;



@WebServlet(urlPatterns = {"/emailDupCheck", "/search/emailDupCheck"})
public class EmailDupCheckServlet extends HttpServlet {

	// 이메일 중복검사(비동기 통신)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 비동기 통신으로 전달된 파라미터(data 속성의 key값) 얻어오기
		String memberEmail = req.getParameter("memberEmail");
		
		try {
			
			// 이메일 중복 검사(select count로 검사함. 중복이면1, 아니면0 반환)
			MemberService service = new MemberService();
			int result = service.emailDupCheck(memberEmail);
			resp.getWriter().print(result);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Member;

@WebServlet("/adminIndex")
public class AdminIndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			MemberService service = new MemberService();
			
			List<Member> indexinfo = service.selectAdminIndexInfo();
			req.setAttribute("indexinfo", indexinfo);
			
			String path="/WEB-INF/views/admin/adminIndex.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

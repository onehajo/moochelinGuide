package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Member;

@WebServlet("/search/*")
public class SearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
	    String contextPath = req.getContextPath();
	    String command = uri.substring(  (contextPath + "/search/").length()  );
	    
		// 파라미터에서 검색어 얻어와 request범위에 세팅
		String query = req.getParameter("query");
		req.setAttribute("query", query);
		
		try {
			
			MemberService service = new MemberService();
			
			// 제목 검색 결과
			if(command.equals("title")) {
			
			// 검색 결과를 조회하는 서비스를 호출하여 리스트 반환 (영화 vo 필요)
			// List<Movie> movieList = service.searchTitle(query); 
						
				
			}
			
	    
		    // 인물 검색 결과
		    if(command.equals("person")) {
		    			

		    	
		    	
		    }
	    
		    // 유저 검색 결과
		    if(command.equals("user")) {
		    	
		    	List<Member> userList = service.searchUser(query);
		    	
		    	req.setAttribute("userList", userList);
		    	
		    }
		    
			// 요청 위임할 경로 설정
			String path = "/WEB-INF/views/search/search_"+command+".jsp";
		    // 지정한 경로로 요청 위임
		    req.getRequestDispatcher(path).forward(req, resp);
	    
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

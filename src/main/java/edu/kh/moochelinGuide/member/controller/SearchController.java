package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.common.Util;
import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Follow;
import edu.kh.moochelinGuide.member.model.vo.Member;
import edu.kh.moochelinGuide.movie.model.vo.Movie;
import edu.kh.moochelinGuide.movie.model.vo.Person;

@WebServlet("/search/*")
public class SearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String uri = req.getRequestURI();
		    String contextPath = req.getContextPath();
		    String command = uri.substring(  (contextPath + "/search/").length()  );
		    
			// 파라미터에서 검색어 얻어와 request범위에 세팅
			String query = req.getParameter("query");
			
			// XSS 방지처리
			query = Util.XSSHandling(query);
			
			// 개행문자 처리
			query = Util.newLineHandling(query);
			
			req.setAttribute("query", query);
		
		
			
			MemberService service = new MemberService();
			
			// 제목 검색 결과
			if(command.equals("title")) {
			
				// 검색 결과를 조회하는 서비스를 호출하여 영화 리스트 반환
				List<Movie> movieList = service.searchTitle(query); 
				
				req.setAttribute("movieList", movieList);
								
				
			}
			
	    
		    // 인물 검색 결과
		    if(command.equals("person")) {
		    	
		    	// List<Person> personList = service.searchPerson(query);
		    	
		    	//req.setAttribute("personList", personList);
		    	
		    }
	    
		    // 유저 검색 결과
		    if(command.equals("user")) {
		    	
		    	HttpSession session = req.getSession();
		    	
		    	Member loginMember = (Member)session.getAttribute("loginMember");
		    	
		    	List<Member> userList = null;
		    	if(loginMember == null) {
		    		
		    		userList = service.searchUser1(query);
		    		
		    	}else {
		    		
		    		// 검색결과 + 팔로우여부 가져오기 (팔로우여부는 편의상 secessionFlag에 담음)
		    		int memberNo = loginMember.getMemberNo();
		    		int mode = Integer.parseInt(req.getParameter("mode"));
		    		userList = service.searchUser2(query, memberNo);

		    	}
		    	
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

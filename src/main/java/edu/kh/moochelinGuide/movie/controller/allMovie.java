package edu.kh.moochelinGuide.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.moochelinGuide.movie.model.service.MovieService;
import edu.kh.moochelinGuide.movie.model.vo.Movie;


@WebServlet("/movie/allMovie")
public class allMovie extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
//			파일 [/WEB-INF/views/member/myPage-changePw.jsp]을(를) 찾을 수 없습니다.
			
			// 파라미터 얻어오기 
			String category = req.getParameter("category");
			MovieService service = new MovieService();
			
			System.out.println(category);
			System.out.println(category);
			
			List<Movie> allShow = null;
			
			System.out.println(allShow);
			
			if ( category.equals("new")) {
				
				allShow = service.allShowNew();
				System.out.println(allShow);
				
			}
			if ( category.equals("ganada")) {
				
				allShow = service.allShowGanada();
				
			}
			if ( category.equals("popular")) {
				
				allShow = service.allShowPopular();
				
			}
			
			
			
			req.setAttribute("allShow", allShow);
			
			
			
//			new Gson().toJson(list,resp.getWriter());

			String path = "/WEB-INF/views/movie/allMovie.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

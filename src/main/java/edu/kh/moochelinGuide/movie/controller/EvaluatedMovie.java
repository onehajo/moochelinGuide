package edu.kh.moochelinGuide.movie.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.moochelinGuide.movie.model.service.MovieService;

@WebServlet("/member/profile/movie/evaluatedmovie")
public class EvaluatedMovie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int memberNo = Integer.parseInt( req.getParameter("no"));

			MovieService service = new MovieService();
			
			Map<String, Object> map = service.EvaluatedMovie(memberNo);
			
				
			req.setAttribute("map", map);
			
			
			String path = "/WEB-INF/views/movie/evaluatedMovie.jsp";
	           
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
       
			dispatcher.forward(req, resp);
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

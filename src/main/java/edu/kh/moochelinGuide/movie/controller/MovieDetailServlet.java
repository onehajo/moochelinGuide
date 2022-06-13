package edu.kh.moochelinGuide.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.moochelinGuide.movie.model.service.MovieService;
import edu.kh.moochelinGuide.movie.model.vo.MovieDetail;

@WebServlet("/detail")
public class MovieDetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
		int movieNo = Integer.parseInt( req.getParameter("no"));
		
		MovieService service = new MovieService();
		
		MovieDetail detail = service.selectMovieDetail(movieNo);
		
		String path = "/WBE-INF/views/movie/movieDetail.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
	}
	
}

package edu.kh.moochelinGuide.movie.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.moochelinGuide.movie.model.service.MovieService;
import edu.kh.moochelinGuide.movie.model.vo.Movie;

@WebServlet("/member/profile/movie/wish")
public class MovieWishList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int memberNo = Integer.parseInt( req.getParameter("no"));
			
			MovieService service = new MovieService();
			
			List<Movie> selectWishMovie = service.selectWishMovie(memberNo);
			
			req.setAttribute("selectWishMovie", selectWishMovie);
			
			
			String path = "/WEB-INF/views/movie/movie_wish_list.jsp";
	           
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
       
			dispatcher.forward(req, resp);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

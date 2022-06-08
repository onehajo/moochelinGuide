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


@WebServlet("/movie/nowShowing")
public class NowShowingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			MovieService service = new MovieService();
			List<Movie> list = service.nowShowing();
			
			new Gson().toJson(list,resp.getWriter());

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

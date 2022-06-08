package edu.kh.moochelinGuide.movie.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.moochelinGuide.movie.model.dao.MovieDAO;
import edu.kh.moochelinGuide.movie.model.vo.Movie;

public class MovieService {

	MovieDAO dao = new MovieDAO();

	/** 상영중인 영화 리스트
	 * @return list
	 * @throws Exception
	 */
	public List<Movie> nowShowing() throws Exception {
		Connection conn = getConnection();
		List<Movie> list = dao.nowShowing(conn);
		close(conn);
		return list;
	}
	
	
}

package edu.kh.moochelinGuide.movie.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.moochelinGuide.movie.model.dao.MovieDAO;
import edu.kh.moochelinGuide.movie.model.vo.Movie;
import edu.kh.moochelinGuide.movie.model.vo.MovieDetail;

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

	
	
	
	public List<Movie> allShow() throws Exception {
		Connection conn = getConnection();
		List<Movie> list = dao.allShow(conn);
		close(conn);
		return list;
	}




	/** 영화 상세 조회 Service
	 * @param movieNo
	 * @return detail
	 * @throws Exception
	 */
	public MovieDetail selectMovieDetail(int movieNo) throws Exception {
		
		Connection conn = getConnection();
		
		// 영화 정보 조회
		
		MovieDetail detail = dao.selectMovieDetail(conn, movieNo);
		
		close(conn);
		
		return detail;
	}




	public int movieEvaluate(int movieNo, int ratingPoint, int memberNo) throws Exception {
		
		
		
		Connection conn = getConnection();
		
		int result = dao.movieEvaluate(conn, movieNo, ratingPoint, memberNo);
		
		if(result > 0) {
			commit(conn);
		}else{
			rollback(conn);
		}
		close(conn);
		
		
		return result;
	}
	
	
}

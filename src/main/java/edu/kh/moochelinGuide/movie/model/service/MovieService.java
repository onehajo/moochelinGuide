package edu.kh.moochelinGuide.movie.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.moochelinGuide.comment.vo.Comment;
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



	/** 영화 상세 조회 Service
	 * @param movieNo
	 * @return map
	 * @throws Exception
	 */

	public Map<String, Object> selectMovieDetail(int movieNo) throws Exception{
		
		Connection conn = getConnection();
		
		// 영화 정보 조회
		
		MovieDetail detail = dao.selectMovieDetail(conn, movieNo);
		
		// 평가한 점수/평가한 회원수 조회 해서 평균값 계산
		float rating = dao.movieRating(conn,movieNo);
				
		// 코멘트 좋아요 순으로 3개 조회
		List<Comment> commentList = dao.selectCommentList(conn, movieNo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("detail", detail);
        map.put("rating", rating);
        map.put("commentList", commentList);
		
		close(conn);
		
		return null;
	}
	
	
}

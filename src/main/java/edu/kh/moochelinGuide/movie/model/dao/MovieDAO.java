package edu.kh.moochelinGuide.movie.model.dao;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.moochelinGuide.comment.vo.Comment;
import edu.kh.moochelinGuide.movie.model.vo.DetailComment;
import edu.kh.moochelinGuide.movie.model.vo.Movie;
import edu.kh.moochelinGuide.movie.model.vo.MovieDetail;
import edu.kh.moochelinGuide.movie.model.vo.Rating;



public class MovieDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public MovieDAO() {
		try {
			prop = new Properties();
			
			String filePath = MovieDAO.class.getResource("/edu/kh/moochelinGuide/sql/movie-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/** 상영중인 영화 리스트
	 * @param conn
	 * @return list
	 * @throws Exception
	 */
	public List<Movie> nowShowing(Connection conn) throws Exception {
		List<Movie> list = new ArrayList<Movie>();
		try {
			String sql = prop.getProperty("nowShowing");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Movie movie = new Movie();
				
				movie.setMovieNo(rs.getInt("MOVIE_NO"));
				movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
				movie.setPosterImage(rs.getString("POSTER_IMG"));
				movie.setReleaseYear(rs.getInt("RELEASE_YEAR"));
				movie.setCountry(rs.getString("COUNTRY"));
				movie.setTicketing(rs.getString("TICKETING"));
				movie.setAudience(rs.getString("AUDIENCE"));
				movie.setStarRating(rs.getFloat("STAR_RATING"));
				
				list.add(movie);
			}
			
		}finally {
		
			close(rs);
			close(stmt);
		}
		return list;
	}

	
	
	/** 모든 영화 조회 최신순 DAO
	 * @param conn
	 * @return allShow
	 * @throws Exception
	 */
	public List<Movie> allShowNew(Connection conn) throws Exception {
		List<Movie> allShow = new ArrayList<Movie>();
		try {
			String sql = prop.getProperty("allShow");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Movie movie = new Movie();
				
				movie.setMovieNo(rs.getInt("MOVIE_NO"));
				movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
				movie.setPosterImage(rs.getString("POSTER_IMG"));
				movie.setReleaseYear(rs.getInt("RELEASE_YEAR"));
				movie.setCountry(rs.getString("COUNTRY"));
				movie.setTicketing(rs.getString("TICKETING"));
				movie.setAudience(rs.getString("AUDIENCE"));
				movie.setStarRating(rs.getFloat("STAR_RATING"));
				
				allShow.add(movie);
			}
			
		}finally {
		
			close(rs);
			close(stmt);
		}
		return allShow;
	}

	/** 영화 정보 조회 DAO
	 * @param conn
	 * @param movieNo
	 * @return
	 * @throws Exception
	 */
	public MovieDetail selectMovieDetail(Connection conn, int movieNo) throws Exception{
		
		MovieDetail detail = null;
		
		try {
			String sql = prop.getProperty("selectMovieDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				detail = new MovieDetail();
				
				detail.setMovieNo(rs.getInt("MOVIE_NO"));
				detail.setMovieTitle(rs.getString("MOVIE_TITLE"));
				detail.setCountry(rs.getString("COUNTRY"));
				detail.setDetailImage(rs.getString("DETAIL_IMG"));
				detail.setPosterImage(rs.getString("POSTER_IMG"));
				detail.setReleaseYear(rs.getInt("RELEASE_YEAR"));
				detail.setSynopsis(rs.getString("SYNOPSIS"));
				detail.setStarRating(rs.getFloat("STAR_RATING"));
				
			
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return detail;
	}
	

	/** 영화 평가하기
	 * @param conn
	 * @param movieNo
	 * @param ratingPoint
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int movieEvaluate(Connection conn, int movieNo, int ratingPoint, int memberNo) throws Exception{
		
		try {
			
			int result = 0;
			
			String sql = prop.getProperty("movieEvaluate");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ratingPoint);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, movieNo);
			
			
			result = pstmt.executeUpdate();
			
			return result;
			
		}finally{
			close(pstmt);
		}
	}


/** 영화 정보 조회 DAO
 * @param conn
 * @param movieNo
 * @return commentList
 * @throws Exception
 */
public List<DetailComment> detailCommentList(Connection conn, int movieNo) throws Exception {
		
		List<DetailComment> commentList = new ArrayList<DetailComment>();
		
		try {
			String sql = prop.getProperty("detailCommentList");
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DetailComment comment = new DetailComment();
				
				comment.setCommentNo( rs.getInt("COMMENT_NO"));
				comment.setCommentContent(rs.getString("COMMENT_CT"));
				comment.setMemberNickname(rs.getString("MEMBER_NM"));
				comment.setCommentDate(rs.getString("COMMENT_DT"));
				comment.setProfileImage(rs.getString("PROFILE_IMG"));
				commentList.add(comment);
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return commentList;
	}



/** 코멘트 등록 DAO
 * @param conn
 * @param comment
 * @return result
 * @throws Exception
 */
public int insertComment(Connection conn, Comment comment) throws Exception{
	int result=0;
	
	try {
		String sql= prop.getProperty("insertComment");
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, comment.getCommentContent());
		pstmt.setInt(2, comment.getMovieNo());
		pstmt.setInt(3, comment.getMemberNo());
		
		result = pstmt.executeUpdate();
		
	}finally{
		close(pstmt);
	}
	
	
	return result;
}

public int rating(Connection conn, Rating rating) throws Exception{
	int result = 0;
	
	try {
		String sql= prop.getProperty("rating");
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, rating.getMovieNo());
		pstmt.setInt(2, rating.getMovieNo());
		pstmt.setInt(3, rating.getInputst());
		result = pstmt.executeUpdate();
		
	}finally{
		close(pstmt);
	}
	
	
	return result;
}

	
	

	/** 전체 영화 조회 가나다 순  DAO 
	 * @param conn
	 * @return allShow
	 * @throws Exception
	 */
	public List<Movie> allShowGanada(Connection conn) throws Exception{
		List<Movie> allShow = new ArrayList<Movie>();
		try {
			String sql = prop.getProperty("allShowGanada");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Movie movie = new Movie();
				
				movie.setMovieNo(rs.getInt("MOVIE_NO"));
				movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
				movie.setPosterImage(rs.getString("POSTER_IMG"));
				movie.setReleaseYear(rs.getInt("RELEASE_YEAR"));
				movie.setCountry(rs.getString("COUNTRY"));
				movie.setTicketing(rs.getString("TICKETING"));
				movie.setAudience(rs.getString("AUDIENCE"));
				movie.setStarRating(rs.getFloat("STAR_RATING"));
				
				allShow.add(movie);
			}
			
		}finally {
		
			close(rs);
			close(stmt);
		}
		return allShow;
	}

	
	
	
	/** 전체 영화 조회 인기 순 DAO
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Movie> allShowPopular(Connection conn) throws Exception {
		List<Movie> allShow = new ArrayList<Movie>();
		try {
			String sql = prop.getProperty("allShowPopular");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Movie movie = new Movie();
				
				movie.setMovieNo(rs.getInt("MOVIE_NO"));
				movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
				movie.setPosterImage(rs.getString("POSTER_IMG"));
				movie.setReleaseYear(rs.getInt("RELEASE_YEAR"));
				movie.setCountry(rs.getString("COUNTRY"));
				movie.setTicketing(rs.getString("TICKETING"));
				movie.setAudience(rs.getString("AUDIENCE"));
				movie.setStarRating(rs.getFloat("STAR_RATING"));
				
				allShow.add(movie);
			}
			
		}finally {
		
			close(rs);
			close(stmt);
		}
		return allShow;
	}

	
	
	/** 전체 영화 조회 인기 순 DAO
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Movie> allShowRelease(Connection conn) throws Exception {
		List<Movie> allShow = new ArrayList<Movie>();
		try {
			String sql = prop.getProperty("allShowRelease");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Movie movie = new Movie();
				
				movie.setMovieNo(rs.getInt("MOVIE_NO"));
				movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
				movie.setPosterImage(rs.getString("POSTER_IMG"));
				movie.setReleaseYear(rs.getInt("RELEASE_YEAR"));
				movie.setCountry(rs.getString("COUNTRY"));
				movie.setTicketing(rs.getString("TICKETING"));
				movie.setAudience(rs.getString("AUDIENCE"));
				movie.setStarRating(rs.getFloat("STAR_RATING"));
				
				allShow.add(movie);
			}
			
		}finally {
		
			close(rs);
			close(stmt);
		}
		return allShow;
	}

	/** 찜한 영화 조회
	 * @param conn
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public List<Movie> selectWishMovie(Connection conn, int memberNo) throws Exception{
		
		List<Movie> selectWishMovie= new ArrayList<Movie>();
		
		try {
			
			String sql = prop.getProperty("selectWishMovie");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			Movie movie = new Movie();
			
			movie.setMovieNo(rs.getInt("MOVIE_NO"));
			movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
			movie.setPosterImage(rs.getString("POSTER_IMG"));
			movie.setReleaseYear(rs.getInt("RELEASE_YEAR"));
			movie.setCountry(rs.getString("COUNTRY"));
			movie.setTicketing(rs.getString("TICKETING"));
			movie.setAudience(rs.getString("AUDIENCE"));
			
			selectWishMovie.add(movie);
			
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return selectWishMovie;
	}

	public int movieLike(Connection conn, int memberNo, int movieNo) throws Exception{
		int result = 0;
		
		try {
			String sql =prop.getProperty("movieLike");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	
}

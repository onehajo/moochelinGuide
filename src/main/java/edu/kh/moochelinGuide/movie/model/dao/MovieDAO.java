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
import edu.kh.moochelinGuide.movie.model.vo.Movie;
import edu.kh.moochelinGuide.movie.model.vo.MovieDetail;



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

	
	
	public List<Movie> allShow(Connection conn) throws Exception {
		List<Movie> list = new ArrayList<Movie>();
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
				
				list.add(movie);
			}
			
		}finally {
		
			close(rs);
			close(stmt);
		}
		return list;
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
				
				detail.setMovieTitle(rs.getString("MOVIE_TITLE"));
				detail.setCountry(rs.getString("COUNTRY"));
				detail.setDetailImage(rs.getString("DETAIL_IMG"));
				detail.setPosterImage(rs.getString("POSTER_IMG"));
				detail.setReleaseYear(rs.getInt("RELEASE_YEAR"));
				detail.setSynopsis(rs.getString("SYNOPSIS"));
				
			
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

	public float movieRating(Connection conn, int movieNo) throws Exception{
		
		try {
			
		float rating = 0;
		
		String sql = prop.getProperty("movieRating");
		
		pstmt.setInt(1, movieNo);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			rating = rs.getFloat(1);
        }
		
		return rating;
		
		}finally{
			close(rs);
			close(pstmt);
		}
		
		
	}

	public List<Comment> selectCommentList(Connection conn, int movieNo) throws Exception{
		
		List<Comment> commentList = new ArrayList<Comment>();
		
		try {
			
			String sql = prop.getProperty("selectComentList");
					
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment coment = new Comment();
				
				coment.setCommentNo( rs.getInt("COMMENT_NO"));
				coment.setCommentContent(rs.getString("COMMENT_CT"));
				coment.setMemberNickname(rs.getString("MEMBER_NM"));
				coment.setCommentDate(rs.getString("COMMENT_DT"));
				
				commentList.add(coment);
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return commentList;
	}

	
	
	
	
	
	
}

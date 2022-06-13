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
				
				detail.setMovieTitle(rs.getString("movieTitle"));
				detail.setCountry(rs.getString("country"));
				detail.setDetailImage(rs.getString("detailImg"));
				detail.setPosterImage(rs.getString("posterImg"));
				detail.setReleaseYear(rs.getInt("releaseYear"));
				detail.setSynopsis(rs.getString("synopsis"));
				
			
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return detail;
	}
	
	
	
	
	
	
}

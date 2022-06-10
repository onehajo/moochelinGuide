package edu.kh.moochelinGuide.coment.dao;
import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.jsp.jstl.sql.Result;

public class ComentDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ComentDAO() {
		try {
			prop = new Properties();
			
			String filePath = ComentDAO.class.getResource("/edu/kh/moochelinGuide/sql/coment-sql.xml").getPath();
			
			prop.loadFromXML( new FileInputStream(filePath) );
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/** 영화 이름 조회 DAO
	 * @param conn
	 * @param movieNo
	 * @return movieTitle
	 * @throws Exception
	 */
	public String selectMovieTitle(Connection conn, int movieNo) throws Exception {
		String movieTitle = null;
		
		try {
			String spl = prop.getProperty("selectMovieTitle");
			
			pstmt = conn.prepareStatement(spl);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				movieTitle = rs.getString(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return movieTitle;
	}



	/** 특정 영화 코멘트 수 조회
	 * @param conn
	 * @param movieNo
	 * @return
	 * @throws Exception
	 */
	public int getcomentCount(Connection conn, int movieNo) throws Exception{
		int comentCount = 0;
		
		try {
			String spl = prop.getProperty("comentCount");
			
			pstmt = conn.prepareStatement(spl);
			
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				comentCount = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return comentCount;
	}
}

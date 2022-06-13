package edu.kh.moochelinGuide.comment.dao;
import static edu.kh.moochelinGuide.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.moochelinGuide.comment.vo.Comment;
import edu.kh.moochelinGuide.comment.vo.Pagination;

public class CommentDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public CommentDAO() {
		try {
			prop = new Properties();
			
			String filePath = CommentDAO.class.getResource("/edu/kh/moochelinGuide/sql/coment-sql.xml").getPath();
			
			prop.loadFromXML( new FileInputStream(filePath) );
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
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
	/** 특정 영화에서 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @param movieNo
	 * @return
	 * @throws Exception
	 */
	public List<Comment> selectComentList(Connection conn, Pagination pagination, int movieNo) throws Exception {
		
		List<Comment> comentList = new ArrayList<Comment>();
		
		try {
			String sql = prop.getProperty("selectComentList");
			
			// BETWEEN 구문에 들어갈 범위 계산
			int start =  ( pagination.getCurrentPage() -1 ) * pagination.getLimit() + 1;
			int end = start + pagination.getLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment coment = new Comment();
				
				coment.setComentNo( rs.getInt("COMENT_NO"));
				coment.setComnetContent(rs.getString("COMNET_CT"));
				coment.setMemberNickname(rs.getString("MEMBER_NM"));
				coment.setComentST(rs.getString("COMENT_ST"));
				coment.setComentDate(rs.getString("COMENT_DATE"));
				
				comentList.add(coment);
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return comentList;
	}
}

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
			
			String filePath = CommentDAO.class.getResource("/edu/kh/moochelinGuide/sql/comment-sql.xml").getPath();
			
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
				
				coment.setCommentNo( rs.getInt("COMMENT_NO"));
				coment.setCommentContent(rs.getString("COMMENT_CT"));
				coment.setMemberNickname(rs.getString("MEMBER_NM"));
				coment.setCommentST(rs.getString("COMMENT_ST"));
				coment.setCommentDate(rs.getString("COMMENT_DT"));
				
				comentList.add(coment);
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return comentList;
	}
	
	
	
	/** 관리자 - 코멘트 목록 조회 DAO
	 * @param conn
	 * @param movieNo
	 * @return cList
	 * @throws Exception
	 */
	public List<Comment> commentForAdmin(Connection conn, int movieNo) throws Exception{
		List<Comment> cList = new ArrayList<Comment>();
		
		try {
			
			String sql = prop.getProperty("commentForAdmin");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment c = new Comment();
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setCommentDate(rs.getString(3));
				c.setCommentST(rs.getString(4));
				c.setMemberNo(rs.getInt(5));
				c.setMemberNickname(rs.getString(6));
				c.setProfileImage(rs.getString(7));
				
				cList.add(c);
			}
			
		}finally {
			close(pstmt);
		}
		
		return cList;
	}
	
	/** 관리자 - 코멘트 삭제, 복구 DAO
	 * @param conn
	 * @param commentNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteComment(Connection conn, int mode, int commentNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteComment");
			
			pstmt = conn.prepareStatement(sql);
			
			if(mode==1) {
				pstmt.setString(1, "Y");
			}
			
			if(mode==2) {
				pstmt.setString(1, "N");
			}
			
			pstmt.setInt(2, commentNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
}

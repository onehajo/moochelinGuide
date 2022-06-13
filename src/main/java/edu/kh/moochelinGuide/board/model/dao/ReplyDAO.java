package edu.kh.moochelinGuide.board.model.dao;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.moochelinGuide.board.model.vo.Reply;

public class ReplyDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public ReplyDAO() {
		try {
			prop = new Properties();
			String filePath = ReplyDAO.class.getResource("/edu/kh/moochelinGuide/sql/boardReply-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 답변 등록 DAO
	 * 
	 * @param conn
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int replyRegist(Connection conn, Reply reply) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("replyRegist");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,reply.getBoardNo());
			pstmt.setString(2, reply.getContent());
			pstmt.setInt(3, reply.getMemberNo());
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 문의 답변 조회 DAO
	 * 
	 * @param conn
	 * @param reply
	 * @return list
	 * @throws Exception
	 */
	public List<Reply> replyList(Connection conn, Reply reply) throws Exception {
		List<Reply> list = new ArrayList<Reply>();
		try {
			String sql = prop.getProperty("replyList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getBoardNo());
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Reply a = new Reply();
				a.setReplyNo(rs.getInt("REPLY_NO"));
				a.setContent(rs.getString("REPLY_CT"));
				a.setMemberNm(rs.getString("MEMBER_NM"));
				
				list.add(a);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	/** 관리자 답변 여부 확인 DAO
	 * 
	 * @param conn
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int memberList(Connection conn, Reply reply) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("repUpdate");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getBoardNo());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) result = rs.getInt(1);
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}


}

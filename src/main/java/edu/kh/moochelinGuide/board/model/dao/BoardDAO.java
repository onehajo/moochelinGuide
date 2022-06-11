package edu.kh.moochelinGuide.board.model.dao;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import edu.kh.moochelinGuide.board.model.vo.Board;

public class BoardDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public BoardDAO() {
		try {
			prop = new Properties();
			String filePath = BoardDAO.class.getResource("/edu/kh/moochelinGuide/sql/board-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 문의 등록 DAO
	 * 
	 * @param conn
	 * @param board
	 * @return result
	 * @throws Exception
	 */
	public int boardRegist(Connection conn, Board board) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("inquiryRegist");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTit());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public List<Board> boardList(Connection conn, int boardNo) throws Exception {
		List<Board> boardList = new ArrayList<Board>();
		try {
			String sql = prop.getProperty("boardList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board(); 
				board.setBoardTit(rs.getString("BOARD_TITLE"));
				board.setContent(rs.getString("BOARD_CT"));
				board.setDateCalcul(rs.getLong("CREATE_DT"));
				board.setUpdateDate(rs.getDate("UPDATE_DT"));
				board.setBoardSt(rs.getString("BOARD_ST"));
				board.setBoardCode(rs.getInt("BOARD_CD"));
				board.setMemberNm(rs.getString("MEMBER_NM"));
				long diffTime = board.getDateCalcul();
				board.setMsg(calcul(diffTime));
				board.setMsg2(calcul(diffTime));
				boardList.add(board);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}

	private String calcul(long diffTime) {
		String msg = null;
		if (diffTime < 60) {
			msg=("방금 전");
		} else if ((diffTime / 60) < 60) {
			diffTime = diffTime/60;
			msg=(diffTime + "분 전");
		} else if ((diffTime / 3600) < 24) {
			diffTime = diffTime/3600;
			msg=((diffTime) + "시간 전");
		} else if ((diffTime / (3600*24)) < 30) {
			diffTime = diffTime/(3600*24);
			msg=((diffTime) + "일 전");
		} else if ((diffTime / (3600*24*30)) < 12) {
			diffTime = diffTime/(3600*24*30);
			msg=((diffTime) + "달 전");
		} else {
			diffTime = diffTime/(3600*24*30*12);
			msg=((diffTime) + "년 전");
		}
		
		return msg;
	}

}

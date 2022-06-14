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
import edu.kh.moochelinGuide.board.model.vo.BoardImage;
import edu.kh.moochelinGuide.board.model.vo.Reply;

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

	public List<Board> boardList(Connection conn, int boardNo, String condition, String between) throws Exception {
		List<Board> boardList = new ArrayList<Board>();
		try {
			String sql = prop.getProperty("boardList")+condition+between;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTit(rs.getString("BOARD_TITLE"));
				board.setContent(rs.getString("BOARD_CT"));
				board.setDateCalcul(rs.getLong("CREATE_DT"));
				board.setDateCalcul2(rs.getLong("UPDATE_DT"));
				board.setBoardSt(rs.getString("BOARD_ST"));
				board.setBoardCode(rs.getInt("BOARD_CD"));
				board.setMemberNm(rs.getString("MEMBER_NM"));
				
				long diffTime = board.getDateCalcul();
				board.setMsg(calcul(diffTime));
				
				diffTime = board.getDateCalcul2();
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

	/** 문의 내역 조회 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board boardContent(Connection conn, int boardNo) throws Exception {
		Board board = new Board();
		try {
			String sql = prop.getProperty("boardContent");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setContent(rs.getString("BOARD_CT"));
				board.setMemberNm(rs.getString("MEMBER_NM"));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return board;
	}

	public int boardUpdate(Connection conn, Reply reply) throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("boardUpdate");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getBoardNo());
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 마지막 활동 시간 업데이트 DAO
	 * @param conn 
	 * 
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int boardUdate(Connection conn, Reply reply) throws Exception{
		int result = 0;
			try {
				String sql = prop.getProperty("boardUdate");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, reply.getBoardNo());
				
				result = pstmt.executeUpdate();
			}finally {
				close(pstmt);
			}
		return result;
	}

	/** 전체 게시글 수 조회 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int boardNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("getListCount");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 문의 내용 이미지 조회 DAO
	 * 
	 * @param conn
	 * @param boardNo
	 * @return imageList
	 * @throws Exception
	 */
	public List<BoardImage> selectImageList(Connection conn, int boardNo) throws Exception {
		
		List<BoardImage> imageList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("selectImageList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				BoardImage image = new BoardImage();
				image.setImageNo(rs.getInt(1));
				image.setImageReName(rs.getString(2));
				image.setImageOriginal(rs.getString(3));
				image.setImageLevel(rs.getInt(4));
				image.setBoardNo(rs.getInt(5));
				
				imageList.add(image);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return imageList;
	}

	

}

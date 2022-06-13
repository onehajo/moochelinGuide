package edu.kh.moochelinGuide.board.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.kh.moochelinGuide.board.model.dao.BoardDAO;
import edu.kh.moochelinGuide.board.model.vo.Board;
import edu.kh.moochelinGuide.board.model.vo.Reply;

public class BoardService {
	
	BoardDAO dao = new BoardDAO();

	/** 문의 등록 Service
	 * 
	 * @param board
	 * @return result
	 * @throws Exception
	 */
	public int boardRegist(Board board) throws Exception {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = dao.boardRegist(conn, board);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}

	/** 문의 사항 조회 Service
	 * 
	 * @param boardNo
	 * @param array 
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> boardList(int boardNo, int array) throws Exception {
		Connection conn = getConnection();
		
		List<Board> boardList = new ArrayList<Board>();
		
		String condition = null;
		
		switch(array) {
		case 1: condition = " ORDER BY UPDATE_DT ASC"; break;
		case 2: condition = " ORDER BY UPDATE_DT DESC"; break;
		case 3: condition = " ORDER BY CREATE_DT ASC"; break;
		case 4: condition = " ORDER BY CREATE_DT DESC"; break;
		}
		
		boardList = dao.boardList(conn,boardNo, condition);
		
		close(conn);
		return boardList;
	}
	
	/** 문의 내용 조회 Service
	 * 
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board boardContent(int boardNo) throws Exception {
		Connection conn = getConnection();
		Board board = new Board();
		
		board = dao.boardContent(conn,boardNo);
		
		close(conn);
		
		return board;
	}

}

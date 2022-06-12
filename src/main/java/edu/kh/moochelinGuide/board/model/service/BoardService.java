package edu.kh.moochelinGuide.board.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.kh.moochelinGuide.board.model.dao.BoardDAO;
import edu.kh.moochelinGuide.board.model.vo.Board;

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
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> boardList(int boardNo) throws Exception {
		Connection conn = getConnection();
		
		List<Board> boardList = new ArrayList<Board>();
		
		boardList = dao.boardList(conn,boardNo);
		
		close(conn);
		return boardList;
	}

}

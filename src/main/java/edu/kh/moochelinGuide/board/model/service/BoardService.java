package edu.kh.moochelinGuide.board.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.moochelinGuide.board.model.dao.BoardDAO;
import edu.kh.moochelinGuide.board.model.vo.Board;
import edu.kh.moochelinGuide.board.model.vo.BoardImage;
import edu.kh.moochelinGuide.board.model.vo.Pagination;
import edu.kh.moochelinGuide.board.model.vo.Reply;
import edu.kh.moochelinGuide.common.Util;

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
		board.setBoardTit(Util.XSSHandling(board.getBoardTit()));
		board.setBoardTit(Util.newLineHandling(board.getBoardTit()));
		board.setContent(Util.XSSHandling(board.getContent()));
		board.setContent(Util.newLineHandling(board.getContent()));
		
		result = dao.boardRegist(conn, board);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}

	/** 문의 사항 조회 Service
	 * 
	 * @param boardNo
	 * @param array 
	 * @param cp 
	 * @param memberCd 
	 * @return boardList
	 * @throws Exception
	 */
	public Map<String, Object> boardList(int boardNo, int array, int cp, int memberCd) throws Exception {
		Connection conn = getConnection();
		
		List<Board> boardList = new ArrayList<Board>();
		
		String condition = null;
		
		switch(array) {
		case 1: condition = " ORDER BY UPDATE_DT ASC) A) "; break;
		case 2: condition = " ORDER BY UPDATE_DT DESC) A) "; break;
		case 3: condition = " ORDER BY CREATE_DT ASC) A) "; break;
		case 4: condition = " ORDER BY CREATE_DT DESC) A) "; break;
		case 5: condition = " ORDER BY BOARD_CD DESC) A)"; break;
		case 6: condition = " ORDER BY BOARD_CD ASC) A)"; break;
		}
		
		int listCount = dao.getListCount(conn,boardNo,memberCd);
		
		Pagination pagination = new Pagination(cp,listCount);
		int start = (pagination.getCurrentPage()-1) * pagination.getLimit() + 1;
		int end = start + pagination.getLimit() - 1;
		String between = "WHERE RNUM BETWEEN "+start+" AND "+end;
		
		boardList = dao.boardList(conn,boardNo, condition, between,memberCd);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardList", boardList);
		map.put("pagination", pagination);
		
		close(conn);
		return map;
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
		
		if(board != null) {
			List<BoardImage> imagelist = dao.selectImageList(conn,boardNo);
			
			board.setImageList(imagelist);
		}
		
		close(conn);
		
		return board;
	}

}

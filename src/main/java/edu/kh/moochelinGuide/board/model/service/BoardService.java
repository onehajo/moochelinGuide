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
	 * @param image 
	 * @return result
	 * @throws Exception
	 */
	public int boardRegist(Board board, BoardImage image) throws Exception {
		int result = 0;
		int boardNo = 0;
		Connection conn = getConnection();
		board.setBoardTit(Util.XSSHandling(board.getBoardTit()));
		board.setBoardTit(Util.newLineHandling(board.getBoardTit()));
		board.setContent(Util.XSSHandling(board.getContent()));
		board.setContent(Util.newLineHandling(board.getContent()));
		
		result = dao.boardRegist(conn, board);
		
		if(result > 0&&(image.getImageReName()!=null)) {
				boardNo = dao.getBoardNo(conn);
				image.setBoardNo(boardNo);
				result = dao.insertBoardImage(conn,image);
		}
		
		if(result>0) commit(conn);
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
	 * @param boardCd 
	 * @return board
	 * @throws Exception
	 */
	public Board boardContent(int boardNo, int boardCd) throws Exception {
		Connection conn = getConnection();
		Board board = new Board();
		board = dao.boardContent(conn,boardNo);
		
		if(board != null) {
			List<BoardImage> imagelist = dao.selectImageList(conn,boardNo,boardCd);
			board.setImageList(imagelist);
		}
		
		close(conn);
		
		return board;
	}

	/** 공지 목록 조회 Service
	 * 
	 * @param boardCd
	 * @return list
	 * @throws Exception
	 */
	public Map<String, Object> listNotice(int boardCd) throws Exception {
		Connection conn = getConnection();
		
		List<Board> list = new ArrayList<Board>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		list = dao.listNotice(conn,boardCd);
	
		map.put("noticeList", list);
		
		close(conn);
		
		return map;
	}

	/** 공지 삭제 Service
	 * 
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int noticeDelete(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = 0;
		
		result = dao.noticeDelete(conn,boardNo);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return 0;
	}
	
	/** 공지사항 수정용 공지 리스트 Service
	 * 
	 * @param boardNo
	 * @return list
	 * @throws Exception
	 */
	public Board noticeContent(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		Board list = new Board();
		list = dao.noticeContent(conn,boardNo);
		
		close(conn);
		return list;
	}

	/** 공지사항 수정 Service
	 * 
	 * @param board
	 * @param image
	 * @return result
	 */
	public int noticeUpdate(Board board, BoardImage image) throws Exception {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = dao.noticeUpdate(conn, board);
		
		if(image.getImageSt()==1) {
			result = dao.deleteImage(conn,board);
		}
		
		if(image.getImageSt()==2) {
				image.setBoardNo(board.getBoardNo());
				result = dao.updateBoardImage(conn,image);
		}
		
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}

package edu.kh.moochelinGuide.board.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.kh.moochelinGuide.board.model.dao.BoardDAO;
import edu.kh.moochelinGuide.board.model.dao.ReplyDAO;
import edu.kh.moochelinGuide.board.model.vo.Reply;

public class ReplyService {
	ReplyDAO dao = new ReplyDAO();
	BoardDAO dao2= new BoardDAO();
	/** 댓글 등록 Service
	 * 
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int replyRegist(Reply reply) throws Exception {
		Connection conn = getConnection();
		
		int result = 0;
		
		result = dao.replyRegist(conn,reply);
		
		if(result>0) {
			commit(conn);
			result = dao2.boardUdate(conn,reply);
			if(result>0) commit(conn);
			else rollback(conn);
		}
		else rollback(conn);
		
		close(conn);
		return result;
	}

	/** 문의 답변 조회 Service
	 * 
	 * @param reply
	 * @return list
	 * @throws Exception
	 */
	public List<Reply> replyList(Reply reply) throws Exception {
		List<Reply> list = new ArrayList<Reply>();
		
		Connection conn = getConnection();
		
		list = dao.replyList(conn,reply);
		
		close(conn);
		
		return list;
	}

	/** 게시판 문의 상태 변경 Service
	 * 
	 * @param reply
	 * @return 
	 */
	public int boardUpdate(Reply reply) throws Exception {
		int result = 0;
		Connection conn = getConnection();
			try {
			
			result = dao.memberList(conn,reply);
			if(result>0) {
				result=dao2.boardUpdate(conn,reply);
				if(result>0) commit(conn);
				else rollback(conn);
			}
		}finally {
			close(conn);	
		}
		return result;
		
	}

}

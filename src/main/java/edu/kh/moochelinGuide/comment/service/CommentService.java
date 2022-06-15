package edu.kh.moochelinGuide.comment.service;
import static edu.kh.moochelinGuide.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.moochelinGuide.comment.dao.CommentDAO;
import edu.kh.moochelinGuide.comment.vo.Comment;
import edu.kh.moochelinGuide.comment.vo.Pagination;

public class CommentService {
	private CommentDAO dao = new CommentDAO();

    /** 코멘트 목록 조회 Service
     * @param movieNo
     * @param cp
     * @return amp
     * @throws Exception
     */
    public Map<String, Object> selectComentList(int movieNo, int cp) throws Exception{
        
        Connection conn = getConnection();
        Comment Coment = new Comment();
        // 영화 이름 조회 DAO
        String movieTitle = dao.selectMovieTitle(conn, movieNo);
        
        
        // 특정 영화 코멘트 수 조회 DAO
        int commentCount = dao.getcommentCount(conn, movieNo);
        // 코멘트 수 + 현재 페이지(CP)를 이용해서 페이지네이션 객체 생성
        Pagination pagination = new Pagination(cp, commentCount);
        
        // 게시글 목록 조회
        List<Comment> commentList = dao.selectCommentList(conn, pagination, movieNo);
        
        // Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장
        Map<String, Object> map = new HashMap<String, Object>();
        
        map.put("movieTitle", movieTitle);
        map.put("pagination", pagination);
        map.put("commentList", commentList);
        
        close(conn);
        
        
        return map; // Map 반환
    }

	/** 관리자 - 코멘트 목록 조회 Service
	 * @param movieNo
	 * @return
	 * @throws Exception
	 */
	public List<Comment> commentForAdmin(int movieNo) throws Exception{
		Connection conn = getConnection();
		
		List<Comment> cList = dao.commentForAdmin(conn, movieNo);
		
		close(conn);
		
		return cList;
	}

	/** 관리자 - 코멘트 삭제 / 복구 Service
	 * @param commentNo
	 * @param mode
	 * @return
	 * @throws Exception
	 */
	public int deleteComment(int commentNo, int mode) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.deleteComment(conn, mode, commentNo);
		
		if(result>0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int insertComment(Comment comment) throws Exception{
		Connection conn = getConnection();

		int result = dao.insertReply(conn,comment);

		if(result>0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		
		return result;
	}
    

}

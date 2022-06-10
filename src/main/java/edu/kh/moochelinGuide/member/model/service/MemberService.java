package edu.kh.moochelinGuide.member.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import edu.kh.moochelinGuide.common.Util;
import edu.kh.moochelinGuide.member.model.dao.MemberDAO;
import edu.kh.moochelinGuide.member.model.vo.Follow;
import edu.kh.moochelinGuide.member.model.vo.Member;
import edu.kh.moochelinGuide.movie.model.vo.Movie;

public class MemberService {

	MemberDAO dao = new MemberDAO();
	
	/** 이메일 중복검사
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(String memberEmail) throws Exception {
		
		Connection conn = getConnection();
		int result = dao.emailDupCheck(conn, memberEmail);
		close(conn);
		
		return result;
	}

	/** 회원가입
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member mem) throws Exception {
		Connection conn = getConnection();
		int result = dao.signUp(conn, mem);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 로그인
	 * @param mem
	 * @return member
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception{
		Connection conn = getConnection();
		Member member = dao.login(conn, mem);
		
		close(conn);
		
		return member;
	}

	
	/** 특정 키워드로 유저 검색 Service
	 * @param query
	 * @return userList
	 * @throws Exception
	 */
	public List<Member> searchUser(String query) throws Exception{
		
		Connection conn = getConnection();
		
		List<Member> userList = dao.searchUser(conn,query);
		
		close(conn);
		
		return userList;
	}

	/** 특정 키워드로 영화 검색 Service
	 * @param query
	 * @return movieList
	 * @throws Exception
	 */
	public List<Movie> searchTitle(String query) throws Exception{
		
		Connection conn = getConnection();
		
		List<Movie> movieList = dao.searchTitle(conn, query);
		
		close(conn);
		
		return movieList;
	}

	/** 회원 탈퇴 - 비밀번호 일치여부 확인 Service
	 * @param memberNo
	 * @param inputPw
	 * @return result
	 * @throws Exception
	 */
	public int secessionCheckPw(int memberNo, String inputPw) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.secessionCheckPw(conn, memberNo, inputPw);
		
		close(conn);
		
		return result;
	}

	/** 회원 탈퇴 Service
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int myPageSecession(int memberNo) throws Exception{
	
		Connection conn = getConnection();
		
		int result = dao.secession(conn, memberNo);
		
		if(result>0) commit(conn);
		else         rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 평가하기 - 랜덤 영화 조회 Service
	 * @param memberNo
	 * @return movieList
	 * @throws Exception
	 */
	public List<Movie> selectRandomMovie(int memberNo) throws Exception{

		Connection conn = getConnection();
		
		List<Movie> movieList = dao.selectRandomMovie(conn,memberNo);
		
		close(conn);
		
		return movieList;
		
	}

	/** 평가하기 Service
	 * @param memberNo
	 * @param movieNo
	 * @param score
	 * @return result
	 * @throws Exception
	 */
	public int evaluation(int mode, int memberNo, int movieNo, double score) throws Exception{
		
		Connection conn = getConnection();
		
		int result = 0;
		
		if(mode == 1) {
			// mode 1인경우 수정 혹은 삽입
			
			// 이미 평가된 영화인 경우 UPDATE
			result = dao.updateEvaluation(conn,memberNo, movieNo, score);
			
			if(result==0) { 
				
				// 평가한 적 없는 영화인 경우 INSERT
				result = dao.insertEvaluation(conn, memberNo, movieNo, score);
			}
			
		}else {
			
			// mode 2인경우 평가 취소 
			result = dao.deleteEvaluation(conn, memberNo, movieNo, score);
			
		}
		
		if(result>0) commit(conn);
		else 	     rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 평가한 영화 개수 조회 Service
	 * @param memberNo
	 * @return count
	 * @throws Exception
	 */
	public int evaluationCount(int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int count = dao.evaluationCount(conn, memberNo);
		
		close(conn);
		
		return count;
	}
	
	
	

	/** 회원정보 수정 Service 
	 * @param memberMod
	 * @param memberNo 
	 * @param bgDelete 
	 * @param imgDelete 
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member memberMod, int memberNo, int imgDelete, int bgDelete) throws Exception {
		
		Connection conn = getConnection();
		
		// 이름 수정 DAO
		int result  = dao.updateMember(conn, memberMod, memberNo);
		
		if(result > 0 ) {
			
			// 프로필 이미지 수정
			if(memberMod.getProfileImage() != null || imgDelete == 1) {
				result = dao.updatProfileImage(conn, memberMod, memberNo);
			}
			
			// 배경 이미지 수정
			if(memberMod.getProfileBackImage() != null || bgDelete == 1) {
				result = dao.updateBackgroundImage(conn, memberMod, memberNo);
			}
			
		}
		
		// 이름 수정안하고 이미지 바꿀때,
		if( result < 0) {
			
			
		}
		
		
		
		if(result>0) commit(conn);
		else         rollback(conn);
		
		close(conn);
		
		
		return result;
	}

<<<<<<< HEAD
	/** 로그인 회원의 팔로워 / 팔로잉 목록 조회 Service
	 * @param mode
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public List<Follow> follow(int mode, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		List<Follow> fList = null;
		
		if(mode==1) {
			
			// mode1 == 로그인 회원의 팔로워 목록 조회
			fList = dao.selectFollower(conn, memberNo);
			
		}else {
			
			// mode2 == 로그인 회원의 팔로잉 목록 조회
			fList = dao.selectFollowing(conn, memberNo);
			
		}
		
		close(conn);
		
		return fList;
=======
	
	
	/** 회원 비밀번호 변경 Service
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(String currentPw, String newPw, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.changePw(conn, currentPw, newPw, memberNo);
		
		if(result > 0 ) commit(conn);
		else rollback(conn);
		
		
		return result;
>>>>>>> c7a0c688a1e4a0aacecf450b1e78b44bcc8b01c8
	}
	
	
	
	
	
	

}

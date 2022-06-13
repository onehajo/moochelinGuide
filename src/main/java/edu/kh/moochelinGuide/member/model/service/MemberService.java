package edu.kh.moochelinGuide.member.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.moochelinGuide.common.Util;
import edu.kh.moochelinGuide.member.model.dao.MemberDAO;
import edu.kh.moochelinGuide.member.model.vo.Follow;
import edu.kh.moochelinGuide.member.model.vo.Member;
import edu.kh.moochelinGuide.member.model.vo.Message;
import edu.kh.moochelinGuide.movie.model.vo.Analysis;
import edu.kh.moochelinGuide.movie.model.vo.Movie;
import edu.kh.moochelinGuide.movie.model.vo.Person;

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

	
	/** 특정 키워드로 유저 검색 Service (로그인 X)
	 * @param query
	 * @return userList
	 * @throws Exception
	 */
	public List<Member> searchUser1(String query) throws Exception{
		
		Connection conn = getConnection();
			
		List<Member> userList = dao.searchUser1(conn,query);
		
		close(conn);
		
		return userList;
	}
	
	/** 특정 키워드로 유저 검색 Service (로그인 O)
	 * @param query
	 * @return userList
	 * @throws Exception
	 */
	public List<Member> searchUser2(String query, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Member> userList = dao.searchUser2(conn,query, memberNo);
		
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
		
		
		if(result>0) commit(conn);
		else         rollback(conn);
		
		close(conn);
		
		
		return result;
	}

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
	}
	
	
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
	}
	
	
	

	/** 메세지 목록 조회 service
	 * @param memberNo
	 * @return messageList
	 * @throws Exception
	 */
	public List<Message> selectMessage(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		List<Message> messageList = dao.selectMessage(conn, memberNo);
		
		return messageList;
	}

	
	/** 팔로워,팔로잉 삭제/삭제 취소/ 등록 Service
	 * @param mode
	 * @param memberNo
	 * @param targetNo
	 * @return result
	 * @throws Exception
	 */
	public int followService(int mode, int memberNo, int targetNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = 0;
		
		// 팔로잉 수정(삭제 취소)
		if(mode==1) {
			result = dao.updateFollow(conn, memberNo, targetNo);
			
			// 팔로우 (수정할 내역이 없으면 insert)
			if(result == 0) {
				result = dao.insertFollow(conn, memberNo, targetNo);
			}
		}
		
		// 팔로워,팔로잉 삭제
		if(mode==2) {
			result = dao.deleteFollow(conn, memberNo, targetNo);
		}
				
		if(result>0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		
		return result;
		
	}

	
	/** 마이프로필 Service
	 * @param memberNo
	 * @return map 
	 * @throws Exception
	 */
	public Map<String, Object> profileMy(int memberNo) throws Exception{
		
		
		Connection conn = getConnection();
		
		// 1)평가한 영화 정보 조회 .. 를 가지고 영화(이름, 이미지, 년도, 국가 ) ( 평균별점 걍 빼자  )
		List<Movie> evalMovie = dao.selectEvalMovie(conn, memberNo);
		
//		System.out.println(evalMovie);
		

		// 2) 찜한 영화 정보(정보가 없슈)


		// 3) 취향분석 (없슈)
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 1) 평가한 영화 정보 조회 (4개) 담겨져 있어야함.
		map.put("evalMovie", evalMovie);
		// 2) 찜한 영화 정보(담을 예정)
		// 3) 취향분석 (담을 예정)
		
		close(conn);
		
		return map;
	}

	
	/** 취향분석 Service
	 * @param memberNo
	 * @return
	 */
	public Map<String, Object> analysis(int memberNo) throws Exception {
		

		Connection conn = getConnection();
		
		// 1) 내가 평가한 영화의 모든 갯수 ( 프로필 오른쪽에 사용할 것임 )
		int analyMovieCount = dao.analyMovieCount(conn, memberNo);
		
		// 2) 평가한 점수의 각각의 갯수 ( 0.5점은 3개, 1점은 2개 .. )
		List<Analysis> analyAll = dao.analyAllScore(conn, memberNo);
		
		// 3) 내가 평가한 모든 영화의 가장 많은 country 는?
		String analyMovieCountry = dao.analyMovieCountry(conn, memberNo);
		
		
		// 4) 내가 평가한 모든 영화의 모든 RUNNING_TIME
		//    -> 컬럼에 1시42분 되어있어서 substirng을 써야하는지 감이 안잡힘.
		
		
		
		Map<String, Object>
		map = new HashMap<String, Object>();
		map.put("analyMovieCount", analyMovieCount);
		map.put("analyAll", analyAll);
		map.put("analyMovieCountry", analyMovieCountry);
		
		System.out.println(analyMovieCount);
		System.out.println(analyAll);
		System.out.println(analyMovieCountry);

		close(conn);
		
		return map;
		
	}
	
	
	/** 특정 키워드로 인물 검색 Service
	 * @param query
	 * @return personList
	 * @throws Exception
	 */
	public List<Person> searchPerson(String query) throws Exception{
		
		Connection conn = getConnection();
		
		List<Person> personList = dao.searchPerson(conn, query);
		
		close(conn);
		
		return personList;
	}
	
	
	
	
	
	

}

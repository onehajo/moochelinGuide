package edu.kh.moochelinGuide.member.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

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
	 * @param targetNo 
	 * @return map 
	 * @throws Exception
	 */
	public Map<String, Object> profileMy(int memberNo, int targetNo) throws Exception{
		
		
		Connection conn = getConnection();
		
		// 1)평가한 영화 정보 조회 .. 를 가지고 영화(이름, 이미지, 년도, 국가 ) ( 평균별점 걍 빼자  )
		List<Movie> evalMovie = dao.selectEvalMovie(conn, memberNo);
		
		// 1-1) 내가 평가한 영화의 모든 갯수 ( 프로필 오른쪽에 사용할 것임 )
		int analyMovieCount = dao.analyMovieCount(conn, memberNo);

		
		// 2) 평가한 점수의 각각의 갯수 ( 0.5점은 3개, 1점은 2개 .. )
		List<Analysis> analyAll = dao.analyAllScore(conn, memberNo);
		
		
		// 5) 내가 평가한 전체 영화 평점 ㅡㅡ... dao왤케많아 
		int allMovieAvg = dao.allMovieAvg(conn,memberNo);
		
		
		// 6) memberNo 가 내가아닌 타인일때,
		//    회원이름 / 회원번호 / 프로필이미지 / 배경이미지 
		Member member = dao.selectMemberUser(conn, memberNo);
		
		// 6-1)페이지 멤버의 팔로워
		int followerCount = dao.followerCount(conn, memberNo);
		
		// 6-2) 페이지 멤버의 팔로잉
		int followingCount = dao.followingCount(conn, targetNo );
		 
		int followingYN = 0;
		// 6-3) 멤버의 팔로우 y/n
		if(memberNo != targetNo) {
			 followingYN = dao.followingYN(conn, targetNo, memberNo );
			 
		}
		
		System.out.println(followingYN);
		System.out.println(targetNo);
		System.out.println(memberNo); // memberNo이거 상태가 파라미터의 값이다.
		
		
		// 7) 찜한  영화 리스트 조회
		List<Movie> movieList = dao.likeMovie(conn, memberNo);
		int likeCount = 0;
		
		if (movieList.size()!=0) {
			 likeCount = movieList.get(0).getCommentCount();
		}

		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1) 평가한 영화 정보 조회 (4개) 담겨져 있어야함.
		
		map.put("evalMovie", evalMovie);
		// 2) 찜한 영화 정보(담을 예정)
		// 3) 취향분석 (담을 예정)
		map.put("analyAll", new Gson().toJson(analyAll) );
		map.put("allMovieAvg", allMovieAvg);
		map.put("member", member);
		map.put("followerCount", followerCount);
		map.put("followingCount", followingCount);
		map.put("analyMovieCount", analyMovieCount);
		map.put("movieList", movieList);
		map.put("likeCount", likeCount);
		map.put("followingYN", followingYN);
		
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
		int analyMovieCount = dao.analyMovieCount(conn, memberNo); //
		
		
		
		// 2) 평가한 점수의 각각의 갯수 ( 0.5점은 3개, 1점은 2개 .. )
		List<Analysis> analyAll = dao.analyAllScore(conn, memberNo); //
		
		// 3) 내가 평가한 모든 영화의 가장 많은 country 는?
		String analyMovieCountry = dao.analyMovieCountry(conn, memberNo);
		
		// 3-1) 내가 가장 선호한 나라의 평가한 영화 갯수. ( 3)의 country 영화의 갯수 )
		int likeCountryCount = dao.likeCountryCount(conn, memberNo); //
		
		
		// 3-2) 내가 가장 선호한 나라의 영화, 평점 평균
		int likeCountryAvg = dao.likeCountryAvg(conn, memberNo); //
		
		
		
		// 4) 내가 평가한 모든 영화의 모든 RUNNING_TIME
		//    -> 컬럼에 1시42분 되어있어서 substirng을 써야하는지 감이 안잡힘.
		String myAllRunningTime = dao.myAllRunningTime(conn, memberNo); //
		
		
		// 5) 내가 평가한 전체 영화 평점 ㅡㅡ... dao왤케많아 
		int allMovieAvg = dao.allMovieAvg(conn,memberNo); //
	
		
		// 6) memberNo 가 내가아닌 타인일때,
		//    회원이름 / 회원번호 / 프로필이미지 / 배경이미지 
		Member member = dao.selectMemberUser(conn, memberNo); //
		
		Map<String, Object>
		map = new HashMap<String, Object>();
		map.put("analyMovieCount", analyMovieCount);
		map.put("analyAll", new Gson().toJson(analyAll) );
		map.put("analyMovieCountry", analyMovieCountry);
		map.put("myAllRunningTime", myAllRunningTime);
		map.put("likeCountryCount", likeCountryCount);
		map.put("likeCountryAvg", likeCountryAvg);
		map.put("allMovieAvg", allMovieAvg);
		map.put("member", member);
		
		//값 잘 불러와졌나확인용 - 나중에 주석처리 꼭!!!꼭하기
		System.out.println(analyMovieCount);
		System.out.println(analyAll);
		System.out.println(analyMovieCountry);
		System.out.println(myAllRunningTime);
 
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
		
		// 1. personList 담아오기
		List<Person> personList = dao.searchPerson(conn, query);
		
		if(personList.size()!=0) {
			// 2. personList에 담긴 각 인물의 영화정보 movieList에 담아오기
			List<Movie> movieList = new ArrayList<Movie>();
			
			for(int i =0; i<personList.size(); i++) {
				Person p = personList.get(i);
				movieList = dao.selectPersonMovieList(conn, query, p);
				p.setMovieList(movieList);
			}
			
		}
		
		close(conn);
		
		return personList;
	}

	
	 
	
	
	
	
	
	
	
	
	
	
	
	/** 각 메시지 번호로 메세지 내용 조회
	 * @param messageNo
	 * @return messageDetail
	 * @throws Exception
	 */
	public Message messageDetail(int messageNo) throws Exception {
		
		Connection conn = getConnection();
		
		Message messageDetail = dao.messageDetail(conn, messageNo);
		
		close(conn);
		
		return messageDetail;
		
	}

	/** 쪽지 보내기
	 * @param content 
	 * @param targetNo 
	 * @param messageNo
	 * @return result
	 * @throws Exception
	 */
	public int insertMessage(int memberNo, int targetNo, String content) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.insertMessage(conn, memberNo, targetNo, content );
		
		if(result>0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	/** 쪽지 삭제하기
	 * @param messageNo
	 * @param memberNo 
	 * @return messageList
	 * @throws Exception
	 */
	public List<Message> deletetMessage(int messageNo, int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deletetMessage(conn, messageNo);
		
		List<Message> messageList =null;
		if(result>0) {
			messageList = dao.selectMessage(conn, memberNo);			
		}
		
		if(result>0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		
		return messageList;
	}


	
	
	
	
	
	/** 비밀번호 재설정
	 * @param memberEmail
	 * @param resetPw 
	 * @return result
	 * @throws Exception
	 */
	public int resetPw(String memberEmail, String resetPw) throws Exception {
		Connection conn = getConnection();
		
		int result = dao.resetPw(conn, memberEmail, resetPw);
		
		if(result>0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
	
	
	/** 관리자 인덱스 정보
	 * @return map
	 * @throws Exception
	 */
	public List<Member> selectAdminIndexInfo() throws Exception {

		Connection conn = getConnection();
		
		// 영화정보 (전체 영화 수)
		List<Member> indexinfo = dao.selectAdminIndexInfo(conn);
		// 코멘트 정보 (전체 코멘트 갯수)
		
		// 현재 회원 수
		
		// 어제 가입한 회원 수
		
		// 어제 문의글 수 
		
		// 미처리 문의 글 수
		
		
		
		return indexinfo;
	}

	
	/** 총 평가 개수 계산 Service
	 * @return result
	 * @throws Exception
	 */
	public int evalTotal() throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.evalTotal(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	

}

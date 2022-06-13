package edu.kh.moochelinGuide.member.model.dao;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import edu.kh.moochelinGuide.member.model.vo.Follow;
import edu.kh.moochelinGuide.member.model.vo.Member;
import edu.kh.moochelinGuide.member.model.vo.Message;
import edu.kh.moochelinGuide.movie.model.vo.Analysis;
import edu.kh.moochelinGuide.movie.model.vo.Movie;
import edu.kh.moochelinGuide.movie.model.vo.Person;

public class MemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;

	public MemberDAO() {
		try {
			prop = new Properties();
			
			String filePath = MemberDAO.class.getResource("/edu/kh/moochelinGuide/sql/member-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 이메일 중복확인
	 * @param conn
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(Connection conn, String memberEmail) throws Exception {
		int result=0;
		try {
			String sql = prop.getProperty("emailDupCheck");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberEmail);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	/** 회원가입
	 * @param conn
	 * @param mem
	 * @return
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member mem) throws Exception {
		int result=0;
		try {
			String sql = prop.getProperty("signUp");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			pstmt.setString(3, mem.getMemberName());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}

	/** 로그인
	 * @param conn
	 * @param mem
	 * @return member
	 * @throws Exception
	 */
	public Member login(Connection conn, Member mem) throws Exception {
		Member member = null;
		try {
			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				
				member.setMemberNo(rs.getInt("MEMBER_NO"));
				member.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				member.setMemberName(rs.getString("MEMBER_NM"));
				member.setProfileImage(rs.getString(4));
				member.setProfileBackImage(rs.getString(5));
				member.setEnrollDate(rs.getString(6));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	/** 특정 키워드로 유저 검색 DAO (로그인 X)
	 * @param conn
	 * @param query
	 * @return userList
	 * @throws Exception
	 */
	public List<Member> searchUser1(Connection conn, String query) throws Exception{
		List<Member> userList = new ArrayList<Member>();
		
		try {
			String sql = prop.getProperty("searchUser1");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+query+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Member mem = new Member();
				
				mem.setMemberNo(rs.getInt(1));
				mem.setMemberName(rs.getString(2));
				mem.setProfileImage(rs.getString(3));
				
				userList.add(mem);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return userList;
	}
	
	/** 특정 키워드로 유저 검색 DAO (로그인 O)
	 * @param conn
	 * @param query
	 * @return userList
	 * @throws Exception
	 */
	public List<Member> searchUser2(Connection conn, String query, int memberNo) throws Exception{
		List<Member> userList = new ArrayList<Member>();
		
		try {
			String sql = prop.getProperty("searchUser2");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, "%"+query+"%");
			pstmt.setInt(3, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Member mem = new Member();
				
				mem.setMemberNo(rs.getInt(1));
				mem.setMemberName(rs.getString(2));
				mem.setProfileImage(rs.getString(3));
				// 팔로우 여부
				mem.setSecessionFlag(rs.getString("FOLLOW_FL"));
				
				userList.add(mem);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return userList;
	}

	/** 특정 키워드로 영화 검색 DAO
	 * @param conn
	 * @param query
	 * @return movieList
	 * @throws Exception
	 */
	public List<Movie> searchTitle(Connection conn, String query) throws Exception{
		List<Movie> movieList = new ArrayList<Movie>();
		
		try {
			
			String sql = prop.getProperty("searchTitle");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+query+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Movie m = new Movie();
				
				m.setMovieNo(rs.getInt(1));
				m.setMovieTitle(rs.getString(2));
				m.setPosterImage(rs.getString(3));
				m.setReleaseYear(rs.getInt(4));
				m.setCountry(rs.getString(5));
				
				movieList.add(m);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return movieList;
	}

	/** 회원 탈퇴 - 비밀번호 일치여부 확인 DAO
	 * @param conn
	 * @param memberNo
	 * @param inputPw
	 * @return result
	 * @throws Exception
	 */
	public int secessionCheckPw(Connection conn, int memberNo, String inputPw) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("secessionCheckPw");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}

	/** 회원 탈퇴 DAO
	 * @param conn
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int secession(Connection conn, int memberNo) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("secession");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
					
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	

	/** 회원정보 이름 수정 DAO 
	 * @param conn
	 * @param memberMod
	 * @param memberNo 
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Connection conn, Member memberMod, int memberNo) throws Exception {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberMod.getMemberName());
			pstmt.setInt(2, memberNo);
			
	
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}
	

	/** 회원 비밀번호 변경 DAO
	 * @param conn
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(Connection conn, String currentPw, String newPw, int memberNo) throws Exception {
 		int result = 0;
		
		try {
			String sql = prop.getProperty("changePw");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setInt(2, memberNo);
			pstmt.setString(3, currentPw);
  
      result = pstmt.executeUpdate();
      
 		} finally {
			
			close(pstmt);
			
		}
		
		
		return result;
	}

	
	
	
	/** 회원정보 프로필 이미지 수정 DAO
	 * @param conn
	 * @param memberMod
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public int updatProfileImage(Connection conn, Member memberMod, int memberNo) throws Exception {
 		int result = 0;
		
		try {   
			String sql = prop.getProperty("updatProfileImage");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberMod.getProfileImage());
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			
			close(pstmt);
			
		}
		
		
		return result;
	}
	
	/** 회원정보 배경 이미지 수정 DAO 
	 * @param conn
	 * @param memberMod
	 * @param memberNo
	 * @return result 
	 * @throws Exception
	 */
	public int updateBackgroundImage(Connection conn, Member memberMod, int memberNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateBackgroundImage");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberMod.getProfileBackImage());
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			close(pstmt);
			
		}
		
		return result;
	}
	    
 
	/** 평가하기 - 랜덤 영화 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return movieList
	 * @throws Exception
	 */
	public List<Movie> selectRandomMovie(Connection conn, int memberNo) throws Exception {
		List<Movie> movieList = new ArrayList<Movie>();
		
		try {
			String sql = prop.getProperty("selectRandomMovie");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Movie m = new Movie();
				
				m.setMovieNo(rs.getInt(1));
				m.setMovieTitle(rs.getString(2));
				m.setPosterImage(rs.getString(3));
				m.setReleaseYear(rs.getInt(4));
				m.setCountry(rs.getString(5));
						
				movieList.add(m);
			}	
			
		}finally {
			close(rs);
			close(pstmt);	
		}
		
		return movieList;
	}
	
  
	/** 평가 update DAO
	 * @param conn
	 * @param memberNo
	 * @param movieNo
	 * @param score
	 * @return result
	 * @throws Exception
	 */
	public int updateEvaluation(Connection conn, int memberNo, int movieNo, double score) throws Exception{
  	int result = 0;
		
		try {
      String sql = prop.getProperty("updateEvaluation");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, score);
			pstmt.setInt(2, memberNo);
			pstmt.setInt(3, movieNo);
      
      result = pstmt.executeUpdate();
      
    }finally {
			close(pstmt);
		}
		return result;
	}
	

	/** 평가 insert DAO
	 * @param conn
	 * @param memberNo
	 * @param movieNo
	 * @param score
	 * @return result
	 * @throws Exception
	 */
	public int insertEvaluation(Connection conn, int memberNo, int movieNo, double score) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertEvaluation");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, movieNo);
			pstmt.setDouble(3, score);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 평가 delete DAO
	 * @param conn
	 * @param memberNo
	 * @param movieNo
	 * @param score
	 * @return
	 * @throws Exception
	 */
	public int deleteEvaluation(Connection conn, int memberNo, int movieNo, double score) throws Exception{
    int result = 0;
		
		try {

			String sql = prop.getProperty("deleteEvaluation");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, movieNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}

	
	/** 평가한 영화 개수 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return count
	 * @throws Exception
	 */
	public int evaluationCount(Connection conn, int memberNo) throws Exception {
		int count = 0;
		
		try {
			
			String sql = prop.getProperty("evaluationCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return count;
	}
		


  
  
  
  	/** 쪽지(메세지) 목록 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return messageList
	 * @throws Exception
	 */
	public List<Message> selectMessage(Connection conn, int memberNo) throws Exception {
		
		List<Message> messageList = new ArrayList<Message>();
		
		try {
			String sql = prop.getProperty("selectMessage");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				Message message = new Message();
								
				message.setMessageNo(rs.getInt(1));
				message.setMessageContent(rs.getString(2));
				message.setEnrollDate(rs.getString(3));
				message.setReadFlag(rs.getNString(4));
				message.setMemberName(rs.getString(5));
				message.setProfileImage(rs.getString(6));
				
				messageList.add(message);	
			}
      
		}finally {
			close(rs);
			close(pstmt);
		}
      
    		return messageList;
	}  
      
      
      
      
      
      
      
      
      	/** 로그인 회원의 팔로워 목록 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return fList
	 * @throws Exception
	 */
	public List<Follow> selectFollower(Connection conn, int memberNo) throws Exception{
		
		List<Follow> fList = new ArrayList<Follow>();
		
		try {
			
			String sql = prop.getProperty("selectFollower");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Follow f = new Follow();
				
				f.setTargetNo(memberNo); // 현재 회원번호
				
				f.setMemberNo(rs.getInt(1)); // 팔로워번호
				f.setMemberName(rs.getString(2)); // 팔로워 이름
				f.setProfileImage(rs.getString(3)); // 팔로워의 프로필경로
				f.setEvaluationCount(rs.getInt(4)); // 팔로워의 평가개수
				
				fList.add(f);				
			}	
      		}finally {
			close(rs);
			close(pstmt);
		}
    
    
    
    
    		return fList;
	}

	/** 로그인 회원의 팔로잉 목록 조회 DAO
	 * @param conn
	 * @param memberNo
	 * @return fList
	 * @throws Exception
	 */
	public List<Follow> selectFollowing(Connection conn, int memberNo) throws Exception{
		
		List<Follow> fList = new ArrayList<Follow>();
		
		try {
			
			String sql = prop.getProperty("selectFollowing");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Follow f = new Follow();
				
				f.setMemberNo(memberNo); // 현재 회원번호
				
				f.setTargetNo(rs.getInt(1)); // 팔로잉 회원 번호
				f.setMemberName(rs.getString(2)); // 팔로잉 회원 이름
				f.setProfileImage(rs.getString(3)); // 팔로워의 프로필경로
				f.setEvaluationCount(rs.getInt(4)); // 팔로워의 평가개수
				
				fList.add(f);	
				
			}
			
			
		}finally {
			
			
		}
		
		return fList;
	}

	

	/** 팔로워/팔로잉 삭제 DAO
	 * @param conn
	 * @param memberNo
	 * @param targetNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteFollow(Connection conn, int memberNo, int targetNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteFollow");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, targetNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/** 팔로워/팔로잉 수정(삭제취소) DAO
	 * @param conn
	 * @param memberNo
	 * @param targetNo
	 * @return result
	 * @throws Exception
	 */
	public int updateFollow(Connection conn, int memberNo, int targetNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateFollow");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, targetNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 팔로우 DAO
	 * @param conn
	 * @param memberNo
	 * @param targetNo
	 * @return result
	 * @throws Exception
	 */
	public int insertFollow(Connection conn, int memberNo, int targetNo) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertFollow");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, targetNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	
	
	/** 평가한 영화목록 조회 DAO 
	 * @param conn 
	 * @param memberNo
	 * @return evalMovie
	 * @throws Exception
	 */
	public List<Movie> selectEvalMovie(Connection conn, int memberNo) throws Exception {
		
		List<Movie> evalMovie = new ArrayList<Movie>();
		
		try {
			
			String sql = prop.getProperty("selectEvalMovie");
//			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			// DB에 해당 멤버가 데이터가 없을 때, 오류로 확인시키기
//			if(!rs.next()) {
//				throw new Exception("조회된 결과가 없습니다.");
//			}
			
			while(rs.next()) {
				
				Movie movie = new Movie();
//				 SELECT MOVIE_NO, MOVIE_TITLE, POSTER_IMG, RELEASE_YEAR, COUNTRY
				movie.setRNum(rs.getInt("RNUM"));
				movie.setMovieNo(rs.getInt("MOVIE_NO"));
				movie.setMovieTitle(rs.getString("MOVIE_TITLE"));
				movie.setPosterImage(rs.getString("POSTER_IMG"));
				movie.setReleaseYear(rs.getInt("RELEASE_YEAR"));
				movie.setCountry(rs.getString("COUNTRY"));
				
				evalMovie.add(movie);
				
			} 
			
			// sql잘 되나 확인용
//			System.out.println(evalMovie);
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		return evalMovie;
	}
	
	
	

	/** 취향분석 DAO - 내가 평가한 영화의 갯수
	 * @param conn
	 * @param memberNo
	 * @return analyMovieCount
	 * @throws Exception
	 */
	public int analyMovieCount(Connection conn, int memberNo) throws Exception {
		int analyMovieCount = 0;
		
		try {
			
			String sql = prop.getProperty("analyMovieCount");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				analyMovieCount = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return analyMovieCount;
	}

	
	
	/** 취향분석 - 평가한 점수의 각각의 갯수 ( 0.5점은 3개, 1점은 2개 .. )
	 * @param conn
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public List<Analysis> analyAllScore(Connection conn, int memberNo)  throws Exception {
		
		List<Analysis> analyAll = new ArrayList<Analysis>();
		
		try {
			
			String sql = prop.getProperty("analyAllScore");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				Analysis anal = new Analysis();
				anal.setStarRating(rs.getDouble(1));
				anal.setCount(rs.getInt(2));
				
				
				analyAll.add(anal);	
			} 
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return analyAll;
	}

	
	
	
	/** 취향분석 - 내가 평가한 모든 영화의 가장 많은 country 는?
	 * @param conn
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public String analyMovieCountry(Connection conn, int memberNo)  throws Exception  {
		String analyMovieCountry = null;
		
		try {
			
			String sql = prop.getProperty("analyMovieCountry");
			
			//Connection is null. 
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				analyMovieCountry = rs.getString(1);
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return analyMovieCountry;
	}

	/** 특정 키워드로 인물 검색 DAO
	 * @param conn
	 * @param query
	 * @return personList
	 * @throws Exception
	 */
	public List<Person> searchPerson(Connection conn, String query) throws Exception{
		
		List<Person> personList = new ArrayList<Person>();
		
		try {
			
			String sql = prop.getProperty("searchPerson");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+query+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Person p = new Person();
				
				p.setPersonNo(rs.getInt(1));
				p.setPersonName(rs.getString(2));
				p.setPersonJob(rs.getString(3));
				p.setPersonImage(rs.getString(4));
				
				personList.add(p);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return personList;
	}

	
	/** 특정 인물의 관련 영화정보 조회 DAO
	 * @param conn
	 * @param query
	 * @param person
	 * @return movieList
	 * @throws Exception
	 */
	public List<Movie> selectPersonMovieList(Connection conn, String query, Person p) throws Exception{
		
		List<Movie> movieList = new ArrayList<Movie>();
		
		try {
			
			String sql = prop.getProperty("selectPersonMovieList");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getPersonNo());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Movie m = new Movie();
				
				m.setMovieNo(rs.getInt(2));
				m.setMovieTitle(rs.getString(2));
				
				movieList.add(m);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return movieList;
		
	}

	
	
	/** 취향분석 - 내가 평가한 모든 영화의 모든 RUNNING_TIME
	 * @param conn
	 * @param memberNo
	 * @return
	 */
	public String myAllRunningTime(Connection conn, int memberNo) throws Exception {
		
		String myAllRunningTime = null;
		
		try {
			
			String sql = prop.getProperty("myAllRunningTime");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				myAllRunningTime = rs.getString(1);
			}
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return myAllRunningTime;
	}

	
	
	
	/** 취향분석  -내가 가장 선호한 나라에서, 평가한 영화의 갯수.
	 * @param conn
	 * @param memberNo
	 * @return likeCountryCount
	 * @throws Exception
	 */
	public int likeCountryCount(Connection conn, int memberNo) throws Exception {
		int likeCountryCount = 0;
		
		
		try {
			
			String sql = prop.getProperty("likeCountryCount");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				likeCountryCount = rs.getInt(1);
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return likeCountryCount;
	}

	
	
	
	
	/** 취향분석 - 내가 가장 선호한 나라의 영화의 평점 평균
	 * @param conn
	 * @param memberNo
	 * @return likeCountryAvg
	 * @throws Exception
	 */
	public int likeCountryAvg(Connection conn, int memberNo) throws Exception {
		int likeCountryAvg = 0;
			
			
		try {
			
			String sql = prop.getProperty("likeCountryAvg");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				likeCountryAvg = rs.getInt(1);
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
			
		return likeCountryAvg;
	}
	
	

	/** 내가 평가한 전체 영화 평점
	 * @param conn
	 * @param memberNo
	 * @return allMovieAvg
	 * @throws Exception
	 */
	public int allMovieAvg(Connection conn, int memberNo) throws Exception {
		int allMovieAvg = 0;
		
		try {
			
			String sql = prop.getProperty("allMovieAvg");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				allMovieAvg = rs.getInt(1);
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
			
		return allMovieAvg;
	}


      

}

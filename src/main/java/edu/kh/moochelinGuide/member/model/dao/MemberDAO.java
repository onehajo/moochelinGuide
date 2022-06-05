package edu.kh.moochelinGuide.member.model.dao;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.moochelinGuide.member.model.vo.Member;

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
		Member member = new Member();
		try {
			String sql = prop.getProperty("login");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getMemberEmail());
			pstmt.setString(2, mem.getMemberPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setMemberNo(rs.getInt(1));
				member.setMemberEmail(rs.getString(2));
				member.setMemberName(rs.getString(3));
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

	/** 특정 키워드로 유저 검색 DAO
	 * @param conn
	 * @param query
	 * @return userList
	 * @throws Exception
	 */
	public List<Member> searchUser(Connection conn, String query) throws Exception{
		List<Member> userList = new ArrayList<Member>();
		
		try {
			String sql = prop.getProperty("searchUser");
			
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

}

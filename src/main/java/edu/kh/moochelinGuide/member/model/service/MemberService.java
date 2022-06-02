package edu.kh.moochelinGuide.member.model.service;

import static edu.kh.moochelinGuide.common.JDBCTemplate.*;
import java.sql.Connection;

import edu.kh.moochelinGuide.member.model.dao.MemberDAO;
import edu.kh.moochelinGuide.member.model.vo.Member;

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
	
	
	
	
	
	

}

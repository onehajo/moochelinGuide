package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import edu.kh.moochelinGuide.common.MyRenamePolicy;
import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Member;

@WebServlet("/member/myPage/mod")
public class MayPageModServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/member/myPage_mod.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		try {
			
//			---- 이미지 / 회원정보 수정 공용 정보 ----
			
			// 로그인 세션 ( 로그인 정보 + 이미지용 필요!)
			HttpSession session = req.getSession(); 
			
			
			
//   		------------- 이미지 관련 ------------------------
			int maxSize = 1024 * 1024 * 100; // 업로드 최대 용량 (100MB)
			String root = session.getServletContext().getRealPath("/"); // webapp 폴더까지 경로
			String folderPath = "/resources/images/memProfileImg/"; // 파일 저장 폴더 경로
			String filePath = root + folderPath;
			
			String encoding = "UTF-8"; // 파라미터 중 파일 제외 파라미터(문자열)의 인코딩 지정
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());                

			Member loginMember = (Member)session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo(); // 서비스 호출에서 필요
			
			
			
			// DB에 삽입될 프로필 이미지 경로
			// 단, X버튼이 클릭된 상태면 null을 가지게 한다
			String profileImage = null; // profileImage : 인풋 name
			String bgImage = null; // backgroundFile : 인풋 name
			
			
//	이슈1 :	이미지를 프로필이미지가아니라 배경만 변경했을때, 오류발생 

			// 이미지 변경 / 삭제여부
			int imgDelete = Integer.parseInt(mpReq.getParameter("imgDelete")); // 0이면 변경 1이면 삭제
			int bgDelete = Integer.parseInt(mpReq.getParameter("bgDelete")); // 0이면 변경 1이면 삭제
					
			// 이미지 변경시
			if(imgDelete==0) {
				
				if ( mpReq.getFilesystemName("imgFile") != null ) {
					profileImage = folderPath + mpReq.getFilesystemName("imgFile");
				} else {	
					profileImage = loginMember.getProfileImage();
				}
								
			}else { // 이미지 삭제시
				
				if ( mpReq.getFilesystemName("imgFile") == null ) {
					profileImage = null;
				}
			}
			
			// 배경 변경시
			if(bgDelete==0) {
				
				if ( mpReq.getFilesystemName("backgroundFile") != null ) {
					bgImage = folderPath + mpReq.getFilesystemName("backgroundFile");
				} else {
					
					bgImage = loginMember.getProfileBackImage();
				}
				
			}else { // 배경 삭제시
				
				if ( mpReq.getFilesystemName("backgroundFile") == null ) {
					bgImage = null;
				}
				
			}
			
			
//          ----- 유저정보  -----		
			String memberName = mpReq.getParameter("memberName");
			
			
//			---- 묶기 ----
			// 게시글 관련 정보를 하나의 객체(BoardDetail)에 담기
			Member memberMod = new Member();
			memberMod.setMemberName(memberName);
			memberMod.setProfileImage(profileImage);
			memberMod.setProfileBackImage(bgImage);
			
			
//			----- service 보내기  -----
			MemberService service = new MemberService();
			
			// 회원정보 수정 서비스 수행 후 결과 반환 받기
			int result = service.updateMember(memberMod, memberNo, imgDelete, bgDelete);
			
			if( result > 0 ) {
				
				
				System.out.println(loginMember.getProfileImage());
				
				session.setAttribute("message", "회원 정보 수정완료!");
				
				// 동기화 - 세션값 변경
				loginMember.setProfileImage(profileImage); 
				loginMember.setProfileBackImage(bgImage);
				loginMember.setMemberName(memberName);
				
				session.setAttribute("message", "회원 정보 수정완료!");
				
			} else {
				
				session.setAttribute("message", "회원 정보 수정실패..");
				
			}
			
			// 리다이렉트
			resp.sendRedirect("mod");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	
}

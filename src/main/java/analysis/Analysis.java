package analysis;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;
import edu.kh.moochelinGuide.member.model.vo.Member;


@WebServlet("/member/profile/analysis")
public class Analysis extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			// 필요한 것
			// '특정 회원'의
			// 1) 각 점수 별 카운트 갯수 
			// 2) 평가 테이블에 가장 많은 나라(country)
			// 3) 평가한 테이블의 총 영화 시간.
			
			// 로그인 세션 불러오기 
			HttpSession session = req.getSession();
			Member loginMember = (Member)(session.getAttribute("loginMember"));
			
			// 회원번호
			int memberNo = loginMember.getMemberNo();	
			
			// 회원번호 확인용 - 나중에 삭제할것 
			System.out.println(memberNo); 
			
			// 멤버서비스에서 처리 
			MemberService service = new MemberService();
			
			// map이 Vo가 필요없데, 왜? 모름.
			Map<String, Object> map;
				map = service.analysis(memberNo);
			
			// req에 map 세팅 
			req.setAttribute("map", map);
			
	//	    요청 주소.
			String path = "/WEB-INF/views/member/analysis.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
}

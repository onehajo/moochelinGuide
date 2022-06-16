package edu.kh.moochelinGuide.member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.moochelinGuide.member.model.service.MemberService;


@WebServlet(urlPatterns = {"/pwfind", "/search/pwfind","/movie/pwfind","/movie/detail/pwfind"})
public class PwfindServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String pwFindEmail = req.getParameter("pwFindEmail");
		
		String subject = "[무슐랭 가이드] 새로운 비밀번호를 설정해주세요"; // 제목
		String fromEmail = "moocheliln@gmail.com"; // 보내는 사람으로 표시될 이메일 (보안설정한 메일 아니어도 상관없음)//vljyrleupkedupny
		String fromUsername = "MoochelinGuide"; // 보내는 사람 이름
		String toEmail = pwFindEmail;
		
		
		final String smtpEmail = "moocheliln@gmail.com"; // 이메일 (보안설정했던 G메일)
		final String password = "vljyrleupkedupny"; // 발급 받은 비밀번호 (보안 설정으로 발급받은 비밀번호)//djwfxmbymsbnpgpl//hut


		// 메일 옵션 설정
		Properties props = new Properties();
	  
		// 중요
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587"); //465, 587 둘중에 하나 쓰면됨. 구글쪽prot
		props.put("mail.smtp.auth", "true");
		
		// 추가 옵션
		props.put("mail.smtp.quitwait", "false");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		try {
	         // 메일 세션 생성
	         Session session = Session.getDefaultInstance(props);

	         // 메일 송/수신 옵션 설정(1명 보내기)
	         Message message = new MimeMessage(session);
	      
	         message.setFrom(new InternetAddress(fromEmail, fromUsername));    // 송신자(보내는 사람) 지정
	         
	         message.addRecipient(RecipientType.TO, new InternetAddress(toEmail)); // 수신자(받는사람) 지정
	         
	         message.setSubject(subject); // 이메일 제목 지정
	         
	         
	         
	         // 메일 콘텐츠 설정 (이메일 내용에 html도 들어갈 수 있도록 설정함)
	         Multipart mParts = new MimeMultipart();
	         MimeBodyPart mTextPart = new MimeBodyPart();
	         
	       	         
	         // 메일에 출력할 텍스트
	         StringBuffer sb = new StringBuffer(); // 가변성 문자열 저장 객체
	         
	         
	         // 로고url로 대체
	         String path="https://blogfiles.pstatic.net/MjAyMjA2MTJfMjI2/MDAxNjU1MDE5OTExODI5.Vuz5fAoXYv4TBgHwgJBCmKl2h9MuRVgNXXahOOlTwAUg.zQ4G3z4j2SJ7VCC2DoFeQZ0A8f_w_ii_cKV995mAF2Yg.PNG.choonjum88/logo-blue.png?type=w1";
	         sb.append("<div><div style='width:500px; margin:50px auto;'><img src="+path+" width='200px'>"
	         		+ "<h2>새 비밀번호 설정</h2><hr style=\"background-color: #a1a1a1; width: 24px; height: 1px; margin: 19px 0 10px; padding: 0; border: 0;\">"
	         		+ "<div style='font-size:16px; color:#555;'>안녕하세요, 왓챠피디아입니다.<br>"
	         		+ "아래 버튼을 눌러 새 비밀번호를 설정해주세요.</div>"
	         		
	         		+ "<form action=\"http://localhost:8080/moochelinGuide/resetPw/page\" method=\"post\" target='_blank'><input type=\"hidden\" name=\"memberEmail\"value="+toEmail+">"
	         				+ "<button style=\"color:#fff; font-weight:bold; background-color: #392eff; line-height: 40px; font-size: 17px; font-weight: 500; height: 40px; width: 100%; border-radius: 6px; margin: 31px 0 0;\">비밀번호 변경하기</button></form></div>"
	         				+ "<div align=\"center\" style=\"color: #9b9b9b; background-color: #f6f6f6; line-height: 18px; font-size: 13px; padding-top: 20px; padding-bottom: 38px;\">\r\n"
	         		+ "        <p style=\"margin: 8px 0;\">© 2022. Moochelin Guide All rights reserved.</p>\r\n"
	         		+ "        <p style=\"margin: 8px 0;\">\r\n"
	         		+ "          본 메일은 발신 전용입니다.\r\n"
	         		+ "        </p>\r\n"
	         		+ "    </div></div>\n");         	         
	         

	         String mailContent = sb.toString(); // 문자열로 반환
	         
	         // 메일 콘텐츠 - 내용 , 메일인코딩, "html" 추가 시 HTML 태그가 해석됨
	         mTextPart.setText(mailContent, "UTF-8", "html");
	         mParts.addBodyPart(mTextPart);

	         
	         // 메일 콘텐츠 지정
	         message.setContent(mParts); //이메일에 들어갈 내용
	         
	         
	         // MIME 타입 설정 (이메일 내용이 깨질 때 사용)
	         /*MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
	         MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
	         MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
	         MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
	         MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
	         MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
	         CommandMap.setDefaultCommandMap(MailcapCmdMap);*/

	         // 메일 발송
	         Transport t = session.getTransport("smtp");
	         t.connect(smtpEmail, password);
	         t.sendMessage(message, message.getAllRecipients());
	         t.close();

	         
	         // 발급시간은 sysdate로 저장
	         // 인증번호를 받은 이메일, 인증번호, 인증번호 발급 시간 ->DB삽입
	         //int result = new MemberService().insertCertification(pwFindEmail);
	         
	         // 단순 메일 전송 성공 어떻게함?
	         int result=1;
	         resp.getWriter().print(result); 
	         
	         // 세션 message에 성공메세지 저장하기 
	         // 실패와 성공은 어떻게 구분함??
	         
	         // 메일 다 보내질때 까지 기다렸다가 페이지가 넘어감;;;;;;;;
	         // 비동기로 다시 처리할것.... ㅜㅜ 
	         //resp.sendRedirect(req.getHeader("referer"));
	         

	      } catch (Exception e) {
	         e.printStackTrace();
	         
	         // ajax error 속성 활용을 위한 500에러를 응답으로 전달.
	         resp.setStatus(500);
	         resp.getWriter().print(e.getMessage());
	      }

	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String message = "메일이 발송되었습니다.";
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect(req.getHeader("referer"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

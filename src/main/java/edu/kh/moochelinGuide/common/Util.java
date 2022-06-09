package edu.kh.moochelinGuide.common;

public class Util {

	// 개행문자 -> <br> 변경 처리 메서드
	public static String newLineHandling(String content) {
		
		if(content !=null) {
			return content.replaceAll("(\n|\r|\r\n|\n\r)", "<br>");
		}
		return "";
		
	}
	
	
	
	// XSS : 관리자가 아닌 이용자가 악성 스크립트를 삽입해서 공격. 웹 취약점 중 하나
	// Cross Site Script(XSS, 크로스 사이트 스크립트) 공격 방지 처리 메서드
	public static String XSSHandling(String content) {
		
		if(content !=null) {
			
			// <, >, &, " 문자를 html 코드가 아닌 문자 그대로 보이도록 변경
			content = content.replaceAll("&", "&amp;"); // 가장 위에 순서에 있어야 관련된 문자 깨지지 않음
			content = content.replaceAll("<", "&lt;");
			content = content.replaceAll(">", "&gt;");
			content = content.replaceAll("\"", "&quot;");
		}
		return content;
	}
}

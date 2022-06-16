<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<footer>
	<section class="footer-top">
		지금까지 <span id="evalTotal">★ 658,179,744 개</span>의 평가가 쌓였어요.
	</section>
	<section class="footer-bottom">
		<div>
			<p>서비스 이용약관 | 개인정보 처리방침 | 회사 안내</p>
			<p>고객센터 | cs@moochelin.co.kr, 02-123-4567</p>
			<p>광고 문의 | ad@moochelin.com</p>
			<p>제휴 및 대외 협력 | https://moochelin.team/contact</p>
			<p>주식회사 무슐랭가이드 | 대표 원하조 | 서울특별시 서초구 강남대로 343 신덕빌딩 3층</p>
			<p>사업자 등록 번호 211-88-66013</p>
			<p>MOOCHELIN GUIDE © 2022 All rights reserved.</p>
		</div>
	</section>
</footer>

<%-- session에 message 속성이 존재하는 경우 alert창으로 해당 내용을 출력 --%>
<c:if test="${ !empty sessionScope.message }">
	<script>
         //alert("${message}");      
         
         Swal.fire({
             title: '${message}',
                 confirmButtonColor: '#392eff',
                 confirmButtonText: '확인'
          })
         
         
         // EL 작성 시 scope를 지정하지 않으면
         // page -> request -> session -> application 순서로 검색하여
         // 일치하는 속성이 있으면 출력
   </script>

	<%-- message 1회 출력 후 session에서 제거 --%>
	<c:remove var="message" scope="session" />
</c:if>
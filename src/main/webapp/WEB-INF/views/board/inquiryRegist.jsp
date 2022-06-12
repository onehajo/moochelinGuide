<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>inquiryRegist</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/myPage-style.css">
<!-- 헤더푸터 CSS 연결-->
<link rel="stylesheet"
	href="${contextPath}/resources/css/main-style.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/inquiryRegist.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<script src="https://kit.fontawesome.com/e4f51ae88c.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<main>
		<jsp:include page="/WEB-INF/views/common/myPage_top.jsp" />
		<form action="inquiryRegist" enctype="multipart/form-data"
			method="POST" id="registBtn" accept="image/*"
			onsubmit="return registValidate()">
			<div class="inquiry">
				<h2>문의하기</h2>
				<p>문의주신 내용은 고객센터에서 확인 후 영업일 기준 3~7일 이내에 답변 드리도록 하겠습니다.</p>
				<p>* 운영 시간: 평일 (월 ~ 금) 10:00 ~ 18:00</p>
				<br>
				<p>최근 사회적 거리두기 격상과 함께 문의량이 급증하여, 문의에 대한 답변이 평소보다 지연될 수 있는 점 너른
					양해 부탁드립니다.</p>
				<pre>설명</pre>
				<textarea id="explain" name="explain" cols="30" rows="10"></textarea>
				<p
					style="font-size: 12px; color: rgba(171, 171, 171, 161); margin-bottom: 20px;">문의
					내용을 최대한 자세하게 작성해 주세요. (내용에 욕설이 포함되어 있는 경우 답변이 어려울 수 있는 점 양해
					부탁드립니다.)</p>
			</div>
			<section id="file-top">
				첨부 파일<span>(선택사항)</span><br>
			</section>
			<section id="file-upload">
				<label for="uploadfile" id="upload-btn"><span>파일 추가</span>
					또는 파일을 여기로 드래그</label> <input type="file" id="uploadfile">
			</section>

			<section class="regist">
				<button id="registration">제출</button>
			</section>
		</form>










	</main>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/inquiryRegist.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>moochelinGuide</title>

<link rel="stylesheet" href="resources/css/main-style.css">

<script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">

</head>
<body>
	<jsp:include page="/WEB-INF/views/admin/adminHeader.jsp" />

	<main>	

		<section class="content-main">

			<div class="current-data">
				<span>현재 데이터</span> <span> 2022/05/23 12:11:15</span>
			</div>
			<div class="movie-btn">영화 데이터 크롤링</div>

			<div class="dashBoard">
				<div class="dashMovie">
					<div class="dash-con">현재 영화 : 100,000,000 개</div>
					<div class="dash-con">최근 추가된 영화 수 : 1000 개</div>
				</div>
				<div class="dashUser">
					<div class="dash-con">현재 회원 수 : 100,000,000 명</div>
					<div class="dash-con">어제 가입자 수 : + 500,000명</div>
				</div>
				<div class="dashCS">
					<div class="dash-con">어제의 문의 글 : +100,000 건</div>
					<div class="dash-con">미처리 문의건 : 20,000 건</div>
				</div>
			</div>

		</section>

	</main>




	loginMember : ${sessionScope.loginMember}
	<hr>
	세션확인하는 임시 코드 message : ${sessionScope.message}



	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<!-- test -->
	<script src="http://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>

	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지-탈퇴하기</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/myPage-style.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/myPageSecession-style.css">
<!-- 헤더푸터 CSS 연결-->
<link rel="stylesheet"
	href="${contextPath}/resources/css/main-style.css">

<script src="https://kit.fontawesome.com/e4f51ae88c.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap"
	rel="stylesheet">

</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<main>

		<jsp:include page="/WEB-INF/views/common/myPage_top.jsp" />

		<section class="mypage-content" id="secession-content">
			<section class="secession-container">
				<div>
					<img src="${contextPath}/resources/images/moo_logo_full_bm.png"
						class="secession-logo">
				</div>
				<div>
					<span>정말 탈퇴하시겠습니까 ?</span>
				</div>
				<form action="confirm" method="POST">
					<div>
						<input type="password" name="inputPw" id="inputPw"
							placeholder="현재 비밀번호를 입력해주세요."> <span id="msg"></span>
					</div>
					<div>
						<button id="secessionBtn">탈퇴하기</button>
					</div>
				</form>

			</section>
		</section>


	</main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

	<script>
        const contextPath = "${contextPath}";
        const loginMemberNo = "${loginMember.memberNo}";
    </script>
	<script src="${contextPath}/resources/js/myPage-secession.js"></script>

</body>
</html>
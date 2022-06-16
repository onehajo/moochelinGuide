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
	href="${contextPath}/resources/css/myPageSecessionConfirm-style.css">

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

		<section class="main">
			<section class="content-main">

				<div id="secession-box">
					<div>
						<img src="${contextPath}/resources/images/moo_logo_full_bm.png">
					</div>
					<div>
						<p class="secessionTitle">정말 탈퇴하시겠습니까 ?</p>
					</div>
					<div>
						<form action="do" method="POST">
							<input type="hidden" name="answer" value="yes">
							<button name="secession-check" id="answer">예</button>
							<button type="button" name="secession-check" id="cancel"
								onclick="location.href='${header.referer}'">아니요</button>
						</form>
					</div>
				</div>

			</section>
		</section>


	</main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

	<script>
        // 최상위주소
        const contextPath = "${contextPath}";
        // 로그인한 회원번호
        const loginMemberNo = "${loginMember.memberNo}";
    </script>
	<script src="${contextPath}/resources/js/myPage-secession.js"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

</body>
</html>
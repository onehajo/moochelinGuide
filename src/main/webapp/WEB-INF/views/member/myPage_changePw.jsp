<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지-회원정보수정</title>
<script src="https://kit.fontawesome.com/e4f51ae88c.js"
	crossorigin="anonymous"></script>

<!-- 헤더푸터 CSS 연결-->
<link rel="stylesheet"
	href="${contextPath}/resources/css/main-style.css">
<!-- 마이페이지 CSS -->
<link rel="stylesheet"
	href="${contextPath}/resources/css/myPage-style.css">


<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap"
	rel="stylesheet">


    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->

	<style>
        .swal2-title{
            font-size: 20px;
        }
    </style>

</head>
<body>
	<!-- member 폴더에 넣기 -->


	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<main>

		<jsp:include page="/WEB-INF/views/common/myPage_top.jsp" />

		<section class="mypage-content">
			<div>
				<h2>비밀번호 변경</h2>
			</div>

			<!-- http://localhost:8086/moochelinGuide/member/myPage/changePw -->
			<form action="changePw" method="post" name="myPage-form"
				onsubmit="return changePwValidate()">

				<div class="myPage-row">
					<label>현재 비밀번호</label> <input type="password" name="currentPw" id="currentPw"
						placeholder="현재 비밀번호를 입력해주세요" maxlength="15">
				</div>
				<span class="myPage PwMessage" id="pwMessage">* 영어, 숫자,
					특수문자(!,@,#,-,_) 6~15글자 사이로 작성해주세요.</span>


				<div class="myPage-row">
					<label>새 비밀번호</label> <input type="password" name="newPw" id="newPw"
						placeholder="새 비밀번호를 입력해주세요." maxlength="15">
				</div>
				<span class="myPage PwMessage" id="newPwMessage">* 영어, 숫자,
					특수문자(!,@,#,-,_) 6~15글자로 작성해주세요.</span>

				<div class="myPage-row">
					<label>새 비밀번호 확인</label> <input type="password" name="newPwConfirm" id="newPwConfirm"
						placeholder="새 비밀번호를 확인 해주세요." maxlength="15">
				</div>
				<span class="myPage PwMessage" id="newPwMessageConfirm">* 영어,
					숫자, 특수문자(!,@,#,-,_) 6~15글자로 작성해주세요.</span>



				<button id="complete">변경하기</button>


			</form>

		</section>



	</main>


	<jsp:include page="/WEB-INF/views/common/footer.jsp" />


	<script src="${contextPath}/resources/js/myPage-changePw.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>   
</body>
</html>
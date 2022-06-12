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

</head>
<body>
	<!-- member 폴더에 넣기 -->


	<jsp:include page="/WEB-INF/views/common/header.jsp" />



	<main>

		<jsp:include page="/WEB-INF/views/common/myPage_top.jsp" />

		<section class="mypage-content">
			<div>
				<h2>회원정보 수정</h2>
			</div>

			<!-- 멀티파트/폼데이타 -->
			<form action="mod" enctype="multipart/form-data" method="post"
				name="myPage-form" onsubmit="return modValidate()">

				<div class="myPage-row">
					<label>이메일</label> <input type="text" name="memberEmail"
						placeholder="로그인@이메일.com" value="${loginMember.memberEmail}"
						maxlength="10" disabled>
				</div>
				<span class="myPage emailMessage">*이메일(아이디)는 수정 불가합니다.</span>

				<div class="myPage-row">
					<label>가입일</label> <input type="text" name="enrollDate"
						placeholder="YYYY-MM-DD" value="${loginMember.enrollDate}"
						maxlength="11" disabled>
				</div>
				<span class="myPage emailMessage">*가입일은 수정 불가합니다.</span>

				<div class="myPage-row">
					<label>이름</label> <input type="text" id="memberName"
						name="memberName" placeholder="회원이름"
						value="${loginMember.memberName}" maxlength="11">
				</div>
				<span class="myPage Name" id="nameMsg">*필수 입력사항입니다.</span>

				<!-- 
                이슈 : 프로필이미지 삽입 X / 배경이미지 삽입 O -> 오류
                        프로필이미지 삽입O 수정 후, 다시 배경 삽입 -> 오류 -->
				<span>프로필 이미지</span>
				<div class="myPage-row  input-none">
					<div class="profile-image-area">
						<!-- 기본 이미지 -->
						<c:if test="${ empty loginMember.profileImage}">
							<img src="${contextPath}/resources/images/logo-blue.png"
								id="profile-image">
						</c:if>
						<!-- 변경 이미지 -->
						<c:if test="${ !empty loginMember.profileImage}">
							<img src="${contextPath}${loginMember.profileImage}"
								id="profile-image">
						</c:if>
					</div>

					<div class="button img">
						<label for="input-image"> 이미지 변경 </label>
					</div>
					<input type="file" id="input-image" name="imgFile" accept="image/*">
					<!-- 0안눌러짐 1눌러짐 -->
					<div class="button img">
						<span id="delete-image"> 이미지 삭제 </span> <input type="hidden"
							name="imgDelete" id="imgDelete" value="0">
					</div>
				</div>



				<span>배경 이미지</span>
				<div class="myPage-row input-none">
					<div class="profile-image-area">


						<!-- 기본 이미지 -->
						<c:if test="${empty loginMember.profileBackImage}">
							<img src="${contextPath}/resources/images/logo-blue.png"
								id="back-ground">
						</c:if>
						<!-- 변경 이미지 -->
						<c:if test="${!empty loginMember.profileBackImage}">

							<!-- src="/moochelinGuide/resources/images/memProfileImg/null" -->
							<img src="${contextPath}${loginMember.profileBackImage}"
								id="back-ground">
						</c:if>
					</div>

					<div class="button img">
						<label for="input-background"> 이미지 변경 </label>
					</div>

					<input type="file" id="input-background" name="backgroundFile"
						accept="image/*">

					<div class="button img">
						<span id="delete-background"> 이미지 삭제 </span>
						<!-- 0안눌러짐 1눌러짐 -->
						<input type="hidden" name="bgDelete" id="bgDelete" value="0">
					</div>

				</div>

				<button id="complete">수정하기</button>

				${sessionScope.loginMember}


			</form>

		</section>



	</main>


	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script>
        // 최상위주소
        const contextPath = "${contextPath}";
        // 로그인한 회원번호
        const loginMemberNo = "${loginMember.memberNo}";
    </script>

	<script src="${contextPath}/resources/js/myPage-mod.js"></script>

</body>
</html>
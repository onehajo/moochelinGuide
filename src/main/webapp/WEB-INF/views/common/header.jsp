<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="main-css scroll">
	<nav>
		<div class="hd-center">
			<ul>
				<!-- 로고 -->
				<li class="logo">
					<a href="${contextPath}">
						<svg id="a" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 203.48 128.31"><defs><style>.b{fill:#392eff;}</style></defs><g><path class="b" d="M.86,.8H13.93l8.04,13.18L30,.8h13.07V38.31h-12.48V19.72l-8.63,13.34h-.21l-8.63-13.34v18.59H.86V.8Z"/><path class="b" d="M0,64.66v-.11c0-11.2,8.73-19.55,19.93-19.55,8.25,0,13.82,4.02,16.98,9.75l-10.34,6.05c-1.39-2.68-3.38-4.55-6.8-4.55-4.23,0-7.02,3.7-7.02,8.2v.11c0,4.88,2.89,8.3,7.02,8.3,3.54,0,5.52-1.93,7.07-4.71l10.34,5.84c-3.16,5.57-8.41,10.13-17.73,10.13-10.39,0-19.45-7.82-19.45-19.45Z"/><path class="b" d="M39.59,45.8h12.54v13.23h11.46v-13.23h12.54v37.5h-12.54v-13.45h-11.46v13.45h-12.54V45.8Z"/><path class="b" d="M80.42,45.8h31.98v10.29h-19.66v3.8h18.32v9.05h-18.32v4.07h19.93v10.29h-32.25V45.8Z"/><path class="b" d="M116.04,45.8h12.54v26.79h17.63v10.71h-30.16V45.8Z"/><path class="b" d="M149.04,45.8h12.54v37.5h-12.54V45.8Z"/><path class="b" d="M165.97,45.8h11.73l13.34,16.55v-16.55h12.43v37.5h-11.14l-13.93-17.3v17.3h-12.43V45.8Z"/><path class="b" d="M0,109.66v-.11c0-11.2,8.84-19.55,20.68-19.55,6.43,0,11.62,2.14,15.7,5.68l-7.02,8.46c-2.46-2.09-5.2-3.27-8.3-3.27-4.88,0-8.41,3.75-8.41,8.84v.11c0,5.3,3.7,8.95,8.95,8.95,2.14,0,3.32-.32,4.29-.86v-3.75h-6.43v-8.04h18.16v17.36c-4.07,3.32-9.75,5.63-16.55,5.63-11.68,0-21.05-7.82-21.05-19.45Z"/><path class="b" d="M40.93,111.48v-20.68h12.75v20.52c0,4.66,2.41,6.64,5.79,6.64s5.79-1.82,5.79-6.38v-20.79h12.75v20.41c0,12.8-7.45,17.84-18.64,17.84s-18.43-5.14-18.43-17.57Z"/><path class="b" d="M82.08,90.8h12.54v37.5h-12.54v-37.5Z"/><path class="b" d="M99.01,90.8h14.36c14.89,0,22.34,7.34,22.34,18.43v.11c0,11.09-7.61,18.96-22.77,18.96h-13.93v-37.5Zm12.54,10.93v15.64h2.09c5.73,0,9.43-2.36,9.43-7.77v-.11c0-5.41-3.7-7.77-9.43-7.77h-2.09Z"/><path class="b" d="M139.13,90.8h31.98v10.29h-19.66v3.8h18.32v9.05h-18.32v4.07h19.93v10.29h-32.25v-37.5Z"/></g><g><g><path class="b" d="M67.02,0c-11.57,0-20.52,8.68-20.52,19.55v.11c0,10.88,8.84,19.45,20.41,19.45s20.52-8.68,20.52-19.55v-.11c0-10.88-8.84-19.45-20.41-19.45Zm-.11,29.66c-5.61,0-10.17-4.55-10.17-10.17s4.55-10.17,10.17-10.17,10.17,4.55,10.17,10.17-4.55,10.17-10.17,10.17Z"/><circle class="b" cx="66.91" cy="19.5" r="4.2"/></g><g><path class="b" d="M110.52,0c-11.57,0-20.52,8.68-20.52,19.55v.11c0,10.88,8.84,19.45,20.41,19.45s20.52-8.68,20.52-19.55v-.11c0-10.88-8.84-19.45-20.41-19.45Zm-.11,29.66c-5.61,0-10.17-4.55-10.17-10.17s4.55-10.17,10.17-10.17,10.17,4.55,10.17,10.17-4.55,10.17-10.17,10.17Z"/><circle class="b" cx="110.41" cy="19.5" r="4.2"/></g></g></svg>
					</a>
				</li>
				
				<li class="showing"><a href="${contextPath}">박스오피스</a></li>
				<li class="all"><a href="${contextPath}/movie/allMovie?category=select">전체영화</a></li>
				
				<!-- 검색 -->
				<li class="sch">
					<article class="search-area">

						<c:if test="${empty query}"> <!-- 검색어 최초 입력시 -->
							<form action="${contextPath}/search/title" name="search-form" onsubmit="return searchValidate();">
								<fieldset class="hd-fieldset">
									<button class="btnSchI"><i class="fa-solid fa-magnifying-glass" id="search-btn"></i></button>
										<input type="search" id="query" name="query" autocomplete="off" placeholder="제목, 인물, 유저를 검색해보세요">
								</fieldset>
							</form>
						</c:if>

						<c:if test="${!empty query}"> <!-- 기존에 입력된 검색어가 입력된 경우 -->
							<form action="${contextPath}/search/title" name="search-form" onsubmit="return searchValidate();">
								<fieldset class="hd-fieldset">
									<button class="btnSchI"><i class="fa-solid fa-magnifying-glass" id="search-btn"></i></button>
										<input type="search" id="query" name="query" autocomplete="off" placeholder="${query}">
								</fieldset>
							</form>
						</c:if>

					</article>
				</li>
				
							
				<c:choose>
					<%-- 로그인이 되어있지 않은 경우--%>
					<c:when test="${empty sessionScope.loginMember}">
						<li class="login"><a href="#" onclick="openPopLogin()">로그인</a></li>
						<li class="signup"><a href="#" onclick="openPopSignUp()">회원가입</a></li>
					</c:when>
					                    
					<%-- 로그인이 되어있는 경우 --%>
					<c:otherwise>
						<li class="grade"><a href="${contextPath}/member/evaluation">평가하기</a></li>
						
						<c:if test="${empty loginMember.profileImage}">
							<li class="profile"><a href="${contextPath}/member/profile/my?memberNo=${loginMember.memberNo}"><div id="profileImage" style=" background-size: 40px; background-image : url('${contextPath}/resources/images/user.png')"></div></a></li>						
						</c:if>

						
						<c:if test="${!empty loginMember.profileImage}">
							<li class="profile"><a href="${contextPath}/member/profile/my?memberNo=${loginMember.memberNo}"><div id="profileImage" style=" background-size: 40px; background-image : url(${contextPath}${loginMember.profileImage})"></div></a></li>						
						</c:if>
						
					</c:otherwise>            	
				</c:choose>
            		
            		
			</ul>
		</div>
	</nav>
</header>

<!-- 로그인, 회원가입 팝업 시 검은 배경 화면 -->   
<div class="dark" onclick="closePoplog();"></div>
<div class="dark1" onclick="closeAgree();"></div>

<!-- 팝업될 로그인 div -->
<div id="login-box" class="popup">
	<img src="${contextPath}/resources/images/logo-blue.png" alt="">
	<p class="popupTitle">로그인</p>
	<form action="login" method="post" id="login-form" class="form-css" onsubmit="return loginValidate()">
		<input type="text" placeholder="이메일" id="loginEmail" name="memberEmail">
		<div id="emailComment"></div>
		<input type="password" placeholder="비밀번호" id="loginPw" name="memberPw">
		<div id="pwComment"></div>
		<button id="loginBbtn" class="btn">로그인</button>
	</form>
	<div class="login-other">
		<div><a onclick="openPw()">비밀번호를 잊어버리셨나요?</a></div>
		<div>계정이 없으신가요?<a onclick="openPopSignUp()">회원가입</a></div>
	</div>
	<hr class="line"></hr>
	
	<!-- 1번방식 -->
	<!-- <div class="sns" id="GgCustomLogin">
		<a href="javascript:void(0)">
			<img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMjQiIGhlaWdodD0iMjQiIHZpZXdCb3g9IjAgMCAyNCAyNCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGZpbGwtcnVsZT0iZXZlbm9kZCIgY2xpcC1ydWxlPSJldmVub2RkIiBkPSJNMjAuNjQgMTIuMjA0MkMyMC42NCAxMS41NjYgMjAuNTgyNyAxMC45NTI0IDIwLjQ3NjQgMTAuMzYzM0gxMlYxMy44NDQ2SDE2Ljg0MzZDMTYuNjM1IDE0Ljk2OTYgMTYuMDAwOSAxNS45MjI4IDE1LjA0NzcgMTYuNTYxVjE4LjgxOTJIMTcuOTU2NEMxOS42NTgyIDE3LjI1MjQgMjAuNjQgMTQuOTQ1MSAyMC42NCAxMi4yMDQyVjEyLjIwNDJaIiBmaWxsPSIjNDI4NUY0Ii8+CiAgICA8cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGNsaXAtcnVsZT0iZXZlbm9kZCIgZD0iTTExLjk5OTggMjFDMTQuNDI5OCAyMSAxNi40NjcgMjAuMTk0MSAxNy45NTYxIDE4LjgxOTVMMTUuMDQ3NSAxNi41NjEzQzE0LjI0MTYgMTcuMTAxMyAxMy4yMTA3IDE3LjQyMDQgMTEuOTk5OCAxNy40MjA0QzkuNjU1NjcgMTcuNDIwNCA3LjY3MTU4IDE1LjgzNzIgNi45NjM4NSAxMy43MUgzLjk1NzAzVjE2LjA0MThDNS40Mzc5NCAxOC45ODMxIDguNDgxNTggMjEgMTEuOTk5OCAyMVYyMVoiIGZpbGw9IiMzNEE4NTMiLz4KICAgIDxwYXRoIGZpbGwtcnVsZT0iZXZlbm9kZCIgY2xpcC1ydWxlPSJldmVub2RkIiBkPSJNNi45NjQwOSAxMy43MDk4QzYuNzg0MDkgMTMuMTY5OCA2LjY4MTgyIDEyLjU5MyA2LjY4MTgyIDExLjk5OThDNi42ODE4MiAxMS40MDY2IDYuNzg0MDkgMTAuODI5OCA2Ljk2NDA5IDEwLjI4OThWNy45NTgwMUgzLjk1NzI3QzMuMzQ3NzMgOS4xNzMwMSAzIDEwLjU0NzYgMyAxMS45OTk4QzMgMTMuNDUyMSAzLjM0NzczIDE0LjgyNjYgMy45NTcyNyAxNi4wNDE2TDYuOTY0MDkgMTMuNzA5OFYxMy43MDk4WiIgZmlsbD0iI0ZCQkMwNSIvPgogICAgPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0xMi4wNDI3IDYuNTc5NTVDMTMuMzY0MSA2LjU3OTU1IDE0LjU1MDUgNy4wMzM2NCAxNS40ODMyIDcuOTI1NDVMMTguMDY0NSA1LjM0NDA5QzE2LjUwNTkgMy44OTE4MiAxNC40Njg2IDMgMTIuMDQyNyAzQzguNTI0NTUgMyA1LjQ4MDkxIDUuMDE2ODIgNCA3Ljk1ODE4TDcuMDA2ODIgMTAuMjlDNy43MTQ1NSA4LjE2MjczIDkuNjk4NjQgNi41Nzk1NSAxMi4wNDI3IDYuNTc5NTVWNi41Nzk1NVoiIGZpbGw9IiNFQTQzMzUiLz4KPC9zdmc+Cg==" class="css-1hfgk44">
		</a>
	</div> -->
	
	<!-- 2번방식 , 계정 로그인 과정은 구현은 되나 결과적으로 로그인되지 않음. 콘솔에 프로필이 불러와지지 않음 (js의 onSignIn()에 콘솔) -->
	<!-- <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div> -->
	
	<!-- 3번 방식 , 구글에 게시된 최근폼?으로 버튼 번경 
	// 지정된 클라이언트 ID에 대해 지정된 출처가 허용되지 않습니다 // 에러 발생 -->
<!-- 	<div id="g_id_onload"
         data-client_id="263322996104-ijiaiibe7ha6d2g8c7vm0ktdhqlkiq7t.apps.googleusercontent.com"
         data-callback="handleCredentialResponse">
    </div>
    <div class="g_id_signin" data-type="standard" data-onsuccess="onSignIn"></div> -->
    
</div>

<!-- 팝업될 회원가입 div -->
<form action="signUp" method="post" id="signup-form" onsubmit="return signUpValidate()" >

	<div id="signup-box" class="popup">
		<img src="${contextPath}/resources/images/logo-blue.png" alt="">
		<p class="popupTitle">회원가입</p>
		<div class="form-css">
			<input type="text" placeholder="이름" id="signUpName" name="memberName">
			<div id="nameMessage"></div>
			<input type="text" placeholder="이메일" id="signUpEmail" name="memberEmail">
			<div id="emailMessage"></div>
			<input type="password" placeholder="비밀번호" id="signUpPw" name="memberPw">
			<div id="pwMessage"></div>
			<button type="button" id="signup-btn" class="btn">회원가입</button>
		</div>
		<div class="login-other">
		<div>이미 가입하셨나요?<a onclick="openPopLogin()"> 로그인</a></div>
	</div>
	<hr class="line"></hr>
	<!-- <div class="sns" id="GgCustomLogin">
		<a href="javascript:void(0)">
			<img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iMjQiIGhlaWdodD0iMjQiIHZpZXdCb3g9IjAgMCAyNCAyNCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxwYXRoIGZpbGwtcnVsZT0iZXZlbm9kZCIgY2xpcC1ydWxlPSJldmVub2RkIiBkPSJNMjAuNjQgMTIuMjA0MkMyMC42NCAxMS41NjYgMjAuNTgyNyAxMC45NTI0IDIwLjQ3NjQgMTAuMzYzM0gxMlYxMy44NDQ2SDE2Ljg0MzZDMTYuNjM1IDE0Ljk2OTYgMTYuMDAwOSAxNS45MjI4IDE1LjA0NzcgMTYuNTYxVjE4LjgxOTJIMTcuOTU2NEMxOS42NTgyIDE3LjI1MjQgMjAuNjQgMTQuOTQ1MSAyMC42NCAxMi4yMDQyVjEyLjIwNDJaIiBmaWxsPSIjNDI4NUY0Ii8+CiAgICA8cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGNsaXAtcnVsZT0iZXZlbm9kZCIgZD0iTTExLjk5OTggMjFDMTQuNDI5OCAyMSAxNi40NjcgMjAuMTk0MSAxNy45NTYxIDE4LjgxOTVMMTUuMDQ3NSAxNi41NjEzQzE0LjI0MTYgMTcuMTAxMyAxMy4yMTA3IDE3LjQyMDQgMTEuOTk5OCAxNy40MjA0QzkuNjU1NjcgMTcuNDIwNCA3LjY3MTU4IDE1LjgzNzIgNi45NjM4NSAxMy43MUgzLjk1NzAzVjE2LjA0MThDNS40Mzc5NCAxOC45ODMxIDguNDgxNTggMjEgMTEuOTk5OCAyMVYyMVoiIGZpbGw9IiMzNEE4NTMiLz4KICAgIDxwYXRoIGZpbGwtcnVsZT0iZXZlbm9kZCIgY2xpcC1ydWxlPSJldmVub2RkIiBkPSJNNi45NjQwOSAxMy43MDk4QzYuNzg0MDkgMTMuMTY5OCA2LjY4MTgyIDEyLjU5MyA2LjY4MTgyIDExLjk5OThDNi42ODE4MiAxMS40MDY2IDYuNzg0MDkgMTAuODI5OCA2Ljk2NDA5IDEwLjI4OThWNy45NTgwMUgzLjk1NzI3QzMuMzQ3NzMgOS4xNzMwMSAzIDEwLjU0NzYgMyAxMS45OTk4QzMgMTMuNDUyMSAzLjM0NzczIDE0LjgyNjYgMy45NTcyNyAxNi4wNDE2TDYuOTY0MDkgMTMuNzA5OFYxMy43MDk4WiIgZmlsbD0iI0ZCQkMwNSIvPgogICAgPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0xMi4wNDI3IDYuNTc5NTVDMTMuMzY0MSA2LjU3OTU1IDE0LjU1MDUgNy4wMzM2NCAxNS40ODMyIDcuOTI1NDVMMTguMDY0NSA1LjM0NDA5QzE2LjUwNTkgMy44OTE4MiAxNC40Njg2IDMgMTIuMDQyNyAzQzguNTI0NTUgMyA1LjQ4MDkxIDUuMDE2ODIgNCA3Ljk1ODE4TDcuMDA2ODIgMTAuMjlDNy43MTQ1NSA4LjE2MjczIDkuNjk4NjQgNi41Nzk1NSAxMi4wNDI3IDYuNTc5NTVWNi41Nzk1NVoiIGZpbGw9IiNFQTQzMzUiLz4KPC9zdmc+Cg==" class="css-1hfgk44">
		</a>
	</div> -->
	<!-- <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div> -->
</div>

<!-- 팝업될 약관동의 화면 -->
<section id="agree" class="popup" style="padding: 0;">
	<div class="agree-title">약관에 동의하시면<br>가입이 완료됩니다.</div>
	<div class="agree-all">
		<input type="checkbox" id="agreeAll" name="agreeCheck" onclick="selectAll(this)">전체 약관 동의
	</div>
	<ul>
		<li>
			<div><input type="checkbox" id="agree1" name="agreeCheck">서비스 이용약관</div>
			<button>보기</button>
		</li>
		<li>
			<div><input type="checkbox" id="agree2" name="agreeCheck">개인정보 처리방침</div>
			<button>보기</button>
		</li>
		<li>
			<div><input type="checkbox" id="agree3" name="agreeCheck">신작 알림, 이벤트 정보 수신(선택)</div>
			<button>보기</button>
		</li>
	</ul>
	<div class="agree-submit"><button type="submit">가입하기</button></div>
</section>
</form>

<!-- 비밀번호 변경 이메일 보내기 -->
<div id="pw-box" class="popup">

    <p class="popupTitle">비밀번호 재설정</p>
    <div class="popupSub">비밀번호를 잊으셨나요?</div>
    <div class="popupText">가입했던 이메일을 적어주세요.</div>
    <div class="popupText">입력하신 이메일 주소로 비밀번호 변경 메일을 보낼게요.</div>
    
    <form action="pwfind" method="get" class="form-css" onsubmit="return pwfindValidate()">
        <input type="text" placeholder="이메일" id="pwFindEmail" name="pwFindEmail">
        <div id="pwfindText"></div>
        <button id="pwfindBtn" class="btn">비밀번호 변경 이메일 보내기</button>
    </form>
    
</div>

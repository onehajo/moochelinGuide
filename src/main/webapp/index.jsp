<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>moochelinGuide</title>

<link rel="stylesheet" href="resources/css/main-style.css">

<!-- 스윗얼럿 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->

<script src="https://kit.fontawesome.com/e4f51ae88c.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap"
	rel="stylesheet">


<!-- google 로그인 관련 -->
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="263322996104-ijiaiibe7ha6d2g8c7vm0ktdhqlkiq7t.apps.googleusercontent.com">
<!-- 이거 이제 인증에 사용안한다함(?) 아래껄로 대체 가능하다고함. -->
<!-- <script src="https://apis.google.com/js/platform.js" async defer></script> -->

<!-- 클라이언트 라이브러리 -->
<script src="https://accounts.google.com/gsi/client" async defer></script>


<script src="${contextPath}/resources/js/popup.js"></script>

<!-- 요기에 스타일  -->
<style>
	.popup-container {
		position: fixed;
		display: table;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		z-index : 999;
		animation: fadein 1s 1;
	}
	.popup-container-inner {
		display: table-cell;
		text-align: center;
		vertical-align: middle
		}
	.layer .close-pop {
		display: inline-block;
		}

	.close-pop {
		width: 350px; 
		height: 324px; 
		border-radius: 50%;
		background-color: transparent;
		border: none;

		cursor: pointer;
	}

	.introPage{
		animation: fadeout 0.7s;
		-moz-animation: fadein 1s; /* Firefox */
		-webkit-animation: fadein 1s; /* Safari and Chrome */
		-o-animation: fadein 1s; /* Opera */
	}

	/* intro 페이드인 */
	@keyframes fadeout {
		from {
			opacity: 1;
		}
		to {
			opacity: 0;
		}
}
	
	
</style>


</head>
<body>


		<!-- 요소 요기넣고  -->
		<div class="popup-container" onclick="closePop();">
			<div class="popup-container-inner">
				
				<!-- <button class="close-pop" onclick="closePop();" style=" width: 350px;  height: 324px; border-radius: 50%;"></button> -->
				<img class="introPage"  src="${contextPayh}resources/images/intro.jpeg" usemap="#go-index"  style="width: 100%;" >
	
			</div>
		</div>





	<jsp:include page="/WEB-INF/views/common/header.jsp" />

	<main>
		<section class="content-main">
			<p class="sectionTitle">박스오피스 순위</p>
			<section class="movie-list-all">
				<ul class="movie-list">

					
					<!-- 상영중인 영화리스트 -->
					 <c:choose>
					<c:when test="${empty movieList}">
						<div>영화리스트가 존재하지 않습니다.</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="movie" items="${movieList}"  varStatus="num">
					
						<li><a href="movie/detail/select?no=${movie.movieNo}">
								<div class="movie">
									<div class="movie-top">
										<div class="movie-poster">
											<img src="${movie.posterImage}" alt="">
										</div>
										<div class="ranking">${num.count}</div>
									</div>
									<div class="movie-bottom">
										<div class="movie-title">${movie.movieTitle}</div>
										<div class="movie-year-contry">${movie.releaseYear} ・ ${movie.country}</div>
										<div class="average">
											<span>평균</span>
											<svg width="12" height="10" viewBox="0 0 12 10"
												xmlns="http://www.w3.org/2000/svg" fill="#555765"
												class="css-1g90l0x">
												<path fill-rule="evenodd" clip-rule="evenodd"
													d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
											<span>${movie.starRating}</span>
										</div>
										<div class="showing-info">예매율 ${movie.ticketing} ・ ${movie.audience}</div>
									</div>
								</div>
							</a>
						</li>
						
						</c:forEach>
					</c:otherwise>
					</c:choose> 

				</ul>
			</section>


		</section>
	</main>


	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<!-- test -->
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"
		type="text/javascript"></script>

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>
	<script src="${contextPath}/resources/js/indexNowshowing.js"></script>
	<script>
		const contextPath = "${contextPath}";
	</script>


	<script>

		// 홈페이지 접속했을때, 쿠키가 있으면 none / 없으면 block (== 인트로 페이지 노출)
		console.log(document.cookie);
		currentCookie = document.cookie;
		var cookieCheck = currentCookie.indexOf('intro');

		console.log(currentCookie);
		if (cookieCheck > -1 ){
			document.querySelector('.introPage').style.display = 'none';
			document.querySelector('.popup-container').style.display = 'none';
		} else {
			document.querySelector('.introPage').style.display = 'block';
		}



		// 현재 날짜 지정
		var date = new Date();

		// 내일 날짜 출력 확인
		console.log(date.getHours() + 1); 
		// 내일 날짜 지정.
		date.setDate(date.getHours() + 1);

		var setCookie = '';

		setCookie += 'MooCheline = intro;'; // intro == value
		setCookie += 'expires = ' + date.toUTCString(); // UTC 시간기준

		document.cookie = setCookie;
		

		// 검은배경 클릭할때 (로그인, 회원가입 닫기)
		function closePop(){
			document.querySelector('.popup-container').style.display = 'none';

		}


	</script>




</body>
</html>
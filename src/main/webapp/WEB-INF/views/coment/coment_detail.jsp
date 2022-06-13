<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/coment_detail.css" type="text/css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/main-style.css" type="text/css">

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
		<div id="wrapper">
			<header id="header-2">
				<div class="header-wrap">
					<div><-</div>
				</div>
			</header>
			<header id="header">
				<div class="header-wrap">

					<div class="coment-title">코멘트</div>
				</div>
		</div>
		</header>

		<div class="info">
			<div class="contaner">
				<div class="conment-info">
					<div class="coment-proflie">
						<a href="#"><img src="css/image/user.png" id="member-profile"></a>
					</div>
					<div class="coment-nickname">
						못할 바이며
						<div class="coment-row">어쩌고</div>
					</div>
					<div class="hart">하트</div>
				</div>
				<hr>
				<div class="coment-cotent">낙원을 장식하는 천자만홍이 어디 있으며 인생을 풍부하게 하는
					온갖 과실이 어디 있으랴? 이상! 우리의 청춘이 가장 많이 품고 있는 낙원을 장식하는 천자만홍이 어디 있으며 인생을
					풍부하게 하는 온갖 과실이 어디 있으랴?</div>
			</div>
			<div class="contaner">
				<div class="conment-info">
					<div class="coment-proflie">
						<a href="#"><img src="css/image/user.png" id="member-profile"></a>
					</div>
					<div class="coment-nickname">
						못할 바이며
						<div class="coment-row">어쩌고</div>
					</div>
					<div class="hart">하트</div>
				</div>
				<hr>
				<div class="coment-cotent">낙원을 장식하는 천자만홍이 어디 있으며 인생을 풍부하게 하는
					온갖 과실이 어디 있으랴? 이상! 우리의 청춘이 가장 많이 품고 있는 낙원을 장식하는 천자만홍이 어디 있으며 인생을
					풍부하게 하는 온갖 과실이 어디 있으랴?</div>
			</div>
			<div class="contaner">
				<div class="conment-info">
					<div class="coment-proflie">
						<a href="#"><img src="css/image/user.png" id="member-profile"></a>
					</div>
					<div class="coment-nickname">
						못할 바이며
						<div class="coment-row">어쩌고</div>
					</div>
					<div class="hart">하트</div>
				</div>
				<hr>
				<div class="coment-cotent">낙원을 장식하는 천자만홍이 어디 있으며 인생을 풍부하게 하는
					온갖 과실이 어디 있으랴? 이상! 우리의 청춘이 가장 많이 품고 있는 낙원을 장식하는 천자만홍이 어디 있으며 인생을
					풍부하게 하는 온갖 과실이 어디 있으랴?</div>
			</div>
			<div class="pagination-area">
				<ul class="pagination">
					<li><a href="#">&lt;&lt;</a></li>
					<li><a href="#">&lt;</a></li>
					<li><a class="current" href="">1</a></li>
					<li><a href="${contextPath}/coment/list/movieNo=1&cp=2">2</a></li>
					<li><a href="">3</a></li>
					<li><a href="">4</a></li>
					<li><a href="">5</a></li>
					<li><a href="">6</a></li>
					<li><a href="">7</a></li>
					<li><a href="">8</a></li>
					<li><a href="">9</a></li>
					<li><a href="">10</a></li>
					<li><a href="#">&gt;</a></li>
					<li><a href="#">&gt;&gt;</a></li>
				</ul>
			</div>
		</div>
		</div>
		</div>
	</main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>


</body>
</html>
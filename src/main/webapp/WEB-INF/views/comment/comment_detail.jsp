<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="movieTitle" value="${map.movieTitle}"/>
<c:set var="movieTitle" value="${map.pagination}"/>
<c:set var="commentList" value="${map.commentList}"/>




<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/comment_detail.css" type="text/css">
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

					<div class="comment-title">${movieTitle}</div>
				</div>
		</div>
		</header>



		<div class="info">

			<c:choose>

				<c:when test="${empty commentList}">
					<h1>코멘트가 존재하지 않습니다. </h1>
				</c:when>

				<c:otherwise>
					<c:forEach var="comment" items="${commentList}">
						
						<div class="contaner">
							<div class="comment-info">
								<div class="comment-proflie"><a href="#"><img src="css/image/user.png" id="member-profile"></a></div>
								<div class="comment-nickname">${comment.memberNickname}
								<div class="comment-row">${comment.commentDate}</div>
								</div>
								<div class="hart">하트</div>
							</div>
								<hr>
								<div class="comment-cotent">${commnet.commentContent}</div>               
							</div>

					</c:forEach>
				</c:otherwise>

			</c:choose>


			<div class="pagination-area">
				
				<c:set var="url" value="list?type=${param.movieNo}&cp="/>

				<ul class="pagination">
					<li><a href="${url}1">&lt;&lt;</a></li>
					<li><a href="${url}${pagination.prevPage}">&lt;</a></li>
					

					<c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
						<c:choose>
							<c:when test="${i == pagination.currentPage}">
								<li><a class="current" href="">${i}</a></li>
							</c:when>

							<c:otherwise>
								<li><a href="${url}&{i}">${i}</a></li>
							</c:otherwise>
						</c:choose>

					</c:forEach>
					
					
					<li><a href="${url}{patination.nextPage}">&gt;</a></li>
					<li><a href="${url}${pagination.maxPage}">&gt;&gt;</a></li>


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
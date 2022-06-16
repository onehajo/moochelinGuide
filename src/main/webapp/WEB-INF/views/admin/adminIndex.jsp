<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>moochelinGuide</title>

<!-- <link rel="stylesheet" href="resources/css/main-style.css"> -->
<link rel="stylesheet" href="resources/css/adminIndex-style.css">

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

			<div class="dashBoard">
			
				<div class="va">
					<div class="vainner">
						<div>무슐랭 총 영화 :</div>
						<div>작성된 코멘트 :</div>
						
						<div>현재 사용자 :</div>
						<div>어제 가입자 :</div>
						
						<div>어제 문의 :</div>
						<div>미처리 문의 :</div>
					</div>
				</div>
				
				<div class="co">
					<div class="coinner">
						<c:forEach var="info" items="${indexinfo}">
							<div>${info.co} </div>
						</c:forEach>
					</div>
			</div>
			
			</div>


		</section>

	</main>






	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<!-- test -->
	<script src="http://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>

	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

</body>
</html>
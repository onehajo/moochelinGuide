<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>moochelinGuide</title>
	    
	    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

        <link rel="stylesheet" href="${contextPath}/resources/css/allMovie.css">
	    
		<script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
	    <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
	
		
		<!-- google 로그인 관련 -->
		<meta name="google-signin-scope" content="profile email">
    	<meta name="google-signin-client_id" content="263322996104-ijiaiibe7ha6d2g8c7vm0ktdhqlkiq7t.apps.googleusercontent.com">
    	<!-- 이거 이제 인증에 사용안한다함(?) 아래껄로 대체 가능하다고함. -->
    	<!-- <script src="https://apis.google.com/js/platform.js" async defer></script> -->
    	
    	<!-- 클라이언트 라이브러리 -->
    	<script src="https://accounts.google.com/gsi/client" async defer></script>
    
	</head>
	<body>
	        <jsp:include page="/WEB-INF/views/common/header.jsp" />
	
	<main> 
        <section class="content-main">
            <p class="sectionTitle">전체영화 조회</p>

            <fieldset class="field">
            <form action="allMovie" name="selectCategory">
                <select name="category" id="category">
                    <option value="select" >선택해주세요.</option>
                    <option value="new" >최신순</option>
                    <option value="ganada" >가나다순</option>
                    <option value="popular" >인기순</option>
                </select>
            </form>
            </fieldset>
            ${allShow}

            <section class="movie-list-all">

                <c:choose>

                    <c:when test="${empty allShow}">

                        <div><span>영화 리스트 불러오기 오류(값 없음)</span></div>

                    </c:when>

                    <c:otherwise>

                        <ul class="movie-list">
                            <c:forEach var="movieList" items="${allShow}">
                                <li>
                                    <a href="${contextPath}/movie/detail?no=${movieList.movieNo}">
                                        <div class="movie">
                                            <div class="movie-top">
                                                <div class="movie-poster">
                                                    <img src="${movieList.posterImage}">
                                                </div>
                                            </div>
                                            <div class="movie-bottom">
                                                <div class="movie-title">${movieList.movieTitle}</div>
                                                <div class="movie-year-contry">${movieList.releaseYear} ・ ${movieList.country}</div>
                                                <div class="average">
                                                    <span>평균</span>
                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
                                                    <span>${movieList.starRating}</span>
                                                </div>
                                                <div class="showing-info">예매율 ${movieList.ticketing} ・ ${movieList.audience}</div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </c:otherwise>  

                </c:choose>   


                    

            </section>

            
        </section>
    </main>
    
    
    
    
	loginMember : ${sessionScope.loginMember}
    <hr> 세션확인하는 임시 코드        	
    message : ${sessionScope.message} 

       
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />


    <script>
        // 최상위주소
        const contextPath = "${contextPath}";
        // 로그인한 회원번호
        const loginMemberNo = "${loginMember.memberNo}";
    </script>
    
	<!-- test -->    
	<script src="http://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>
    
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/allMovie.js"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

    <script>

        const category = document.getElementById("category");

        category.addEventListener("change",function(){

        document.selectCategory.submit();

            const selected = document.getElementById("selected")

        });

    </script>

</body>
</html>
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
    <link rel="stylesheet" href="${contextPath}/resources/css/searchPerson-style.css">
    
    <script src="https://kit.fontawesome.com/1163d62f29.js" crossorigin="anonymous"></script> <!-- 검색 결과 없는 경우 표시할 아이콘-->
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    
    <main> 
        <section class="content-explain">
            <div>
                <p>"${query}"의 검색결과</p>
            </div>
        </section>
        <section class="sch-menu">
            <ul>
                <li><a href="${contextPath}/search/title?query=${query}">제목</a></li>
                <li><b>인물</b></li>
                <li><a href="${contextPath}/search/user?query=${query}&mode=2">유저</a></li>
            </ul>
        </section>
        <section class="content-main">
            <section class="movie-list-row">

                <!-- 인물 조회결과가 있는 경우 -->
                <c:if test="${!empty personList}">
                    <c:forEach var="person" items="${personList}">
                        <div class="sch-person">
                            <div>
                                <img src="${person.personImage}" class="sch-img-person">
                            </div>
                            <div class="sch-person-info">
                                <div>${person.personName}</div>
                                <div>${person.personJob}</div>
                                <div>
                                    <!-- 영화정보가 1개인 경우 -->
                                    <c:if test="${person.movieList.size()==1}">
                                        <c:forEach var="movie" items="${person.movieList}" begin="0" end="1">
                                            <a href="#">${movie.movieTitle}</a>
                                        </c:forEach>
                                    </c:if>
                                    <!-- 영화정보가 2개이상인 경우 -->
                                    <c:if test="${person.movieList.size()>1}">
                                        <c:forEach var="movie" items="${person.movieList}" begin="0" end="2">
                                            <a href="#">${movie.movieTitle}</a>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>

                <!-- 인물 조회결과가 없는 경우 -->
                <c:if test="${empty personList}">
                    <div id="searchFail">
                        <i class="fa-solid fa-circle-exclamation"></i>
                        <p>검색 결과가 없습니다. 다른 검색어를 입력해보세요.</p>
                    </div>
                </c:if>

            </section>

            <!-- <div class="view-more">
                <button>더보기 ▽ </button>
            </div> -->

        </section>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

</body>
</html>
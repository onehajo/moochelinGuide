<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>왓챠피디아</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/evaluation-style.css">

    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/header.jsp" /> 
    
    <main> 
        <section class="content-main">
            <section class="eva-container">
                <div class="eva-header">
                    <div>
                        <span>5</span>
                    </div>
                    <div>
                        <span>평가만 하는것도 나름 재미있지 않으세요?</span>
                    </div>
                    <div></div>
                </div>
                <div class="eva-main">
                    <ul class="eva-row">
                        <c:if test="${!empty movie1}">
                                <li class="eva-area">
                                    <div>
                                        <img src="${movie1.posterImage}" class="eva-movie-img">
                                    </div>
                                    <div>
                                        <div class="eva-movie-info">
                                            <div><span>${movie1.movieTitle}</span></div>
                                            <div><span>${movie1.releaseYear} ・ ${movie1.country}</span></div>
                                        </div>
                                        <div>
                                            <span class="star" id="star1">
                                                ★★★★★
                                                <span>★★★★★</span>
                                                <input type="range" name="score" oninput="drawStar1(this)" value="1" step="1" min="0" max="10">
                                            </span>
                                        </div>
                                    </div>
                                </li>
                        </c:if>

                        <c:if test="${!empty movie2}">
                            <li class="eva-area">
                                <div>
                                    <img src="${movie2.posterImage}" class="eva-movie-img">
                                </div>
                                <div>
                                    <div class="eva-movie-info">
                                        <div><span>${movie2.movieTitle}</span></div>
                                        <div><span>${movie2.releaseYear} ・ ${movie2.country}</span></div>
                                    </div>
                                    <div>
                                        <span class="star" id="star1">
                                            ★★★★★
                                            <span>★★★★★</span>
                                            <input type="range" name="score" oninput="drawStar2(this)" value="1" step="1" min="0" max="10">
                                        </span>
                                    </div>
                                </div>
                            </li>
                        </c:if>

                        <c:if test="${!empty movie3}">
                            <li class="eva-area">
                                <div>
                                    <img src="${movie3.posterImage}" class="eva-movie-img">
                                </div>
                                <div>
                                    <div class="eva-movie-info">
                                        <div><span>${movie3.movieTitle}</span></div>
                                        <div><span>${movie3.releaseYear} ・ ${movie3.country}</span></div>
                                    </div>
                                    <div>
                                        <span class="star" id="star1">
                                            ★★★★★
                                            <span>★★★★★</span>
                                            <input type="range" name="score" oninput="drawStar3(this)" value="1" step="1" min="0" max="10">
                                        </span>
                                    </div>
                                </div>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </section>
        </section>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <script>
        const movieList = "${movieList}";
        const contextPath = "${contextPath}";
        const loginMemberNo = "${loginMember.memberNo}";
    </script>
    <script src="${contextPath}/resources/js/evaluation.js"></script>

</body>
</html>
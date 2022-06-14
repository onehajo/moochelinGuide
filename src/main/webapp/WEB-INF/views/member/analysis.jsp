<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>취향분석</title>

   
    <!-- 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
    
    <!-- 그래프css  -->
    <link rel="stylesheet" href="${contextPath}/resources/css/analysis.css">

     <!-- 헤더푸터 CSS 연결-->
     <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

     <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
     <link rel="preconnect" href="https://fonts.googleapis.com">
     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
     <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
 
    <style>
        
    </style>    
</head>
<body>
    

    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    
    <div class="container">
        <!-- 취향분석 / 사용자프로필 / 이름 / 평가한 영화수 -->
        <section class="member-info">
            <div class="sec-in-block">
                <header class="sec-header">
                    <h2 class="sec-h2">취향분석</h2>
                </header>
            </div>
            
            <div class="sec-in-block">
                <div class="info-block">
                    <div class="info-profile profile-img-area">
                        <c:if test="${empty loginMember.profileImage}">
                                <img src="${contextPath}/resources/images/user.png" style="width: 50px; height: 50px;">
							    					
						    </c:if>
						
                            <c:if test="${!empty loginMember.profileImage}">
                                <img src="${contextPath}${loginMember.profileImage}" style="width: 50px; height: 50px;">
                            </c:if>
                    </div>
                    <div class="info-profile name">${loginMember.memberName}</div>
                    <div class="info-profile count-star">⭐</div>
                    <div class="info-profile moovie-count">평가한 영화 ${map.analyMovieCount}개</div>
                </div>
            </div>

        </section>
        
        <!-- 평균점수별 메인코멘트 / 서브코멘트 / 그래프 -->
        <section class="graph">
            <div class="sec-in-block">

                <c:choose>
                    <c:when test="${ empty map.analyMovieCount}">
                        <div>"평가한 영화가 없습니다."</div>
                    </c:when>

                    <c:otherwise>
                        <header class="sec-header line-anal">
                            <h1 class="sec-h1">영화에 숨참고 Love Dive</h1>
                        </header>
                        <div>"평점 ${map.allMovieAvg}점의 영화 사랑꾼"</div>

                    </c:otherwise>

                </c:choose>

            </div>

            <!-- 평점 그래프 -->
            <div class="sec-in-block">
                <div class="set-area">
                    <ul class="graph-around">
                        <li><div></div></li>
                        <li><div></div></li>
                        <li><div></div></li>
                        <li><div></div></li>
                        <li><div></div></li>
                        <li><div></div></li>
                        <li><div></div></li>
                        <li><div></div></li>
                        <li><div></div></li>
                        <li><div></div></li>
                    </ul>
                </div>
                <div class="set-area-1">
                    <ul class="around">
                        <li></li>
                        <li>1</li>
                        <li></li>
                        <li>2</li>
                        <li></li>
                        <li>3</li>
                        <li></li>
                        <li>4</li>
                        <li></li>
                        <li>5</li>
                    </ul>
                </div>
            </div>

        </section>

        <!-- 선호하는 국가 / 선호국가 이름 점수  -->
        <section class="preferred-country">
            <div class="sec-in-block">
                <header class="sec-header line-anal">
                    <h2 class="sec-h2">영화 선호 국가</h2>
                </header>
                <div class="moovie-result">
                    <div class="result-text main-text"> ${map.analyMovieCountry}</div>
                    <div class="result-text">총 ${map.likeCountryCount}편 감상</div>
                    <div class="result-text">평균 ${map.likeCountryAvg}점</div>
                </div>
            </div>
        </section>

        <!-- 영화 감상시간 / 시간 & 코멘트   -->
        <section class="time">
            <div class="sec-in-block">
                <header class="sec-header line-anal">
                    <h2 class="sec-h2">모든 영화 감상 시간</h2>
                </header>
                <div class="moovie-result">
                    <div class="result-text main-text"> ${map.myAllRunningTime}</div>
                    <div class="result-text">총 ${map.analyMovieCount}편 감상</div>
                </div>

            </div>
        </section>
    </div>


    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script>
        const temp = '${map.analyAll}';
        const analyAll = JSON.parse(temp);

        for(let i=0.5 ; i<=5 ; i += 0.5){

            for(let a of analyAll){
                if(i == a.starRating){
                    const s = document.querySelector(".graph-around> li:nth-of-type("+(i*2)+") > div");
                    const p = document.querySelector(".graph-around> li:nth-of-type("+(i*2)+") ");

                    s.style.height = a.starRating * a.count  * 10 + 'px';
                    p.style.animation = 'stick 2s 1';
                }
            }

        }
    </script>

    
</body>
</html>
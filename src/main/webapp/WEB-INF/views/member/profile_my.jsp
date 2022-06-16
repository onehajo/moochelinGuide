<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- map 저장된 값 변수에 세팅 -->


<c:set var="evalMovie" value="${map.evalMovie}" />
<c:set var="likeMovie" value="${map.movieList}" />




<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 프로필</title>
    
    <!-- 그래프css  -->
    <link rel="stylesheet" href="${contextPath}/resources/css/analysis.css">

    <!-- 헤더푸터 CSS 연결-->
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style-white.css">
    <!-- 마이페이지 CSS -->
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->

    <!-- 기본헤더 투명헤더에 기본헤더의 값이 있기때문에 활성화X-->
    <!-- <link  id="cssTest1" rel="stylesheet" href="../ksj/css/main-style.css"> -->

    <link rel="stylesheet" href="${contextPath}/resources/css/profile_my.css">

    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">

    
        
</head>
<body>


    <jsp:include page="/WEB-INF/views/common/header.jsp" /> 

    
    <main> 
        <div class="container">
            <section class="page-start">

                <!-- 배경이미지 -->
                <div class="my-background " style=" background-size: cover; background-image : url(${contextPath}${loginMember.profileBackImage})">

                </div>
                <div class="info-1200px">
                    <div class="info-center-flex">
                        <!-- 배경이미지 / 내프로필 / 팔로워/팔로잉 .... 평가한 영화 -->
                        <div class="profile-position profile-img-area">
                            <c:if test="${empty map.member.profileImage}">
                                <img src="${contextPath}/resources/images/user.png" style=" object-fit: cover; width: 100%; height: 100%;">
							    					
						    </c:if>
						
                            <c:if test="${!empty map.member.profileImage}">
                                <img src="${contextPath}${loginMember.profileImage}" style="object-fit: cover; width: 100%; height: 100%;">
                            </c:if>
				
                            <!-- <div class="fa-solid fa-user"></div> -->
                        </div>
                        <div>
                            <div class="profile-name">${map.member.memberName}</div>
                            <div class="follow"><span><a href="/member/mypage">팔로워</a> : <span id="followingCount2">${map.followerCount}</span> </span><span>   |   </span><span><a href="/member/mypage">팔로잉</a>  : <span id="">${map.followingCount}</span></span></div>
                        </div>
                        <c:if test="${ map.member.memberNo != loginMember.memberNo}">


                            <button class="mypage-button"  id="followBtn" >팔로우 취소</button>
                            

                            
                        </c:if>
                        
                        <c:if test="${ map.member.memberNo == loginMember.memberNo}">
                            <div id="searchFail">
                                <div class="mypage-button"> <a href="${contextPath}/member/myPage/mod">마이페이지</a> </div>
                            </div>
                        </c:if>
                        <div class="pick-heart">❤</div>                    
                                                                                                <!-- 카운트 VO따로 안만들고 있는거에다씀. -->
                        <div class="bucket-list"><a href="movie/wish?no=${ map.member.memberNo }">찜한 영화 ${map.likeCount} </a></div>
                        <div class="count-star">⭐</div>
                        <!-- EL문 넣으시오 -->
                        <div class="moovie-analysis"><a href="movie/evaluatedmovie?no=${ map.member.memberNo}"> 평가한 영화 ${map.analyMovieCount}</a></div>
                    </div>
                </div>
            </section>
      
            
            <!-- 내가 평가한 영화 / 내가 찜한 영화 / 취향분석 -->
            <section class="sec-content">
                <div class="info-1200px">    
                        <div class="title-area">
                            <div class="title content-analysis"> 내가 평가한 영화 </div>
                            
                            <c:if test="${ empty evalMovie}">
                                
                            </c:if>
                            <c:if test="${ !empty evalMovie}">
                                <div class="more-view"><a href="movie/evaluatedmovie?no=${ map.member.memberNo}"> +더보기 </a></div>
                            </c:if>
                        </div>

                        
                        <div class="movie-list-all">

                            <c:choose>

                                <c:when test="${ empty evalMovie}">

                                    <div style="  margin-bottom: 50px; "><span>평가한 영화가 없습니다.</span></div>

                                </c:when>

                                <c:otherwise>
                                    <ul>
                                        <!-- 향상된 for문 -->
                                        <c:forEach var="evalList" items="${evalMovie}">
                                                <li>
                                                    <a href="${contextPath}/movie/detail/select?no=${evalList.movieNo}">
                                                        <div class="movie">
                                                            <div class="movie-top">
                                                                <div class="movie-poster">
                                                                    <img src="${evalList.posterImage}">
                                                                </div>
                                                            </div>
                                                            <div class="movie-bottom">
                                                                <div class="movie-title">${evalList.movieTitle}</div>
                                                                <div class="movie-year-contry">${evalList.releaseYear} ・ ${evalList.country}</div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                        </c:forEach>    
                                    </ul>
                                   
                                </c:otherwise>  
                                  
                            </c:choose>    

                        </div>

                        <div class="title-area">
                            <div class="title content-analysis"> 내가 찜한 영화 </div>
                            <c:if test="${ empty likeMovie}">

                            </c:if>
                            <c:if test="${ !empty likeMovie}">
                                <div class="more-view"><a href="movie/wish?no=${ map.member.memberNo }"> +더보기 </a></div>
                            </c:if>
                            
                        </div>

                        
                        <div class="movie-list-all">

                            <c:choose>

                                <c:when test="${ empty likeMovie}">

                                    <div style="  margin-bottom: 50px; "><span>찜한 영화가 없습니다.</span></div>

                                </c:when>

                                <c:otherwise>
                                    
                               
                                    <ul>
                                        <!-- 향상된 for문 -->
                                        <c:forEach var="likeList" items="${likeMovie}">
                                                <li>
                                                    <a href="${contextPath}/movie/detail/select?no=${likeList.movieNo}">
                                                        <div class="movie">
                                                            <div class="movie-top">
                                                                <div class="movie-poster">
                                                                    <img src="${likeList.posterImage}">
                                                                </div>
                                                            </div>
                                                            <div class="movie-bottom">
                                                                <div class="movie-title">${likeList.movieTitle}</div>
                                                                <div class="movie-year-contry">${likeList.releaseYear} ・ ${likeList.country}</div>
                                                            </div>
                                                        </div>
                                                    </a>
                                                </li>
                                        </c:forEach>    
                                    </ul>
                                </c:otherwise>  
                                  
                            </c:choose>    

                        </div>

                      





                            <div>
                                <c:choose>
                                    <c:when test="${ empty map.allMovieAvg}">
                                        <div class="title content-analysisn"> 취향분석 </div>
                                        <div>"평가한 영화가 없습니다."</div>
                                    </c:when>
                                    
                                    <c:otherwise>
                                        <div class="title content-analysisn"> 취향분석 </div>
                                        <div class="more-view anal"> "평점  ${map.allMovieAvg}점의 영화 사랑꾼" </div>
                                    </c:otherwise>
                
                                </c:choose>
                

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
                                    <button type="button" onclick="location.href='${contextPath}/member/profile/analysis?memberNo=${map.member.memberNo}'" class="anal-button" >취향분석 보기</button>
    
                    </div>
    
    
                </section>
            </div>

    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="${contextPath}/resources/js/header_white.js"></script>

    <script>
        const temp = '${map.analyAll}';
        const analyAll = JSON.parse(temp);


        for(let i=0.5 ; i<=5 ; i += 0.5){

            for(let a of analyAll){
                if(i == a.starRating){
                    const s = document.querySelector(".graph-around> li:nth-of-type("+(i*2)+") > div");
                    const p = document.querySelector(".graph-around> li:nth-of-type("+(i*2)+") ");

                    s.style.height =  a.count  * 10 + 10 +'px';
                    p.style.animation = 'stick 2s 1';
                }
            }

        }
    </script>
    

    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    
    <script>
        const contextPath = "${contextPath}";
        const memberNo = "${loginMember.memberNo}";
        const targetNo = "${map.member.memberNo}";
        
        // -> ajax 할 때, memberNo = loginMeberNo / targetNo = member.memberNo / 팔로워의수 
        let followerCount = Number("${map.followerCount}");
    </script>

    <script src="${contextPath}/resources/js/myPage-following2.js"></script>

    <script src="${contextPath}/resources/js/main.js"></script>
    


</body>
</html>
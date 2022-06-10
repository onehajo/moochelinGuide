<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 프로필</title>
    
    <link rel="stylesheet" href="${contextPath}/resources/css/analysis.css">

    <!-- 투명헤더-->
    <link  id="cssTest2" rel="stylesheet" href="${contextPath}/resources/css/header-white.css">



    <!-- 헤더푸터 CSS 연결-->
    <!-- <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css"> -->
    <!-- 마이페이지 CSS -->
    <!-- <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css"> -->
    <!-- 기본헤더 투명헤더에 기본헤더의 값이 있기때문에 활성화X-->
    <!-- <link  id="cssTest1" rel="stylesheet" href="../ksj/css/main-style.css"> -->

    <link rel="stylesheet" href="css/profile_my.css">

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
                <div class="my-background">

                </div>
                <div class="info-1200px">
                    <div class="info-center-flex">
                        <!-- 배경이미지 / 내프로필 / 팔로워/팔로잉 .... 평가한 영화 -->
                        <div class="profile-position profile-img-area">
                            <div class="fa-solid fa-user"></div>
                        </div>
                        <div>
                            <div class="profile-name">김유저</div>
                            <div class="follow"><span>팔로워 : 3</span><span>   |   </span><span>팔로잉 : 3</span></div>
                        </div>
                        <!-- 제가 마이페이지에 a태그 넣어서 깨져버렸어용-->
                        <div class="mypage-button"> <a href="myPage_mod.html">마이페이지</a> </div>
                        <div class="pick-heart">❤</div>
                        <div class="bucket-list">찜한 영화 30</div>
                        <div class="count-star">⭐</div>
                        <div class="moovie-analysis">평가한 영화 533</div>
                    </div>
                </div>
            </section>
            
            <!-- 내가 평가한 영화 / 내가 찜한 영화 / 취향분석 -->
            <section class="sec-content">
                <div class="info-1200px">    
                        <div class="title-area">
                            <div class="title content-analysis"> 내가 평가한 영화 </div>
                            <div class="more-view"><a href="#"> +더보기 </a></div>
                        </div>
                        <div class="movie-list-all">
                            <ul>
                                <li>
                                    <a href="#">
                                        <div class="movie">
                                            <div class="movie-top">
                                                <div class="movie-poster">
                                                    <img src="../images/broker.jpeg" alt="">
                                                </div>
                                            </div>
                                            <div class="movie-bottom">
                                                <div class="movie-title">브로커</div>
                                                <div class="movie-year-contry">2022 ・ 한국</div>
                                                <div class="average">
                                                    <span>평균</span>
                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
                                                    <span>3.8</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
            
                                <li>
                                    <a href="#">
                                        <div class="movie">
                                            <div class="movie-top">
                                                <div class="movie-poster">
                                                    <img src="../images/broker.jpeg" alt="">
                                                </div>
                                            </div>
                                            <div class="movie-bottom">
                                                <div class="movie-title">닥터 스트레인지: 대혼돈의 멀티버스</div>
                                                <div class="movie-year-contry">2022 ・ 미국</div>
                                                <div class="average">
                                                    <span>평균</span>
                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
                                                    <span>3.3</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
            
                                <li>
                                    <a href="#">
                                        <div class="movie">
                                            <div class="movie-top">
                                                <div class="movie-poster">
                                                    <img src="../images/broker.jpeg" alt="">
                                                </div>
                                            </div>
                                            <div class="movie-bottom">
                                                <div class="movie-title">닥터 스트레인지: 대혼돈의 멀티버스</div>
                                                <div class="movie-year-contry">2022 ・ 미국</div>
                                                <div class="average">
                                                    <span>평균</span>
                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
                                                    <span>3.3</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
            
                                <li>
                                    <a href="#">
                                        <div class="movie">
                                            <div class="movie-top">
                                                <div class="movie-poster">
                                                    <img src="../images/VFz7DVf6CB4HlTlfxNx3vw.jpg" alt="">
                                                </div>
                                            </div>
                                            <div class="movie-bottom">
                                                <div class="movie-title">닥터 스트레인지: 대혼돈의 멀티버스</div>
                                                <div class="movie-year-contry">2022 ・ 미국</div>
                                                <div class="average">
                                                    <span>평균</span>
                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
                                                    <span>3.3</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
            
                            </ul>
                        </div>
            
                        <div class="title-area">
                            <div class="title content-analysis"> 내가 찜한 영화 </div>
                            <div class="more-view"><a href="#"> +더보기 </a></div>
                        </div>
                        <div class="movie-list-all">
                            <ul>
                                <li>
                                    <a href="#">
                                        <div class="movie">
                                            <div class="movie-top">
                                                <div class="movie-poster">
                                                    <img src="../images/broker.jpeg" alt="">
                                                </div>
                                            </div>
                                            <div class="movie-bottom">
                                                <div class="movie-title">브로커</div>
                                                <div class="movie-year-contry">2022 ・ 한국</div>
                                                <div class="average">
                                                    <span>평균</span>
                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
                                                    <span>3.8</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
            
                                <li>
                                    <a href="#">
                                        <div class="movie">
                                            <div class="movie-top">
                                                <div class="movie-poster">
                                                    <img src="../images/VFz7DVf6CB4HlTlfxNx3vw.jpg" alt="">
                                                </div>
                                            </div>
                                            <div class="movie-bottom">
                                                <div class="movie-title">닥터 스트레인지: 대혼돈의 멀티버스</div>
                                                <div class="movie-year-contry">2022 ・ 미국</div>
                                                <div class="average">
                                                    <span>평균</span>
                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
                                                    <span>3.3</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
            
                                <li>
                                    <a href="#">
                                        <div class="movie">
                                            <div class="movie-top">
                                                <div class="movie-poster">
                                                    <img src="../images/broker.jpeg" alt="">
                                                </div>
                                            </div>
                                            <div class="movie-bottom">
                                                <div class="movie-title">닥터 스트레인지: 대혼돈의 멀티버스</div>
                                                <div class="movie-year-contry">2022 ・ 미국</div>
                                                <div class="average">
                                                    <span>평균</span>
                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
                                                    <span>3.3</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
            
                                <li>
                                    <a href="#">
                                        <div class="movie">
                                            <div class="movie-top">
                                                <div class="movie-poster">
                                                    <img src="../images/VFz7DVf6CB4HlTlfxNx3vw.jpg" alt="">
                                                </div>
                                            </div>
                                            <div class="movie-bottom">
                                                <div class="movie-title">닥터 스트레인지: 대혼돈의 멀티버스</div>
                                                <div class="movie-year-contry">2022 ・ 미국</div>
                                                <div class="average">
                                                    <span>평균</span>
                                                    <svg width="12" height="10" viewBox="0 0 12 10" xmlns="http://www.w3.org/2000/svg" fill="#555765" class="css-1g90l0x"><path fill-rule="evenodd" clip-rule="evenodd" d="M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z"></path></svg>
                                                    <span>3.3</span>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </li>
            
                            </ul>
                        </div>
            
                        <div>
                                <div class="title content-analysisn"> 취향분석 </div>
                                <div class="more-view anal"> "평점 3.79점의 까탈 영화 사랑꾼" </div>

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
                                 <button class="anal-button">취향분석 보기</button>

                        </div>

                </div>


            </section>
        </div>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    
<script src="/kjy/js/header_white.js"></script>

</body>
</html>
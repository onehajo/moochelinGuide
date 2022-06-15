<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/wish_list.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <header class="main-css">
            <nav>
                <div class="hd-center">
                    <ul>
                        <li class="logo">
                            <a href="../ksj/index.html">
                                <svg id="a" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 203.48 128.31"><defs><style>.b{fill:#392eff;}</style></defs><g><path class="b" d="M.86,.8H13.93l8.04,13.18L30,.8h13.07V38.31h-12.48V19.72l-8.63,13.34h-.21l-8.63-13.34v18.59H.86V.8Z"/><path class="b" d="M0,64.66v-.11c0-11.2,8.73-19.55,19.93-19.55,8.25,0,13.82,4.02,16.98,9.75l-10.34,6.05c-1.39-2.68-3.38-4.55-6.8-4.55-4.23,0-7.02,3.7-7.02,8.2v.11c0,4.88,2.89,8.3,7.02,8.3,3.54,0,5.52-1.93,7.07-4.71l10.34,5.84c-3.16,5.57-8.41,10.13-17.73,10.13-10.39,0-19.45-7.82-19.45-19.45Z"/><path class="b" d="M39.59,45.8h12.54v13.23h11.46v-13.23h12.54v37.5h-12.54v-13.45h-11.46v13.45h-12.54V45.8Z"/><path class="b" d="M80.42,45.8h31.98v10.29h-19.66v3.8h18.32v9.05h-18.32v4.07h19.93v10.29h-32.25V45.8Z"/><path class="b" d="M116.04,45.8h12.54v26.79h17.63v10.71h-30.16V45.8Z"/><path class="b" d="M149.04,45.8h12.54v37.5h-12.54V45.8Z"/><path class="b" d="M165.97,45.8h11.73l13.34,16.55v-16.55h12.43v37.5h-11.14l-13.93-17.3v17.3h-12.43V45.8Z"/><path class="b" d="M0,109.66v-.11c0-11.2,8.84-19.55,20.68-19.55,6.43,0,11.62,2.14,15.7,5.68l-7.02,8.46c-2.46-2.09-5.2-3.27-8.3-3.27-4.88,0-8.41,3.75-8.41,8.84v.11c0,5.3,3.7,8.95,8.95,8.95,2.14,0,3.32-.32,4.29-.86v-3.75h-6.43v-8.04h18.16v17.36c-4.07,3.32-9.75,5.63-16.55,5.63-11.68,0-21.05-7.82-21.05-19.45Z"/><path class="b" d="M40.93,111.48v-20.68h12.75v20.52c0,4.66,2.41,6.64,5.79,6.64s5.79-1.82,5.79-6.38v-20.79h12.75v20.41c0,12.8-7.45,17.84-18.64,17.84s-18.43-5.14-18.43-17.57Z"/><path class="b" d="M82.08,90.8h12.54v37.5h-12.54v-37.5Z"/><path class="b" d="M99.01,90.8h14.36c14.89,0,22.34,7.34,22.34,18.43v.11c0,11.09-7.61,18.96-22.77,18.96h-13.93v-37.5Zm12.54,10.93v15.64h2.09c5.73,0,9.43-2.36,9.43-7.77v-.11c0-5.41-3.7-7.77-9.43-7.77h-2.09Z"/><path class="b" d="M139.13,90.8h31.98v10.29h-19.66v3.8h18.32v9.05h-18.32v4.07h19.93v10.29h-32.25v-37.5Z"/></g><g><g><path class="b" d="M67.02,0c-11.57,0-20.52,8.68-20.52,19.55v.11c0,10.88,8.84,19.45,20.41,19.45s20.52-8.68,20.52-19.55v-.11c0-10.88-8.84-19.45-20.41-19.45Zm-.11,29.66c-5.61,0-10.17-4.55-10.17-10.17s4.55-10.17,10.17-10.17,10.17,4.55,10.17,10.17-4.55,10.17-10.17,10.17Z"/><circle class="b" cx="66.91" cy="19.5" r="4.2"/></g><g><path class="b" d="M110.52,0c-11.57,0-20.52,8.68-20.52,19.55v.11c0,10.88,8.84,19.45,20.41,19.45s20.52-8.68,20.52-19.55v-.11c0-10.88-8.84-19.45-20.41-19.45Zm-.11,29.66c-5.61,0-10.17-4.55-10.17-10.17s4.55-10.17,10.17-10.17,10.17,4.55,10.17,10.17-4.55,10.17-10.17,10.17Z"/><circle class="b" cx="110.41" cy="19.5" r="4.2"/></g></g></svg>
                            </a>
                        </li>
                        <li class="showing"><a href="">박스오피스</a></li>
                        <li class="all"><a href="all_moovie_about.html">전체영화</a></li>
                        <li class="sch">
                            <article class="search-area">
                                <!-- form 내부에 input 태그 값을 서버 또는 페이지로 전달 -->
                                <form action="#" name="search-form">
                    
                                    <!-- form 내부에서 input을 종류별로 묶는 용도로 많이 사용 -->
                                    <fieldset class="hd-fieldset">
                                        <!-- 페이지 확인 위해 a태그 임시로 세팅/디자인 깨짐-->
                                        <a href="../sjh/search_title.html">
                                            <i class="fa-solid fa-magnifying-glass" id="search-btn"></i>
                                        </a>
                                        <input type="search" id="query" autocomplete="off" placeholder="제목, 인물, 유저를 검색해보세요">
    
                                    </fieldset>
                                </form>
                            </article>
                        </li>
                        <li class="login"><a href="../ksj/login.html">로그인</a></li>
                        <li class="signup"><a href="../ksj/signUp.html">회원가입</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <header id="header-2">
            <div class="header-wrap">
                <div class="back"><img src=""></div>
            </div>
        </header>
        <header id="header">
            <div class="header-wrap">
               
                <div class="wish-title">보고싶어요</div>
                <nav class="nav">
        </header>

      
       
        <section class="rating">
            <section class="movie-list">
                <c:forEach var="Movie" items="${selectWishMovie}">

                    <a href="#" class="rating-title">
                        <div class="movie"><img src="${posterImage}" class="img-title"></div>
                        <div style="display:block">${movieTitle}</div> 
                        <span style="font-size: 13px; color:#392eff">${audience}명이 봤어요!</span>
                        <div style="display:block">${releaseYear}・${country} / ${ticketing}</div>
                    </a>
                </c:forEach>
            </section>
    </div>

        <footer>
        <section class="footer-top">지금까지 <span>★ 658,179,744 개</span>의 평가가 쌓였어요.</section>
        <section class="footer-bottom">
            <div>
                <p>서비스 이용약관 | 개인정보 처리방침 | 회사 안내</p>
                <p>고객센터 | cs@moochelin.co.kr, 02-123-4567</p>
                <p>광고 문의 | ad@moochelin.com</p>
                <p>제휴 및 대외 협력 | https://moochelin.team/contact</p>
                <p>주식회사 무슐랭가이드 | 대표 원하조 | 서울특별시 서초구 강남대로 343 신덕빌딩 3층</p>
                <p>사업자 등록 번호 211-88-66013</p>
                <p>MOOCHELIN GUIDE © 2022 All rights reserved.</p>
            </div>
        </section>
    </footer>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


        
</body>
</html>
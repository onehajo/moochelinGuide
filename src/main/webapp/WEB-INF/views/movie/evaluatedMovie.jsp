<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/evaluated.css">
    <link rel="stylesheet" href="../ksj/css/main-style.css">

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <div id="wrapper">
        <jsp:include page="/WEB-INF/views/common/header.jsp" />
        <header id="header-2">
            <div class="header-wrap">
                <div class="back"><img src=""></div>
            </div>
        </header>
        <header id="header">
            <div class="header-wrap">
               
                <div class="coment-title">평가한 작품들</div>
                <nav class="nav">
                    <!-- <div class="nav1">최신순</div><div class="nav2">별점순</div> -->
                </nav>
                </div>
        </header>

      
       
        <section class="rating">
            <section class="movie-list">
                <a href="#" class="rating-title">
                    <div class="movie"><img src="./css/image/99bf6b056d4f594d302031b5f1fc52e6.jpg" class="img-title"></div>
                    <div>영화 제목</div>
                    <div>개봉년도 국가</div>
                    <div class="rating-text">평가 함 4.5★</div>
                </a>
        </section>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="./js/Detail_page.js"></script>
        
</body>
</html>
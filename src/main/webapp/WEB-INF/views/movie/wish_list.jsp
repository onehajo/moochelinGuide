<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="selectWishMovie" value="${map.selectWishMovie}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/wish_lise.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />

    
    <div id="wrapper">
        <div class="wish-title">보고싶어요</div>
                
       
        <section class="rating">
            <section class="movie-list">
                <c:forEach var="Movie" items="${selectWishMovie}">

                    <a href="#" class="rating-title">
                        <div class="movie"><img src="${selectWishMovie.posterImage}" class="img-title"></div>
                        <div style="display:block">${selectWishMovie.movieTitle}</div> 
                        <span style="font-size: 13px; color:#392eff">${selectWishMovie.audience}명이 봤어요!</span>
                        <div style="display:block">${selectWishMovie.releaseYear}・${selectWishMovie.country} / ${selectWishMovie.ticketing}</div>
                    </a>
                </c:forEach>
            </section>
    </div>

        <jsp:include page="/WEB-INF/views/common/footer.jsp" />
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/main.js"></script>

</body>
</html>
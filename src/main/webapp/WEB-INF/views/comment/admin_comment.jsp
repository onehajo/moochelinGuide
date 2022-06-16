<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자_코멘트관리</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/adminIndex-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/adminComment-style.css">

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- sweetalert-->

    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    
    <jsp:include page="/WEB-INF/views/admin/adminHeader.jsp" />
    
    <main> 
        <section class="content-main">

            <!-- 검색 영역 -->
            <div class="search-area">
                <fieldset class="hd-fieldset">
                    <div id="search-btn">
                        <i class="fa-solid fa-magnifying-glass" id="search-icon"></i>
                    </div>
                    <input type="search" name="query" id="query" autocomplete="off" placeholder="리뷰를 관리할 영화명을 입력해주세요.">
                </fieldset>
            </div>

            <!-- 검색 결과 출력-->
            <div class="search-result" id="search-result">
            </div>

            <!-- 특정 영화 코멘트 리스트 출력-->
            <div class="search-comment-result" id="commentResult">
            </div>
            
        </section>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
        const contextPath = "${contextPath}";
    </script>
	<script src="${contextPath}/resources/js/admin_comment.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>

</body>
</html>
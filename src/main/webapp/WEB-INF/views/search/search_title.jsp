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
    <link rel="stylesheet" href="${contextPath}/resources/css/searchTitle-style.css">
    
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
                <li><b>제목</b></li>
                <li><a href="person?query=${query}">인물</a></li>
                <li><a href="user?query=${query}">유저</a></li>
            </ul>
        </section>
        <section class="content-main">
            <section class="movie-list-row">
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
                <a href="#" class="sch-title">
                    <div class="movie"><img src="../images/broker.jpeg" class="sch-img-title"></div>
                    <div>영화 타이틀</div>
                    <div>개봉년도 국가</div>
                    <div>영화</div>
                </a>
            </section>

        </section>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

</body>
</html>
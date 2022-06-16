<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    <!-- 헤더푸터 CSS 연결-->
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/notice.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
    <title>Notice</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <main>
        <jsp:include page="/WEB-INF/views/common/myPage_top.jsp" />
        
        <div class="notice">
            <h2>공지사항</h2>
        <c:forEach var="notice" items="${noticeList}">
            <section class="notice2">
                
                <div class="titleArea"><span id="noticeName">${notice.boardTit}</span><span class="carrotdown">&#8744;</span>
                <p id="date">${notice.createDate}</p></div>
                <span class="noticeContent">
                    <c:if test="${!empty notice.link}">
                        <section id="imageArea"><img src="${contextPath}${notice.link}" id="noticeImage"></section>
                    </c:if>
    <pre id="noticeContent">${notice.content}</pre>
                </span>
            </section>
        </c:forEach>
        </div>
        
    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/notice.js"></script>
</body>
</html>
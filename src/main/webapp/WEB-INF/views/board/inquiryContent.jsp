<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inquiryContent</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    <!-- 헤더푸터 CSS 연결-->
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/inquiryContent.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <main>
        <jsp:include page="/WEB-INF/views/common/myPage_top.jsp" />
        <form action="inquiryContent" method="POST">
        <div class="inquiry">
            <h2 class="content">문의하기</h2>
            <em class="user">${board.memberNm}</em>
            <p class="content">${board.content}</p>
                <c:forEach var="reply" items="${replyList}">
                <em class="user">${reply.memberNm}</em>
                <p class="content">
                    ${reply.content}
                </p>
                </c:forEach>
            <br><br>
            <textarea id="comment" name="comment" cols="30" rows="10" placeholder="댓글 입력"></textarea>
        </div>
        <br>
        <section id="file-upload">
            <label for="uploadfile" id="upload-btn"><span>파일 추가</span> 또는 파일을 여기로 드래그</label>
            <input type="file" id="uploadfile">
        </section>
        
            <section class="regist"><button id="registration">제출</button></section>
            <input type="hidden" name="list" value="${param.list}">
        </form>
    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</body>
</html>
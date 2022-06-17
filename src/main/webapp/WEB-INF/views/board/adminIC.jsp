<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>adminInquiryContent</title>

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->
    <link rel="stylesheet" href="${contextPath}/resources/css/adminIndex-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/adminIC.css">
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>

    <jsp:include page="/WEB-INF/views/admin/adminHeader.jsp" />
    
    <form action="inquiryContent" method="POST">
        <div class="inquiry">
            <h2 class="content">문의하기</h2>
            <em class="user">${board.memberNm}</em>
            <p class="content" style="border-bottom: none;">${board.content}</p>
            <div class="imgArea">
                    <c:if test="${!empty board.imageList}">
                    <div class="img"><img src="${contextPath}${board.imageList[0].imageReName}"></div>
                    </c:if>
            </div>
                <c:forEach var="reply" items="${replyList}">
                    <c:if test="${reply.memberType=='M'}">
                <em class="user">${reply.memberNm}</em>
                    </c:if>
                    <c:if test="${reply.memberType=='A'}">
                <em class="user">관리자</em>
                    </c:if>
                <p class="content">
                    ${reply.content}
                </p>
                </c:forEach>
            <br><br>
            <textarea id="comment" name="comment" cols="30" rows="10" placeholder="댓글 입력"></textarea>
        </div>
        <br>
        
            <section class="regist"><button id="registration">제출</button></section>
            <input type="hidden" name="list" value="${param.list}">
        </form>
    </main>
    
</body>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>inquiryList</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    <!-- 헤더푸터 CSS 연결-->
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/inquiryList.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
   
    <main>
        <jsp:include page="/WEB-INF/views/common/myPage_top.jsp" />

        <div class="inquiry">
            <h2>문의하기</h2>
            <p>문의주신 내용은 고객센터에서 확인 후 영업일 기준 3~7일 이내에 답변 드리도록 하겠습니다.</p>
            <p>* 운영 시간: 평일 (월 ~ 금) 10:00 ~ 18:00</p>
            <table class="inquiry-list">
                <colgroup>
                    <col style="width:30%">
                    <col style="width:25%">
                    <col style="width:25%">
                    <col style="width:25%">
                </colgroup>
                <thead>
                    <tr>
                        <td>제목</td>
                        <td>만든시간</td>
                        <td><a href=""><span class="activity"><button id="activity">마지막 활동</button></span><label id="triangle-down" for="activity">&#x25BC;</label></a></td>
                        <td>상태</td>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${!empty boardList}">
                        <c:forEach var="board" items="${boardList}">
                            <tr>
                                <td><form action="inquiryContent.html"><button class="list-name">${board.boardTit}</button></form></td>
                                <td>${board.msg}</td>
                                <td>${board.msg2}</td>
                                <c:if test="${board.boardSt=='N'}">
                                    <td><span class="accepting">접수중</span></td>
                                </c:if>
                                <c:if test="${board.boardSt=='Y'}">
                                    <td><span class="inqComplete">답변완료</span></td>
                                </c:if>
                                
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
            <form action="inquiryList/inquiryRegist">
                <button id="registration">문의 등록</button>
            </form>

        </div>
        
        
        
   



    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/inquiryList.js"></script>
</body>
</html>
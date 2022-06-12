<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>moochelinGuide</title>

    <script src="https://kit.fontawesome.com/1163d62f29.js" crossorigin="anonymous"></script><!-- 검색 결과 없는 경우 표시할 아이콘-->
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>
    
    
	<div id="reset-pw-box" class="reset-pw-box">
	<img src="">
    <p class="boxTitle">비밀번호 변경</p>
    <!-- 외부 링크만으로 이메일주소 어떻게 받아옴..? -->
    <div class="boxText">${memberEmail} ??회원님의 비밀번호를 다시 설정해주세요. 앞으로 이 비밀번호로 접속하시면 됩니다.</div>
    
    이메일주소를 어떻게 받아오면 좋니...
    <c:if test="${empty memberEmail}">
    	멤버이메일 비어있음. 
    </c:if>
    <c:if test="${!empty memberEmail}">
    	${memberEmail}
    </c:if>
    
    <form action="resetPw" method="post" class="form-css" onsubmit="return resestValidate()">
        <input type="password" placeholder="비밀번호 유효조건 확인하고 넣기" id="inputResetPw" name="inputResetPw">
        <div id="pwfindText"></div>
        <button id="resetBtn" class="btn">확인</button>
    </form>
    
	</div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/"></script>

</body>
</html>
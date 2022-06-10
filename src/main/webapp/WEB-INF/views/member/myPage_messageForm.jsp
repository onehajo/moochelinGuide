<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지-쪽지</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage_message.css">
    <!-- 헤더푸터 CSS 연결-->
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">

</head>
<body>

            <div id="messageContent" class="popup">
                <img src="../images/logo-blue.png" alt="">
                <p class="popupTitle">받은 쪽지<span class="smallText">?</span></p>
                <form class="messageForm-css">
                    <textarea name="" id="" class="textarea-css">쪽지 보낸 내용입니다. 클릭하면 내용 볼수 있음 어쩌고 저쩌고 가나다라 마바사아자 차카카카카메라 라디오레오레오
                    </textarea>
                    <div class="messageBtnBox">
                        <button type="button" onclick="popupSend()">답장</button>
                        <button onclick="deleteMessage()">삭제</button>
                    </div>
                </form>
                <div class="close" onclick="closeMessage()">X</div>
            </div>
			
			
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

    <script>
        const contextPath = "${contextPath}";
        const loginMemberNo = "${loginMember.memberNo}";
    </script>
    <script src="${contextPath}/resources/js/myPage_message.js"></script>
    
</body>
</html>
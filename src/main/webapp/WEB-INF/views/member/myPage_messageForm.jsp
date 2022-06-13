<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지-쪽지</title>
<link rel="stylesheet"
	href="${contextPath}/resources/css/myPage-style.css">
<link rel="stylesheet"
	href="${contextPath}/resources/css/myPage_message.css">
<!-- 헤더푸터 CSS 연결-->
<link rel="stylesheet"
	href="${contextPath}/resources/css/main-style.css">

<script src="https://kit.fontawesome.com/e4f51ae88c.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap"
	rel="stylesheet">

</head>
<body>


	<!-- if(내용보기, 쪽지 보내기)-->

	<!-- 쪽지 팝업 - 내용보기 -->
	<div id="messageContent" class="detailPopupHidden activePblock">
	    <p class="popupTitle">받은 쪽지<span class="smallText"></span></p>
	    <p class="">보낸 사람 : ${messageDetail.memberName}<span class="date">${messageDetail.enrollDate}</span></p>
	    <form class="messageForm-css" action="deleteMessage" method="post">
	        <textarea name="" id="messageC" class="textarea-css" disabled>${messageDetail.messageContent}</textarea>
	        <input type="hidden" name="messageNo" value="${messageDetail.messageNo}">
	        <div class="messageBtnBox">
	            <button type="button" onclick="popupSend()">답장</button>
	            <button id="deleteMessageBtn">삭제</button>
	        </div>
	    </form>
	</div>

	<!-- 쪽지 팝업 - 쪽지보내기 -->
	<div id="messageSend" class="detailPopupHidden">
	    <p class="popupTitle">쪽지 보내기<span class="smallText"></span></p>
	    <p class="">받는 사람 : ${messageDetail.memberName}</p>
	    <form class="messageForm-css" action="send" method="post" onsubmit="return sendValidate()">
	        <textarea name="sendMessageContent" id="messageC" class="textarea-css"></textarea>
	        <div class="messageBtnBox">
	            <button id="sendMessageBtn">보내기</button>
	        </div>
	    </form>
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
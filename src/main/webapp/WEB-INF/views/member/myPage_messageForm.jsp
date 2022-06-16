<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<!-- 스윗얼럿 -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->
    
</head>
<body>


	


	<c:choose>
	
		<c:when test="${type eq 'confirm'}">
		
			<!-- 쪽지 팝업 - 내용보기 -->
			<div id="messageContent" class="detailPopupHidden activePblock">
			    <p class="popupTitle">받은 쪽지<span class="smallText"></span></p>
			    <p class="">보낸 사람 : ${messageDetail.memberName}<span class="date">${messageDetail.enrollDate}</span></p>
			    <form class="messageForm-css formmint2" action="delete" method="post" target="parentWindow" name="deletepop">
			        <textarea name="" id="messageC" class="textarea-css" disabled>${messageDetail.messageContent}</textarea>
			        <div class="messageBtnBox">
			            <a href="detail?type=send&no=${messageDetail.messageNo}&count2=${param.count2}"><button type="button" class="messagePopupBtn transColor">답장</button></a>
			            <input type="hidden" name="messageNo" value="${messageDetail.messageNo}">
			            <button type="submit" id="deleteMessageBtn" class="messagePopupBtn mint mint2">삭제</button>
			        </div>
			    </form>
			</div>
		
		</c:when>
		
		<c:otherwise>
		
			<!-- 쪽지 팝업 - 쪽지보내기 -->
			<div id="messageSend" class="detailPopupHidden activePblock">
			    <p class="popupTitle">쪽지 보내기<span class="smallText"></span></p>
			    <p class="">받는 사람 : ${messageDetail.memberName}${param.name}</p>	
			    <form class="messageForm-css" action="insert" method="post" target="parentWindow" onsubmit="return sendForm()">
			        <textarea name="content" id="messageCsend" class="textarea-css"></textarea>
			        
			        <c:if test="${empty messageDetail.targetNo}">
			        	<input type="hidden" name="targetNo" value="${param.targetNo}">
						<input type="hidden" name="no" value="${param.no}">
			        </c:if>
			        <c:if test="${!empty messageDetail.targetNo}">
			        	<input type="hidden" name="targetNo" value="${messageDetail.targetNo}">
						<input type="hidden" name="no" value="1">
			        </c:if>
			        
			        <div class="messageBtnBox">
			        	<!--onclick="self.close();"-->
			            <button id="sendMessageBtn" class="messagePopupBtn transColor" >보내기</button>
			        </div>
			    </form>
			</div>
				
		</c:otherwise>
		
	</c:choose>




            



    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>


	<script>
        const contextPath = "${contextPath}";
        const loginMemberNo = "${loginMember.memberNo}";
		const count2 = "${param.count2}";
    </script>
	
	<script src="${contextPath}/resources/js/myPage_message2.js"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

</body>
</html>
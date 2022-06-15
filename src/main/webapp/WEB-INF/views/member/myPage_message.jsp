<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
	<!-- 스윗얼럿 -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->
    <style>
        .swal2-title{
            font-size: 20px;
        }
    </style>

</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp" /> 

    <main>
        <jsp:include page="/WEB-INF/views/common/myPage_top.jsp" />
        
        <section class="mypage-content">
        
            <div><h2>쪽지함</h2></div>
            <div class="contain-box">
                <div class="message-container">
                ${messageList}



					<c:choose>

						<%-- 쪽지내역 없는 경우 --%>
						<c:when test="${empty messageList}">
							<div>받은 쪽지가 존재하지 않습니다.</div>
						</c:when>

						<%-- 쪽지내역 존재하는 경우 --%>
						<c:otherwise>
							<c:forEach var="message" items="${messageList}">

								<div class="message-form">

                        			<div class="message-left">
                        				<input type="hidden" name="messageNo" value="${message.messageNo}">
                            			<div class="image-area" style=" background-size: 70px; background-image : url(${contextPath}${message.profileImage})"></div>

                            			<div class="text-area">
                                			<span class="name">${message.memberName}<span class="date">${message.enrollDate}</span></span>
                                			<span class="message"><a href="detail?type=confirm&no=${message.messageNo}" onclick="window.open(this.href, '_blank', 'width=380, height=410, scrollbars=no, top=200, left=400'); return false;">${message.messageContent}</a></span>
                            			</div>
                        			</div>
                        			<div class="message-right-btns">
                            			<a href="detail?type=send&no=${message.messageNo}" onclick="window.open(this.href, '_blank', 'width=380, height=410, scrollbars=no, top=200, left=400'); return false;" id="sendMessagePop"><button type="button">답장</button></a>
                            			<form style="display:inline-block;" action="delete" method="post"><input type="hidden" name="messageNo" value="${message.messageNo}"><button>쪽지삭제</button></form>
                        			</div>
                    			</div>
                    			
							</c:forEach>
						</c:otherwise>

					</c:choose>




				</div>

			</div>

			<!-- 쪽지 팝업 내용보기 -->
<!-- 			<div id="messageContent" class="popup">
				<img src="../images/logo-blue.png" alt="">
				<p class="popupTitle">
					받은 쪽지<span class="smallText">?</span>
				</p>
				<form class="messageForm-css">
					<textarea name="" id="" class="textarea-css">쪽지 보낸 내용입니다. 클릭하면 내용 볼수 있음 어쩌고 저쩌고 가나다라 마바사아자 차카카카카메라 라디오레오레오
                    </textarea>
					<div class="messageBtnBox">
						<button type="button" onclick="popupSend()">답장</button>
						<button onclick="deleteMessage()">삭제</button>
					</div>
				</form>
				<div class="close" onclick="closeMessage()">X</div>
			</div> -->

			<!-- 쪽지 팝업 보내기 -->
<!-- 			<div id="messageSend" class="popup">
				<img src="../images/logo-blue.png" alt="">
				<p class="popupTitle">쪽지 보내기</p>
				<form class="messageForm-css">
					<textarea name="" id="" class="textarea-css"
						placeholder="내용을 입력해주세요.(200자)"></textarea>
					<div class="messageBtnBox">
						<button class="sendBtn">전송</button>
					</div>
				</form>
				<div class="close" onclick="closeMessage()">X</div>
			</div> -->

		</section>


	</main>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>

	<script>
        const contextPath = "${contextPath}";
        const loginMemberNo = "${loginMember.memberNo}";
    </script>
	<script src="${contextPath}/resources/js/myPage_message.js"></script>

</body>
</html>
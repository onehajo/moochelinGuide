<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지-탈퇴하기</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPageSecession-style.css">
    <!-- 헤더푸터 CSS 연결-->
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">

</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp" /> 

    <main>
        <section class="content-explain">
                <div class="page-area">
                    <div class="page mypage">마이페이지</div>
                    <div class="page logout"><a href="#">로그아웃</a></div>

                </div>
        </section>

        <nav  class="nav-area">
            <ul class="nav-ul">
                <li><a href="../kjy/myPage_mod.html">회원정보수정</a></li>
                <li><a href="#">비밀번호 변경</a></li>
                <li><a href="myPage_follower.html">팔로워 목록</a></li>
                <li><a href="myPage_following.html">팔로잉 목록</a></li>
                <li><a href="../ksj/myPage_message.html">쪽지</a></li>
                <li><a href="../swy/inquiryList.html">문의하기</a></li>
                <li><a href="#">공지사항</a></li>
                <li class="member-drop"><a  href="myPage_secession.html">탈퇴하기</a></li>
            </ul>
        </nav>
        
        <section class="mypage-content" id="secession-content">
            <section class="secession-container">
                <div>
                    <img src="${contextPath}/resources/images/moo_logo_full_bm.png" class="secession-logo">
                </div>
                <div>
                    <span>정말 탈퇴하시겠습니까 ?</span>
                </div>
                <form action="secession" method="POST">
                    <div>
                        <input type="password" name="memberPw" placeholder="현재 비밀번호를 입력해주세요." value="${loginMember.memberNo}">
                        <span> * 비밀번호가 일치하지 않습니다. </span>
                    </div>
                    <div>
                        <button>탈퇴하기</button>
                       <!--  <button onclick = "location.href = 'myPage_secessionConfirm.html'">탈퇴하기</button> -->
                    </div>
                </form>

            </section>
        </section>

        <!-- 탈퇴 팝업시 검은 배경 화면 -->
        

    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>
    
</body>
</html>
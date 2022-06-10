<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- common에 위치할 것. -->

<section class="content-explain">
    <div class="page-area">
        <div class="page mypage">마이페이지</div>
        <div class="page logout"><a href="#" id>로그아웃</a></div>

    </div>
</section>

<nav  class="nav-area">
    <ul class="nav-ul">
        <li><a href="${contextPath}/member/myPage/mod">회원정보수정</a></li>
        <li><a href="${contextPath}/member/myPage/changePw">비밀번호 변경</a></li>
        <li><a href="${contextPath}/member/myPage/follow?mode=1&memberNo=${loginMember.memberNo}">팔로워 목록</a></li>
        <li><a href="${contextPath}/member/myPage/follow?mode=2&memberNo=${loginMember.memberNo}">팔로잉 목록</a></li>
        <li><a href="../ksj/myPage_message.html">쪽지</a></li>
        <li><a href="../swy/inquiryList.html">문의하기</a></li>
        <li><a href="#">공지사항</a></li>
        <li class="member-drop"><a  href="${contextPath}/member/myPage/secession/do">탈퇴하기</a></li>
    </ul>
</nav>
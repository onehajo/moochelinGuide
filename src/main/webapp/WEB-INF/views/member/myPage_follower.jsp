<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>moochelinGuide</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/myPageFollow-style.css">
    <!-- 헤더푸터 CSS 연결-->
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">

    <!-- 스윗얼럿 -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->

    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">

</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp" /> 
    
    <main>

        <jsp:include page="/WEB-INF/views/common/myPage_top.jsp"/>
        
        <section class="mypage-content" id="follower-content">
            <section class="follower-container">
                <div class="follower-title">
                    <span>팔로워 목록</span>
                </div>
                <div class="follower">
                    <ul class="follower-row">

                        <c:if test="${!empty fList}">
                            <c:forEach var="f" items="${fList}">
                                <li class="list">
                                    <div class="follower-img">
                                        <a href="${contextPath}/member/profile/my?memberNo=${f.memberNo}">
                                            <!-- 프로필 경로 없는 경우-->
                                            <c:if test="${ empty f.profileImage}"> 
                                                <img src="${contextPath}/resources/images/user.png" class="profile-img">
                                            </c:if>
                                            <!-- 변경 이미지 -->
                                            <c:if test="${ !empty f.profileImage}"> 
                                                <img src="${contextPath}${f.profileImage}"  class="profile-img">
                                            </c:if>
                                        </a>
                                    </div>
                                    <div class="follower-info">
                                        <span>${f.memberName}</span>
                                        <span>평가한 영화 수 : ${f.evaluationCount}</span>
                                    </div>
                                    <div class="userMessage">
                                        <a href="${contextPath}/member/myPage/message/detail?type=send&no=-1&targetNo=${f.memberNo}&count2=${fn:length(fList)}" onclick="window.open(this.href, '_blank', 'width=380, height=410, scrollbars=no, top=200, left=400'); return false;">
                                            <button type="button" class="userMessageBtn" >쪽지</button>
                                        </a>
                                    </div>
                                    <div class="userDelete">
                                        <input type="hidden" class="memberNo" value="${f.memberNo}">
                                        <input type="hidden" class="targetNo" value="${f.targetNo}">
                                        <button type="button" class="userDeleteBtn">삭제</button>
                                    </div>
                                </li>
                            </c:forEach>
                        </c:if>

                        <c:if test="${empty fList}">
                            <div id="searchFail">
                                <p> 팔로워 </p>
                                <p> 회원님을 팔로우하는 모든 사람들이 여기에 표시됩니다. </p>
                            </div>
                        </c:if>

                    </ul>

                </div>

            </section>

        </section>

    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/main.js"></script>   
    
    <script>
        const fCount = "${fn:length(fList)}";
        const contextPath = "${contextPath}";
    </script>

    <script src="${contextPath}/resources/js/myPage-follower.js"></script>
    <script src="${contextPath}/resources/js/main.js"></script>
    
</body>
</html>
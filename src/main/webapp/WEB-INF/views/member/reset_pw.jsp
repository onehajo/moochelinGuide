<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>moochelinGuide</title>

    <link rel="stylesheet" href="resources/css/main-style.css">

    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->

    <script src="https://kit.fontawesome.com/1163d62f29.js" crossorigin="anonymous"></script><!-- 검색 결과 없는 경우 표시할 아이콘-->
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">

    <style>

    *{
        box-sizing: border-box;
        list-style: none;
        text-decoration: none;
        font-family: 'Noto Sans KR', sans-serif;
        color : black;
    }

    /* 비밀번호 리셋화면 */
    .boxWrapper{
        width: 100%;
        height: 100%;
        padding-top: 200px;
    }
    .reset-pw-box{
        background: rgb(255, 255, 255);
        width: 380px;
        border: 1px solid rgb(215, 215, 215);
        border-radius: 6px;
        padding: 20px;
        margin-left: auto;
        margin-right: auto;
    }
    .reset-pw-box > img{
        margin: 20px auto 30px 70px;
    }
    .boxText{
        padding-top: 10px;
    }



    .form-css{
    margin-top: 20px;
    }
    .form-css > input {
        width: 340px;
        height: 40px;
        margin-top: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        padding-left: 10px;
        outline: 0;
    }
    .form-css > div{
    padding-left: 10px;
    font-size: 13px;
    color: red;
    }
    .btn{
        width: 340px;
        height: 40px;
        background-color: #392eff;
        border: none;
        color: #fff;
        border-radius: 4px;
        font-size: 18px;
        margin-top: 10px;
        cursor: pointer;
    }


    </style>

</head>
<body style="background-color:rgb(248 248 248);">
    
    <section class="boxWrapper">
        <div class="reset-pw-box">
        <img src="${contextPath}/resources/images/logo-blue.png" width="200px"><br>
        <div class="popupTitle">비밀번호 변경</div>

        
        <c:if test="${empty memberEmail}">
            유효하지 않은 페이지입니다.
        </c:if>
        <c:if test="${!empty memberEmail}">
            <div class="boxText">${memberEmail} 회원님의 비밀번호를 다시 설정해주세요. 앞으로 이 비밀번호로 접속하시면 됩니다.</div>
            
            <form action="do" method="post" class="form-css" onsubmit="return resestValidate()">
                <input type="password" placeholder="6자리 이상 30자리 이하로 작성해주세요." id="inputResetPw" name="inputResetPw">
                <input type="hidden" name="memberEmail" value="${memberEmail}">
                <div id="pwComment"></div>
                <button id="resetBtn" class="btn">확인</button>
            </form>
        </c:if>
            
        </div>
    </section>

    <%-- session에 message 속성이 존재하는 경우 alert창으로 해당 내용을 출력 --%>
    <c:if test="${ !empty sessionScope.message }">
        <script>
            alert("${message}");
            // EL 작성 시 scope를 지정하지 않으면
            // page -> request -> session -> application 순서로 검색하여
            // 일치하는 속성이 있으면 출력
        </script>

        <%-- message 1회 출력 후 session에서 제거 --%>
        <c:remove var="message" scope="session" />
    </c:if>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

    <script src="${contextPath}/resources/js/resetPw.js"></script>

</body>
</html>
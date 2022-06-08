<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지-회원정보수정</title>
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>

    <!-- 헤더푸터 CSS 연결-->
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <!-- 마이페이지 CSS -->
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">

</head>
<body>
    <!-- member 폴더에 넣기 -->


    <jsp:include page="/WEB-INF/views/common/header.jsp" /> 



    <main>
        
        <jsp:include page="/WEB-INF/views/common/myPage_top.jsp"/>

        <section class="mypage-content">
            <div><h2>회원정보 수정</h2></div>
            
            <form action="#" method="post" name="myPage-form">
                
                <div class="myPage-row">
                    <label>이메일</label>
                    <input type="text" name="memberEmail" placeholder="로그인@이메일.com" maxlength="10" disabled>
                </div>
                <span class="myPage emailMessage">*이메일(아이디)는 수정 불가합니다.</span>
                
                
                <div class="myPage-row">
                    <label>이름</label>
                    <input type="text" name="memberName" placeholder="회원이름" maxlength="11">
                </div>
                <span class="myPage Name">*필수 입력사항입니다.</span>

                <div class="myPage-row">
                    <label>생년월일</label>
                    <input type="text" name="memberBirth" placeholder="YYYY-MM-DD" maxlength="11">
                </div>
                <span class="myPage Name">* 년, 월, 일 순서로 기입해주세요.</span>


                <span>프로필 이미지</span>
                <div class="myPage-row  input-none">
                    <div class="profile-image-area">
                        <img  src="../images/logo-blue.png" id="profile-image">
                    </div> 
                    
                    <div class="button img">
                        <label for="chooseFile"> 이미지 변경 </label>
                    </div>
                    <input type="file" id="input-image" name="imgFile" accept="image/*"   >
                    <button id="save-img">변경 저장</button>
                    <div class="button img">
                        <span id="delete-image"> 이미지 삭제 </span>
                    </div>
                </div>


                <span>배경 이미지</span>
                <div class="myPage-row input-none">

                    <div class="profile-image-area">
                        <img src="../images/logo-blue.png" id="back-ground">
                    </div>

                    <div class="button img">
                        <label for="backgroundFile"> 이미지 변경 </label>
                    </div>
                    <input type="file" id="input-background" name="backgroundFile" accept="image/*"  >
                    <button id="save-background">변경 저장</button>
                    <div class="button img">
                        <span id="delete-baground"> 이미지 삭제 </span>
                    </div>
                </div>
                
                <button id="complete">수정하기</button>

            </form>
            
        </section>



    </main>

    
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    
</body>
</html>
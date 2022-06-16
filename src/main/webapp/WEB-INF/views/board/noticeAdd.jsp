<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>adminNotice</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/adminIndex-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/noticeAdd.css">
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>

    <jsp:include page="/WEB-INF/views/admin/adminHeader.jsp" />
    
    <main>
        <div class="notice">
            <h2>공지사항 수정</h2>
            <div class="notice2">
                <form action="noticeRegist" enctype="multipart/form-data"
                method="POST" id="registBtn" accept="image/*"
                onsubmit="return registValidate()">
                <input type="text" class="noticebox" name="title" placeholder="제목을 입력해주세요"><br>
                <input id="imageFile" type="file" name="0" accept="image/*"><label for="imageFile"><p id="imageFile2">이미지 첨부</p></label>
                <div class="imgArea">
					<div class="img"><img class="preview">
						<span class="delete-Img">&times;</span>
                    </div>
                    </div>
                <input type="text" id="noticeContent" name="content" placeholder="내용을 입력해주세요">
                    <button id="registration">등록하기</button>
                </form>
            </div>
        </div>
    </main>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
        <script src="${contextPath}/resources/js/noticeAdd.js"></script>
    
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/adminIndex-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/adminIL.css">
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<body>

    <jsp:include page="/WEB-INF/views/admin/adminHeader.jsp" />
    
    <main>
        <div class="inquiry">
            <h2>문의하기</h2>
            <p>문의주신 내용은 고객센터에서 확인 후 영업일 기준 3~7일 이내에 답변 드리도록 하겠습니다.</p>
            <p>* 운영 시간: 평일 (월 ~ 금) 10:00 ~ 18:00</p>
            <table class="inquiry-list">
                <colgroup>
                    <col style="width:30%">
                    <col style="width:25%">
                    <col style="width:25%">
                    <col style="width:25%">
                </colgroup>
                <c:if test="${empty boardList}">
                    <section class="noneList">등록되어 있는 문의내역이 없습니다.</section>
                </c:if>
                <c:if test="${!empty boardList}">
                <thead>
                    <tr>
                        <td>제목</td>
                        <td>작성자</td>
                        <c:if test="${array==1}">
                            <td id="array1"><a href="inquiryList?array=2"><span class="activity"><button id="activity">마지막 활동</button></span><label class="triangle-down" for="activity">&#x25BC;</label></a></td>
                        </c:if>
                        <c:if test="${array==2}">
                            <td id="array1"><a href="inquiryList?array=1"><span class="activity"><button id="activity">마지막 활동</button></span><label class="triangle-down" for="activity"></label>&#9650;</a></td>
                        </c:if>
                        <c:if test="${array==5}">
                            <td id="array1"><a href="inquiryList?array=1"><span class="activity"><button id="activity">마지막 활동</button></span><label class="triangle-down" for="activity">&#x25BC;</label></a></td>
                        </c:if>
                        <c:if test="${array==6}">
                            <td id="array1"><a href="inquiryList?array=1"><span class="activity"><button id="activity">마지막 활동</button></span><label class="triangle-down" for="activity">&#x25BC;</label></a></td>
                        </c:if>
                        <td><div class="selectBox2 ">
                            <section class="labelArea"><button class="label">상태 </button><span class="triangle-down">&#x25BC;</span></section>
                            <ul class="optionList">
                              <li class="optionItem"><a href="inquiryList?array=5">접수중 순</a></li>
                              <li class="optionItem"><a href="inquiryList?array=6">답변완료 순</a></li>
                            </ul>
                          </div>
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="board" items="${boardList}">
                        <tr>
                            <!-- <td><form action="inquiryList/inquiryContent?list=${board.boardNo}" method="GET"><button class="list-name">${board.boardTit}</button></form></td> -->
                            <td><a href="inquiryList/inquiryContent?list=${board.boardNo}"><button class="list-name">${board.boardTit}</button></a></td>
                            <td>${board.memberNm}</td>
                            <td>${board.msg2}</td>
                            <c:if test="${board.boardCode=='99'}">
                                <td><span class="accepting">접수중</span></td>
                            </c:if>
                            <c:if test="${board.boardCode=='98'}">
                                <td><span class="inqComplete">답변완료</span></td>
                            </c:if>
                            
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
            </table>
            <div class="contentArea">
                <c:set var="url" value="inquiryList?array=${param.array}&cp="/>
                    <section class="listArea">
                            <span><a href="${url}${pagination.prevPage}">&lt;</a></span>
                            <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}" step="1">
                                <c:choose>
                                    <c:when test="${i==pagination.currentPage}">
                                        <span style="background-color: #392eff;" class="listNumber"><a href="${url}${i}" style="color: white;">${i}</a></span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="listNumber"><a href="${url}${i}">${i}</a></span>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <span><a href="${url}${pagination.nextPage}">&gt;</a></span>
                    </section> 
            </div>
        </div>        
    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
        <script src="${contextPath}/resources/js/adminIL.js"></script>
    
</body>
</html>
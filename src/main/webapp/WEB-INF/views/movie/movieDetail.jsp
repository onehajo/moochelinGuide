<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="detail" value="${map.detail}"/>
<c:set var="commentList" value="${map.commentList}"/>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detail page</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/myPage-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/Detail_page.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/Detail_ev.css">

    <!-- 헤더푸터 CSS 연결-->
    <link rel="stylesheet" href="${contextPath}/resources/css/main-style-white.css">
    
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script><!-- sweetalert-->
    <script src="https://kit.fontawesome.com/e4f51ae88c.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gowun+Batang&family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap" rel="stylesheet">
</head>
<dody>


    <div id="wrapper">
        


    <jsp:include page="/WEB-INF/views/common/header.jsp" /> 


        <div class="backrel">
            <div class="bakcground" style="background-image: url(${detail.detailImage});"></div>
        </div>

        <div class="content-wrap">
            <div class="info-head">
                <div class="info-img">
                    <img src="${detail.posterImage}">
                </div>
                <div class="info-text" style="width: 550px;">
                    <div class="info-title">${detail.movieTitle}</div>
                    <hr style="border: 1px solid #ccc">
                    <div class="info-date">${detail.releaseYear}・${detail.country}</div>
                    <hr style="border: 1px solid #ccc">
                    <div class="info-point">${detail.starRating}</div>
                    <hr style="border: 1px solid #ccc">
                    <div class="starpoint_wrap">
                        <div class="starpoint_box">
                          <label for="starpoint_1" class="label_star" id="star05" title="0.5"><span class="blind">0.5</span></label>
                          <label for="starpoint_2" class="label_star" id="star10" title="1"><span class="blind">1</span></label>
                          <label for="starpoint_3" class="label_star" id="star15" title="1.5"><span class="blind">1.5</span></label>
                          <label for="starpoint_4" class="label_star" id="star20" title="2"><span class="blind">2</span></label>
                          <label for="starpoint_5" class="label_star" id="star25" title="2.5"><span class="blind">2.5</span></label>
                          <label for="starpoint_6" class="label_star" id="star30" title="3"><span class="blind">3</span></label>
                          <label for="starpoint_7" class="label_star" id="star35" title="3.5"><span class="blind">3.5</span></label>
                          <label for="starpoint_8" class="label_star" id="star40" title="4"><span class="blind">4</span></label>
                          <label for="starpoint_9" class="label_star"id="star45" title="4.5"><span class="blind">4.5</span></label>
                          <label for="starpoint_10" class="label_star" id="star50" title="5"><span class="blind">5</span></label>
                          <input type="radio" name="starpoint" id="starpoint_1" class="star_radio">
                          <input type="radio" name="starpoint" id="starpoint_2" class="star_radio">
                          <input type="radio" name="starpoint" id="starpoint_3" class="star_radio">
                          <input type="radio" name="starpoint" id="starpoint_4" class="star_radio">
                          <input type="radio" name="starpoint" id="starpoint_5" class="star_radio">
                          <input type="radio" name="starpoint" id="starpoint_6" class="star_radio">
                          <input type="radio" name="starpoint" id="starpoint_7" class="star_radio">
                          <input type="radio" name="starpoint" id="starpoint_8" class="star_radio">
                          <input type="radio" name="starpoint" id="starpoint_9" class="star_radio">
                          <input type="radio" name="starpoint" id="starpoint_10" class="star_radio">
                          <span class="starpoint_bg"></span>
                        </div>
                      </div>
                    <div style="display: inline-block;">
                        <button id="wish-add"><span id="wish-add" style="font-size: 16px;">+</span>보고 싶어요</button>
                    </div>
                    <div style="display: inline-block;">
                        <img style="width: 16px;" src="${contextPath}/resources/images/write_icon.png"><button id="btn-modal">코멘트</button>
                    </div>
                    <input id="inputst"tyep="number" style="display:block; border:none;" value="">
                </div>
            </div>
            <div class="info">
                <div class="synopsis">
                    <div class="contaner">
                       <div class="title">시놉시스</div>
                       <hr/>
                       <div id="content">
                             ${detail.synopsis}
                        </div>
                   </div>
                </div>

                <div class="production">
                    <div class="contaner">
                        <div class="title">출연/제작</div>
                        <div class="production-box">
                            <ul class="left">
                               <li>감독</li>
                               <li>극본</li>
                               <li>주연</li>
                               <li>주연</li>
                            </ul>
                            <ul class="right">
                               <li>감독</li>
                               <li>극본</li>
                               <li>주연</li>
                               <li>주연</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="contaner">
                    <div class="starpoint">별점 그래프</div>
                    <div class="pointbar"></div>
                    <div class="coment-title">코멘트</div>
                    <section class="coment-list">
                    <c:choose>

                        <c:when test="${empty commentList}">
                                <h1>코멘트가 존재하지 않습니다. </h1>
                        </c:when>
            
                        <c:otherwise>
                            <c:forEach var="comment" items="${commentList}" begin="0" end="2" step="1">
                                <div class="coment">
                            <div class="conment-info">
                                <div class="coment-proflie"><a href="#"><img src="${comment.profileImage}" id="member-profile"></a></div>
                                <div class="coment-nickname">${comment.memberNickname}
                                    <div class="coment-row">${comment.commentDate}</div>
                                </div>
                                <div class="hart">하트</div>
                                </div>
                                <div class="coment-cotent"><a href="comment/list&no=${detail.movieNo}"> ${comment.commentContent}<a></div>                       
                                </div>
                            </c:forEach>
			        	</c:otherwise>

			         </c:choose>

                           
                     </section>
                </div>
            </div>
        </div>
        <form>
            <div id="modal" class="modal-overlay">
                <div class="modal-window">
                    <div class="title" style="font-size: 25px; color: black;">
                        ${detail.movieTitle}
                    </div>
                    <div class="close-area">X</div>
                    <div class="content">
                        <textarea id="comment-write" class="coment-write" style="width: 100%; height: 400px;" placeholder="이 작품에 대한 생각을 마음껏 표현해주세요.";></textarea>
                        <!-- <input type="checkbox"><p id="spo" style="display: inline-block ; color: #392eff;">내용 숨기기</p> -->
                        <button type="button" id="cm-save-btn" style="margin-left: 300px;">저장</button>
                    </div>
                </div>
            </div>
        </form>

        <footer>
            <section class="footer-top">지금까지 <span>★ 658,179,744 개</span>의 평가가 쌓였어요.</section>
            <section class="footer-bottom">
                <div>
                    <p>서비스 이용약관 | 개인정보 처리방침 | 회사 안내</p>
                    <p>고객센터 | cs@moochelin.co.kr, 02-123-4567</p>
                    <p>광고 문의 | ad@moochelin.com</p>
                    <p>제휴 및 대외 협력 | https://moochelin.team/contact</p>
                    <p>주식회사 무슐랭가이드 | 대표 원하조 | 서울특별시 서초구 강남대로 343 신덕빌딩 3층</p>
                    <p>사업자 등록 번호 211-88-66013</p>
                    <p>MOOCHELIN GUIDE © 2022 All rights reserved.</p>
                </div>
            </section>
        </footer>
 </div>   
        <script>
            const contextPath = "${contextPath}"

            const movieNo = "${param.no}"

            const loginMemberNo = "${loginMember.memberNo}"
        </script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="${contextPath}/resources/js/evaluation.js"></script>
        <script src="${contextPath}/resources/js/Detail_page.js"></script>
        <script src="${contextPath}/resources/js/header_white.js"></script>
        <script src="${contextPath}/resources/js/main.js"></script>   
</body>
</html>
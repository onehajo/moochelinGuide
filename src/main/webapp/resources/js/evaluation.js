const star = document.getElementsByClassName("star");

function drawStar1(target){
  star[0].firstElementChild.style.width = target.value*10+"%";
}

function drawStar2(target){
  star[1].firstElementChild.style.width = target.value*10+"%";
}

function drawStar3(target){
  star[2].firstElementChild.style.width = target.value*10+"%";
}


// 한 개 단독 평가일 때
// function drawStar(target){
//   document.getElementById("두번째spqn태그선택자").style.width = target.value*10+"%";
// };


// 점수를 입력하는 input태그
const score = document.getElementsByName("score");

// movieList의 movie도 보내야돼.... ㅠㅠ 향상된 for문 어디에

// input태그에 value가 입력됐을때 submit
for(let movie of movieList){
  for(let i=0;i<score.length;i++){
    star[i].addEventListener("change",function(){
      $.ajax({
        url : contextPath+"/member/evaluation",
        data : {"score" : score[i].value,
                "memberNo" : loginMemberNo,
                "movieNo" : movie.movieNo},
        type : "POST",
        success : function(result){
          if(result>0){
            alert("전송완")
          }else{
            alert("평가 실패")
          }
        },
        error : function(req, status, error){
          console.log("점수 전송 중 오류 발생");
          console.log(req.responseText);
  
        }
      });
    });
  }
}

// 점수를 입력하는 input태그
const score = document.getElementsByName("score");

// 별
const star = document.getElementsByClassName("star");

// 클릭여부 확인할 객체 생성
const checkClick = {
  "score0" : false,
  "score1" : false,
  "score2" : false 
}

function drawStar0(target){

  if(checkClick.score0 == false){
    star[0].firstElementChild.style.width = target.value*10+"%";
    checkClick.score0 = true;
  }else{
    target.value = 0;
    star[0].firstElementChild.style.width = "0%"
    checkClick.score0 = false;
  }

}

function drawStar1(target){

  if(checkClick.score1 == false){
    star[1].firstElementChild.style.width = target.value*10+"%";
    checkClick.score1 = true;
  }else{
    target.value = 0;
    star[1].firstElementChild.style.width = "0%"
    checkClick.score1 = false;
  }

}

function drawStar2(target){
  
  if(checkClick.score2 == false){
    star[2].firstElementChild.style.width = target.value*10+"%";
    checkClick.score2 = true;
  }else{
    target.value = 0;
    star[2].firstElementChild.style.width = "0%"
    checkClick.score2 = false;
  }

}

// 한 개 단독 평가일 때
// function drawStar(target){
//   document.getElementById("두번째spqn태그선택자").style.width = target.value*10+"%";
// };

const evaCount = document.getElementById("eva-count");

for(let i=0; i<score.length; i++){

  star[i].addEventListener("click",function(){

    if(Object.values(checkClick)[i]==true){

      $.ajax({ // 평가한 경우 (INSERT OR UPDATE)
        url : contextPath+"/member/evaluation",
        data : {"score" : score[i].value,
                "memberNo" : loginMemberNo,
                "movieNo" : eval("movie"+i),
                "mode" : 1},
        type : "POST",
        success : function(result){
          if(result>0){
            count++;
            evaCount.innerText = count;
            console.log("평가 전송 성공");
          }else{
            console.log("평가 전송 실패");
          }
        },
        error : function(req, status, error){
          console.log("점수 전송 중 오류 발생");
          console.log(req.responseText);
        }
      });

    }else{ // 평가 취소하는 경우 (DELETE)

      $.ajax({ // 평가한 경우 (INSERT OR UPDATE)
        url : contextPath+"/member/evaluation",
        data : {"score" : score[i].value,
                "memberNo" : loginMemberNo,
                "movieNo" : eval("movie"+i),
                "mode" : 2},
        type : "POST",
        success : function(result){
          if(result>0){
            console.log("평가 취소 완료");
            count--;
            evaCount.innerText = count;
          }else{
            console.log("평가 취소 실패");
          }
        },
        error : function(req, status, error){
          console.log("점수 전송 중 오류 발생");
          console.log(req.responseText);
        }
      });

    }
  });
}
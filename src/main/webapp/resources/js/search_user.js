const followBtn = document.getElementsByClassName("followBtn");
const memberNo = document.getElementsByClassName("memberNo");
const targetNo = document.getElementsByClassName("targetNo");

// 클릭여부 확인하는 배열 생성
const checkClick = [];

// 팔로우 / 언팔로우
for(let i = 0; i<tCount; i++){

    checkClick[i] = false;

    followBtn[i].addEventListener("click",function(){

        if(!checkClick[i]){
            console.log(i+"번째 팔로우 버튼 클릭됨");
            checkClick[i] = true;

            console.log("회원번호"+memberNo[i].value);
            console.log("타겟번호"+targetNo[i].value);
            
            $.ajax({
                url : contextPath+"/member/myPage/follow",
                data : {"memberNo" : memberNo[i].value,
                        "targetNo" : targetNo[i].value,
                        "mode" : 1},
                type : "POST",
                success : function(result){
                    if(result>0){
                        console.log("팔로우 성공");
                        followBtn[i].innerText = "언팔로우";

                    }else{
                        console.log("팔로우 실패");
                    }
                },
                error : function(req, status, error){
                    console.log("팔로우 중 오류 발생");
                    console.log(req.responseText);
                }
            })
        }else{
            checkClick[i] = false;
            console.log(i+"번째 팔로우 신청");

            console.log("회원번호"+memberNo[i].value);
            console.log("타겟번호"+targetNo[i].value);

            $.ajax({
                url : contextPath+"/member/myPage/follow",
                data : {"memberNo" : memberNo[i].value,
                        "targetNo" : targetNo[i].value,
                        "mode" : 2},
                type : "POST",
                success : function(result){
                    if(result>0){
                        console.log("언팔 성공");
                        followBtn[i].innerText = "팔로우"
                    }else{
                        console.log("언팔 실패");
                    }
                },
                error : function(req, status, error){
                    console.log("언팔 중 오류 발생");
                    console.log(req.responseText);
                }
            })

        }
        
    });

}
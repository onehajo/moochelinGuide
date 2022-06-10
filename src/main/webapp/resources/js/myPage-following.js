// 버튼 요소 선택
const deleteBtn = document.getElementsByClassName("userDeleteBtn");
const targetNo = document.getElementsByClassName("targetNo");
const memberNo = document.getElementsByClassName("memberNo");

// 클릭여부 확인하는 배열 생성
const checkClick = [];

// 삭제할 타겟의 회원번호 (console.log(targetNo[i].value))

// 팔로워 삭제
for(let i = 0; i<fCount; i++){

    checkClick[i] = false;

    deleteBtn[i].addEventListener("click",function(){

        if(!checkClick[i]){
            console.log(i+"번째 팔로우 취소 버튼 클릭됨");
            checkClick[i] = true;

            console.log("타겟번호"+targetNo[i].value);
            console.log("회원번호"+memberNo[i].value);
            
            $.ajax({
                url : contextPath+"/member/myPage/follow",
                data : {"targetNo" : targetNo[i].value,
                        "memberNo" : memberNo[i].value,
                        "mode" : 1},
                type : "POST",
                success : function(result){
                    if(result>0){
                        console.log("언팔로우 성공");
                        deleteBtn[i].innerText = "팔로우";

                    }else{
                        console.log("언팔로우 실패");
                    }
                },
                error : function(req, status, error){
                    console.log("언팔로우 중 오류 발생");
                    console.log(req.responseText);
                }
            })
        }else{
            checkClick[i] = false;
            console.log(i+"번째 팔로우 신청");

            console.log("타겟번호"+targetNo[i].value);
            console.log("회원번호"+memberNo[i].value);

            $.ajax({
                url : contextPath+"/member/myPage/follow",
                data : {"targetNo" : targetNo[i].value,
                        "memberNo" : memberNo[i].value,
                        "mode" : 2},
                type : "POST",
                success : function(result){
                    if(result>0){
                        console.log("팔로우 성공");
                        deleteBtn[i].innerText = "팔로우 취소"
                    }else{
                        console.log("팔로우 실패");
                    }
                },
                error : function(req, status, error){
                    console.log("팔로우 중 오류 발생");
                    console.log(req.responseText);
                }
            })

        }
        
    });

}
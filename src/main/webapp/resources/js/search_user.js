const followBtn = document.getElementsByClassName("followBtn");
const memberNo = document.getElementsByClassName("memberNo");
const targetNo = document.getElementsByClassName("targetNo");

// 클릭여부 확인하는 배열 생성
const checkClick = [];

// 팔로우 / 언팔로우
for(let i = 0; i<tCount; i++){

    checkClick[i] = false;

    followBtn[i].addEventListener("mouseup",function(){

        if(loginMember==""){
            Swal.fire({
                title: '로그인 후 이용해주세요.',
                width: 600,
                padding: '3em',
                color: 'black',
                confirmButtonColor: '#392eff',
                confirmButtonText: '확인'
              });
        }else{

            if(!checkClick[i]){
                checkClick[i] = true;
                
                $.ajax({
                    url : contextPath+"/member/myPage/follow",
                    data : {"memberNo" : memberNo[i].value,
                            "targetNo" : targetNo[i].value,
                            "mode" : 1},
                    type : "POST",
                    success : function(result){
                        if(result>0){
                            followBtn[i].innerText = "팔로잉";
                            followBtn[i].classList.add("followingBtn");
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
    
                $.ajax({
                    url : contextPath+"/member/myPage/follow",
                    data : {"memberNo" : memberNo[i].value,
                            "targetNo" : targetNo[i].value,
                            "mode" : 2},
                    type : "POST",
                    success : function(result){
                        if(result>0){
                            followBtn[i].innerText = "팔로우"
                            followBtn[i].classList.remove("followingBtn");
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

        }
        
    });

}
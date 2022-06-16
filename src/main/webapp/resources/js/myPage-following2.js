const deleteBtn = document.getElementById("followBtn");
const followingCount2 = document.getElementById("followingCount2");

// 클릭여부 확인하는 생성
let checkClick = false;

// 팔로잉
deleteBtn.addEventListener("mouseup",function(){

    if(deleteBtn.innerText == "팔로우"){

        // checkClick = true;

        $.ajax({
            url : contextPath+"/member/myPage/follow",
            data : {"targetNo" : targetNo,
                    "memberNo" : memberNo,
                    "mode" : 1},
            type : "POST",
            success : function(result){
                if(result>0){
                    console.log("팔로우 성공");
                    deleteBtn.innerText = "팔로우 취소";
                    
                    followerCount++;
                    followingCount2.innerText = followerCount;
                
                    console.log(followerCount);
                    

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
    
    if(deleteBtn.innerText == "팔로우 취소"){
        // checkClick = false;
        
        $.ajax({
            url : contextPath+"/member/myPage/follow",
            data : {"targetNo" : targetNo,
            "memberNo" : memberNo,
            "mode" : 2},
            type : "POST",
            success : function(result){
                
                
                if(result>0){
                    console.log("언팔로우 성공");
                    deleteBtn.innerText = "팔로우";
                    
                    followerCount--;
                    followingCount2.innerText =followerCount;
                    console.log(followerCount);
             

                }else{
                    console.log("언팔로우 실패");
                }
            },
            error : function(req, status, error){
                console.log("언팔로우 중 오류 발생");
                console.log(req.responseText);
            }
        })

    }
    
});




// // 팔로잉
// deleteBtn.addEventListener("mouseup",function(){

//     if(deleteBtn.innerText == "팔로우"){

//         // checkClick = true;

//         $.ajax({
//             url : contextPath+"/member/myPage/follow",
//             data : {"targetNo" : targetNo,
//                     "memberNo" : memberNo,
//                     "mode" : 1},
//             type : "POST",
//             success : function(result){
//                 if(result>0){
//                     console.log("팔로우 성공");
//                     deleteBtn.innerText = "팔로우 취소";
                    
//                     followerCount++;
//                     followingCount2.innerText = followerCount;
                
//                     console.log(followerCount);
                    

//                 }else{
//                     console.log("팔로우 실패");
//                 }
//             },
//             error : function(req, status, error){
//                 console.log("팔로우 중 오류 발생");
//                 console.log(req.responseText);
//             }
//         })
        
//     }
    
//     if(deleteBtn.innerText == "팔로우 취소"){
//         // checkClick = false;
        
//         $.ajax({
//             url : contextPath+"/member/myPage/follow",
//             data : {"targetNo" : targetNo,
//             "memberNo" : memberNo,
//             "mode" : 2},
//             type : "POST",
//             success : function(result){
                
                
//                 if(result>0){
//                     console.log("언팔로우 성공");
//                     deleteBtn.innerText = "팔로우";

//                     followerCount--;
//                     followingCount2.innerText =followerCount;
             

//                 }else{
//                     console.log("언팔로우 실패");
//                 }
//             },
//             error : function(req, status, error){
//                 console.log("언팔로우 중 오류 발생");
//                 console.log(req.responseText);
//             }
//         })

//     }
    
// });
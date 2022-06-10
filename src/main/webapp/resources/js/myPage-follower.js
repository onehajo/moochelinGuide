// 버튼 요소 선택
const deleteBtn = document.getElementsByClassName("userDeleteBtn");
const targetNo = document.getElementsByClassName("targetNo");
const memberNo = document.getElementsByClassName("memberNo");
const list = document.getElementsByClassName("list");
const ul = document.getElementById("ul");

// 팔로워 삭제
for(let i = 0; i<fCount; i++){

    deleteBtn[i].addEventListener("click",function(){

        if(confirm("정말 삭제하시겠습니까?")){

            console.log(i+"번째 팔로워 삭제 버튼 클릭됨");

            $.ajax({
                url : contextPath+"/member/myPage/follow",
                data : {"targetNo" : targetNo[i].value,
                        "memberNo" : memberNo[i].value,
                        "mode" : 1},
                type : "POST",
                success : function(result){
                    if(result>0){
                        console.log("팔로워 삭제 성공");
                        list[i].style.display = 'none';

                        if(i==fCount-1){

                            ul.children[0].remove();
                            const p1 = document.createElement("p");
                            p1.innerText = "팔로워"
                            const p2 = document.createElement("p");
                            p2.innerText = "회원님을 팔로우하는 모든 사람들이 여기에 표시됩니다.";
                            const div = document.createElement("div");
                            div.id = "searchFail";
                            div.append(p1, p2);
                            ul.append(div);
                        }

                    }else{
                        console.log("팔로워 삭제 실패");
                    }
                },
                error : function(req, status, error){
                    console.log("팔로워 삭제 중 오류 발생");
                    console.log(req.responseText);
                }
            })
        }
        
    });

}
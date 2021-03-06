const inputPw = document.getElementById("inputPw");
const msg = document.getElementById("msg");
const secessionBtn = document.getElementById("secessionBtn");

/*비밀번호 일치여부 확인하는 ajax*/
inputPw.addEventListener("keyup",function(){

     // 값이 입력됐을 때
    if(inputPw.value.trim().length!=0){

        $.ajax({
            url : contextPath+"/member/myPage/secession/check",
            data : {"inputPw": inputPw.value,
                    "memberNo" : loginMemberNo},
            type : "POST",
            success : function(result){

                if(result>0){
                    msg.innerText=" *비밀번호 일치";
                    msg.style.color = "green";
                }else{
                    msg.innerText=" *비밀번호 불일치";
                    msg.style.color = "red";
                }
               
            },
            error : function(req, status, error){
                console.log(" *비밀번호 일치여부 확인 실패");
                console.log(req.responseText);
            }
        });
    }else{
        msg.innerText = " *비밀번호를 입력해주세요."
        msg.style.color = "red";
        msg.focus();
    }

});

secessionBtn.addEventListener("click",function(e){

    if(msg.style.color == "red"){
        msg.innerText = " *현재 비밀번호를 입력한 뒤 탈퇴하기 버튼을 눌러주세요.";
        msg.focus();
        e.preventDefault();

    }else{

        e.preventDefault();

        Swal.fire({
            title: '정말 탈퇴하시겠습니까?',
            padding: '0 2em 2em 2em',
			titlefontSize: '1.875em',
			fontWeight: '600',
            text: "탈퇴 버튼을 누르면 회원 탈퇴가 진행됩니다.",
            icon: 'warning',
            iconColor: '#392eff',
            showCancelButton: true,
            confirmButtonColor: '#392eff',
            cancelButtonColor: 'rgb(116, 116, 123)',
            confirmButtonText: '탈퇴',
            cancelButtonText: '취소'
            }).then((result) => {
                if (result.isConfirmed) {
                    document.secession.submit();                          
                }
            })

    }

});
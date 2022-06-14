//
const inputResetPw = document.getElementById("inputResetPw")
const pwComment = document.getElementById("pwComment")
const resetBtn = document.getElementById("resetBtn")


// 비밀번호 정규식
const pwExp = /^[\w!@#_-]{6,30}$/;


// 입력했을때
inputResetPw.addEventListener("input",function(){

    // 비밀번호 정규식 검사
    if(!pwExp.test(inputResetPw.value)){
        pwComment.innerText="비밀번호는 6자리 이상 30자리 이하입니다."
        inputResetPw.focus();
    }else{
        pwComment.innerText="";
    }

})


// 비밀번호 유효성 검사
function resestValidate(){

    // 비밀번호를 입력하지 않은 경우 false 반환
    if(inputResetPw.value.trim() == ""){
        alert("비밀번호를 입력해주세요.");
        inputResetPw.value = ""; 
        inputResetPw.focus(); 
        return false; 
    }

    // 비밀번호 정규식 검사
    if(!pwExp.test(inputResetPw.value)){
        alert("비밀번호를 조건에 따라 다시 입력해주세요.");
        inputResetPw.focus();
        return false; 
    }
    
    return true;
};



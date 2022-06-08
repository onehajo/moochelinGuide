var $body_tag = document.querySelector("body")
var $dark = document.querySelector(".dark");
var $dark1 = document.querySelector(".dark1");
var $popupLogin = document.querySelector("#login-box");
var $popupSignup = document.querySelector("#signup-box");
var $popupAgree = document.querySelector("#agree");

// 로그인 클릭할때
function openPopLogin(){
	$popupSignup.setAttribute("class", "popup");
    $dark.setAttribute("class", "dark active");
    $popupLogin.setAttribute("class", "popup active");
    $body_tag.setAttribute("class", "not_scroll");
}

// 회원가입 클릭할때
function openPopSignUp(){
	$popupLogin.setAttribute("class", "popup");
    $dark.setAttribute("class", "dark active");
    $popupSignup.setAttribute("class", "popup active");
    $body_tag.setAttribute("class", "not_scroll");
}

// 약관보기(회원가입버튼) 클릭 할때
function openAgree(){
    $dark.setAttribute("class", "dark");
    $dark1.setAttribute("class", "dark1 active1");
    $popupAgree.setAttribute("class", "popup1 active2");
}

// 검은배경 클릭할때 (로그인, 회원가입 닫기)
function closePop(){
    $dark.setAttribute("class", "dark");
    $popupLogin.setAttribute("class", "popup"); // 로그인 닫기
    $popupSignup.setAttribute("class", "popup"); // 회원가입 닫기
    $popupAgree.setAttribute("class", "popup1"); // 약관 닫기
    $body_tag.setAttribute("class", "");
}

// 검은배경 클릭할때 (약관동의 닫기)
function closeAgree(){
    $dark1.setAttribute("class", "dark1");
    $dark.setAttribute("class", "dark active");
    $popupAgree.setAttribute("class", "popup1"); // 약관 닫기
}




// 로그인
const loginEmail = document.getElementById("loginEmail");
const loginPw = document.getElementById("loginPw");
const emailComment = document.getElementById("emailComment");
const pwComment = document.getElementById("pwComment");

// 정규식
const nameExp = /^[a-zA-Z0-9가-힣]{2,10}$/;
const emailExp = /^[\w\-\_]{3,}\@[\w\-\_]+(\.\w+){1,3}$/;
const pwExp = /^[\w!@#_-]{6,30}$/;

// 회원가입
const signUpName = document.getElementById("signUpName");
const signUpEmail = document.getElementById("signUpEmail");
const signUpPw = document.getElementById("signUpPw");

const nameMessage = document.getElementById("nameMessage");
const emailMessage = document.getElementById("emailMessage");
const pwMessage = document.getElementById("pwMessage");





// 로그인 시 이메일(아이디)/비밀번호 유효성 검사
function loginValidate() { 

    // 이메일이 입력되지 않은 경우 false를 반환
    if(loginEmail.value.trim().length==0){
        alert("이메일을 입력해주세요.");
        loginEmail.value = ""; 
        loginEmail.focus(); 
        return false; 
    }

    // 이메일 정규식 검사
    if(!emailExp.test(loginEmail.value)){
        emailComment.innerText="정확하지 않은 이메일입니다."
        loginEmail.focus(); 
        return false; 
    }else{
        emailComment.innerText="";
    }

    // 비밀번호를 입력하지 않은 경우 false 반환
    if(loginPw.value.trim() == ""){
        alert("비밀번호를 입력해주세요.");
        loginPw.value = ""; 
        loginPw.focus(); 
        return false; 
    }

    // 비밀번호 정규식 검사
    if(!pwExp.test(loginPw.value)){
        pwComment.innerText="비밀번호는 6자리 이상 30자리 이하입니다."
        loginPw.focus();
        return false; 
    }else{
        pwComment.innerText="";
    }

    return true;
};

loginEmail.addEventListener("input",function(){
    emailComment.innerText="";
})

loginPw.addEventListener("input",function(){
    pwComment.innerText="";
})





// 회원가입 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
    signUpName : false,
    signUpEmail : false,
    signUpPw : false,
};

// 이름 유효성 검사
signUpName.addEventListener("input", function(){

    if(signUpName.value.length==0 || !nameExp.test(signUpName.value)){
        nameMessage.innerText="영어/숫자/한글 2~10글자 사이로 작성해주세요.";

        checkObj.signUpName=false; // 유효하지 않은 상태
        return;
    }else{
        nameMessage.innerText="";
        checkObj.signUpName=true; // 유효한 상태
    } 
})


// 이메일 유효성 검사
signUpEmail.addEventListener("input", function(){

    if(signUpEmail.value.length==0){
        emailMessage.innerText="메일을 받을 수 있는 이메일을 입력해주세요.";
        emailMessage.classList.remove("confirm","error");

        checkObj.signUpEmail=false; // 유효하지 않은 상태
        return;
    }

    if(emailExp.test(signUpEmail.value)){

        // ****** 이메일 중복 검사(ajax) 진행 ******
        $.ajax({
			url: "emailDupCheck", 
			data : {"memberEmail" : signUpEmail.value},
			type : "GET", 
			success : function(result){
                if(result==1) { // 중복임
                    emailMessage.innerText = "이미 가입된 이메일입니다."
                    checkObj.signUpEmail=false; // 유효하지 않은 상태
                } else{
                    emailMessage.innerText = ""
                    checkObj.signUpEmail=true; // 유효한 상태 
                }
			},
			error : function(){

			}
		});

    }else{
        emailMessage.innerText = "이메일 형식이 올바르지 않습니다."

        checkObj.signUpEmail=false; // 유효하지 않은 상태
    }
})


// 비밀번호 유효성 검사
signUpPw.addEventListener("input",function(){

    if(signUpPw.value.length==0){
        pwMessage.innerText="영어, 숫자, 특수문자(!,@,#,-._) 6~30글자 사이로 작성해주세요.";

        checkObj.signUpPw=false; // 유효하지 않은 상태
        return;
    }

    if(pwExp.test(signUpPw.value)){ // 비밀번호 유효할때
        pwMessage.innerText="";
        checkObj.signUpPw=true; // 유효한 상태

    } else{
        pwMessage.innerText="비밀번호 형식이 유효하지 않습니다.";
        checkObj.signUpPw=false; // 유효하지 않은 상태
    }  
});


// 회원가입 버튼 클릭 시 유효성 검사가 완료되었는지 검사
document.getElementById("signup-btn").addEventListener("click",function(){

    let str;
    for(let key in checkObj){ // 객체용 향상된 for문
        if(!checkObj[key]){ // 현재 접근중인 key의 value가 false인 경우
            
            switch(key){
                case "signUpName": str="닉네임을"; break;
                case "signUpEmail": str="이메일을"; break;
                case "signUpPw": str="비밀번호를"; break;    
            }

            document.getElementById(key).focus();
            alert(str+"다시 입력해주세요.");
            return;
        }
    }

    // 모두 유효하면 약관동의 팝업 열기
    openAgree();
});

const agree1 = document.getElementById("agree1");
const agree2 = document.getElementById("agree2");

// 약관동의 체크되어 있으면 가입submit
function signUpValidate(){

    if(agree1.checked && agree2.checked){
        return true;
    }else{
        alert("약관에 동의해주세요");
        return false;
    }
}

function showing(){
    $.ajax({
        url: "movie/showing",
        dataType: "json", 
        success: function(list){
		
			const ul = document.getElementsByClassName("movie-list")[0];
		
			//for(let movie of list){
			//const li = document.createElement("li");
			//const a = 
			
			//}
		},
        error: function(){}
    })
}


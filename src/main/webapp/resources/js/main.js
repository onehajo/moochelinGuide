var $body_tag = document.querySelector("body")
var $dark = document.querySelector(".dark");
var $dark1 = document.querySelector(".dark1");
var $popupLogin = document.querySelector("#login-box");
var $popupSignup = document.querySelector("#signup-box");
var $popupAgree = document.querySelector("#agree");
var $popupPw = document.querySelector("#pw-box");


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

// 비밀번호 변경 이메일 보내기
const pwFindEmail = document.getElementById("pwFindEmail");
const pwfindText = document.getElementById("pwfindText");
const pwfindBtn = document.getElementById("pwfindBtn");





// 로그인 클릭할때
function openPopLogin(){
    loginEmail.value="";
    loginPw.value="";
    pwComment.innerText="";
	$popupSignup.setAttribute("class", "popup");
    $dark.setAttribute("class", "dark active");
    $popupLogin.setAttribute("class", "popup active");
    $body_tag.setAttribute("class", "not_scroll");
}

// 회원가입 클릭할때
function openPopSignUp(){
    signUpName.value="";
    signUpEmail.value="";
    signUpPw.value="";
    nameMessage.innerText="";
    emailMessage.innerText="";
    pwMessage.innerText="";
	$popupLogin.setAttribute("class", "popup");
    $dark.setAttribute("class", "dark active");
    $popupSignup.setAttribute("class", "popup active");
    $body_tag.setAttribute("class", "not_scroll");
}

// 약관보기(회원가입버튼) 클릭 할때
function openAgree(){
    $dark.setAttribute("class", "dark active1");
    $popupAgree.setAttribute("class", "popup active2");
}

// 검은배경 클릭할때 (로그인, 회원가입 닫기)
function closePop(){
	if( $dark.classList.contains('active1')){
		$dark.setAttribute("class", "dark active"); // z-index 4->3
		$popupAgree.setAttribute("class", "popup"); // 약관 닫기
		$popupPw.setAttribute("class", "popup"); // 약관 닫기

    }else{
	    $dark.setAttribute("class", "dark");
	    $popupLogin.setAttribute("class", "popup"); // 로그인 닫기
	    $popupSignup.setAttribute("class", "popup"); // 회원가입 닫기
	    $body_tag.setAttribute("class", "");	
	}
}

// 비밀번호 변경 클릭 할때
function openPw(){
    pwFindEmail.value="";
    pwfindText.innerText="";
	$popupPw.setAttribute("class", "popup active2");
    $dark.setAttribute("class", "dark active1");
}




// 로그인 시 이메일(아이디)/비밀번호 유효성 검사
function loginValidate() { 

    // 이메일이 입력되지 않은 경우 false를 반환
    if(loginEmail.value.trim().length==0){
		
		  Swal.fire({
             title: '이메일을 입력해주세요.',
             width: 600,
             padding: '3em',
             color: 'black',
             confirmButtonColor: '#392eff',
             confirmButtonText: '확인'
          })
          
          
        //alert("이메일을 입력해주세요.");
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
	
		Swal.fire({
             title: '비밀번호를 입력해주세요.',
             width: 600,
             padding: '3em',
             color: 'black',
             confirmButtonColor: '#392eff',
             confirmButtonText: '확인'
          })
          
        //alert("비밀번호를 입력해주세요.");
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


// 화면에 로그인 인풋 null아니어야 이벤트 실행함
if(loginEmail!=null){
	
	loginEmail.addEventListener("input",function(){
    emailComment.innerText="";
	})

	loginPw.addEventListener("input",function(){
	    pwComment.innerText="";
	})
}






// pwFindEmail 비밀번호 재설정 이메일 보내는 input 있을때만 실행
if(pwFindEmail!=null){	

	let valicheck=false;
	// 비밀번호 변경 이메일보내기 - 이메일 유효성 검사
	pwFindEmail.addEventListener("input", function(){
	
	    if(pwFindEmail.value.trim().length==0){
	        pwfindText.innerText="이메일을 입력해주세요.";
	
			valicheck=false;
	        return;
	    }else{
	
		    if(emailExp.test(pwFindEmail.value)){
		
		        // ****** 이메일 중복 검사(ajax) 진행 ******
		        $.ajax({
					url: "emailDupCheck", 
					data : {"memberEmail" : pwFindEmail.value},
					type : "GET", 
					success : function(result){
		                if(result!=0) { // 중복임
		                    pwfindText.innerText = ""
		                    valicheck=true;
		                } else{
		                    pwfindText.innerText = "가입되지 않은 이메일입니다."
		                    valicheck=false;
		                }
					},
					error : function(){
					}
				});
	
		    }else{
		        pwfindText.innerText = "이메일 형식이 올바르지 않습니다."
				valicheck=false;
		    }
	    
	    }
	})
	// 비밀번호 유효성 검사
	function pwfindValidate(){
		if(!valicheck){
			
		Swal.fire({
             title: '가입한 이메일을 입력해주세요.',
             width: 600,
             padding: '3em',
             color: 'black',
             confirmButtonColor: '#392eff',
             confirmButtonText: '확인'
          })
          
          
			//alert("가입한 이메일을 입력해주세요.");
			return false;
			
		}
		return true;
	}





	// 비밀번호 변경 이메일보내기
	pwfindBtn.addEventListener("click",function(){
		
		if(valicheck){// 유효할때
			
			$.ajax({
	            url: "pwfind",
	            data: {"pwFindEmail": pwFindEmail.value},
	            method:"post",
	            success: function(result){
		
					Swal.fire({
			             title: '메일발송 성공',
			             width: 600,
			             padding: '3em',
			             color: 'black',
			             confirmButtonColor: '#392eff',
			             confirmButtonText: '확인'
			          })
          
					//alert("메일발송 성공");
	                console.log("이메일 발송 성공");
	                console.log(result);
	
	            }
	        });   
	        
		}
	});


} //pwFindEmail 비밀번호 재설정 이메일 보내는 input 있을때만 실행 부분끝남








// 회원가입 이름 적는 input 있어야 실행
if(signUpName!=null){
	


// 회원가입 유효성 검사 여부를 기록할 객체 생성
	const checkObj = {
	    signUpName : false,
	    signUpEmail : false,
	    signUpPw : false,
	};
	
	// 회원가입 이름 유효성 검사
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
	
	
	// 회원가입 이메일 유효성 검사
	signUpEmail.addEventListener("input", function(){
	
	    if(signUpEmail.value.trim().length==0){
	        emailMessage.innerText="이메일을 입력해주세요.";
	
	        checkObj.signUpEmail=false; // 유효하지 않은 상태
	        return;
	    }else{
		
		
	
		    if(emailExp.test(signUpEmail.value)){
		
		        // ****** 이메일 중복 검사(ajax) 진행 ******
		        $.ajax({
					url: "emailDupCheck", 
					data : {"memberEmail" : signUpEmail.value},
					type : "GET", 
					success : function(result){
		                if(result!=0) { // 중복임
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
	            
	            	Swal.fire({
			             title: str+"다시 입력해주세요.",
			             width: 600,
			             padding: '3em',
			             color: 'black',
			             confirmButtonColor: '#392eff',
			             confirmButtonText: '확인'
			          })
	            
	            
	            //alert(str+"다시 입력해주세요.");
	            return;
	        }
	    }
	
	    // 모두 유효하면 약관동의 팝업 열기
	    openAgree();
	});

}//회원가입 이름 적는 input 있어야 실행 되는 구문 종료


const agree1 = document.getElementById("agree1");
const agree2 = document.getElementById("agree2");

// 약관동의 체크되어 있으면 가입submit
function signUpValidate(){

    if(agree1.checked && agree2.checked){
        return true;
    }else{
	
	
		Swal.fire({
             title: "약관에 동의해주세요",
             width: 600,
             padding: '3em',
             color: 'black',
             confirmButtonColor: '#392eff',
             confirmButtonText: '확인'
		 })
			          
			          
        //alert("약관에 동의해주세요");
        return false;
    }
}

// 약관 전체동의
function selectAll(selectAll){
	const checkboxes = document.getElementsByName("agreeCheck");
	
	checkboxes.forEach((checkbox)=>{
		checkbox.checked = selectAll.checked;
	})
}



// 로그인
// const loginBbtn = document.getElementById("loginBbtn");

// loginBbtn.addEventListener("click",function(){
//     $.ajax({
//         url:"login",
//         data: {loginEmail:"loginEmail",loginPw"}
//     })
// })







// google 로그인 관련 // 왜 안받아와지냐고 !!!!!!!!!
/*function onSignIn(googleUser) {
	// Useful data for your client-side scripts:
	var profile = googleUser.getBasicProfile();
	console.log("ID: " + profile.getId()); // Don't send this directly to your server!
	console.log('Full Name: ' + profile.getName());
	console.log('Given Name: ' + profile.getGivenName());
	console.log('Family Name: ' + profile.getFamilyName());
	console.log("Image URL: " + profile.getImageUrl());
	console.log("Email: " + profile.getEmail());
	
	// The ID token you need to pass to your backend:
	var id_token = googleUser.getAuthResponse().id_token;
	console.log("ID Token: " + id_token);
}*/










// 검색버튼 있을때만 실행
// if(document.getElementById("search-btn")!=null){
	
// 	// 검색
// 	document.getElementById("search-btn").addEventListener("click",function(){
	
// 	    const query = document.getElementById("query");
// 	    const queryExp = /^[a-zA-Z0-9가-힣]{1,10}$/;
// 	    const searchForm = document.getElementsByName("search-form");
	
// 	    // 검색어 유효성 검사
// 	    if( !queryExp.test(query.value)){	
	  
// 	        Swal.fire({
// 	            title: '영어/숫자/한글 1~10글자 사이로 작성해주세요.',
// 	                width: 600,
// 	                padding: '3em',
// 	                color: 'black',
// 	                confirmButtonColor: '#392eff',
// 	                confirmButtonText: '확인'
// 	         })
	
// 	        //alert("영어/숫자/한글 1~10글자 사이로 작성해주세요.");
// 	        query.value = "";
// 	        query.focus();
// 	        return;
// 	    }
	
// 	    // 검색어가 작성된 경우
// 	    if(query.value.trim().length!=0){
// 	        searchForm[0].submit();
// 	    }
	
// 	})

// }


// if (window.event.keyCode == 13) {
// 	// 엔터키가 눌렸을 때

// 	if(query==""){

// 		Swal.fire({
// 			title: '영어/숫자/한글 1~10글자 사이로 작성해주세요.',
// 				width: 600,
// 				padding: '3em',
// 				color: 'black',
// 				confirmButtonColor: '#392eff',
// 				confirmButtonText: '확인'
// 		 })

// 	}

//  }

 function searchValidate(){

	const query = document.getElementById("query");
	const queryExp = /^[a-zA-Z0-9가-힣]{1,10}$/;

	// 검색어 유효성 검사
	if( !queryExp.test(query.value) || query.value == ""){	

		Swal.fire({
			title: '영어/숫자/한글 1~10글자 사이로 작성해주세요.',
				width: 600,
				padding: '3em',
				color: 'black',
				confirmButtonColor: '#392eff',
				confirmButtonText: '확인'
		})

		//alert("영어/숫자/한글 1~10글자 사이로 작성해주세요.");
		query.value = "";
		query.focus();
		return false;
	}

	// 검색어가 작성된 경우
	if(query.value.trim().length!=0){
		return true;
	}


 }
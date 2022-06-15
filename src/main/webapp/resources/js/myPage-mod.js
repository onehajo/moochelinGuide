


// 프로필 이미지 
const inputImage = document.getElementById("input-image");


// 프로필 이미지 변경 ( 미리보기 )
if( inputImage != null ){ // inputImage 가 화면에 존재 할 때

    // inputImage 이미지 선택 될 때, change이벤트 발생
    inputImage.addEventListener("change", function(){

        if(this.files[0] != undefined ) { // 파일 선택 후 업로드가 성공했을때.

            const reader = new FileReader();

            reader.readAsDataURL(this.files[0]);


            reader.onload = function(e){

                const profileImage = document.getElementById("profile-image");

                profileImage.setAttribute("src",e.target.result);

                document.getElementById("imgDelete").value = 0;
                

            }
        }
    });

}


// 프로필이미지 삭제버튼
if(document.getElementById("delete-image") != null){

    document.getElementById("delete-image").addEventListener("click",function(){

        // 0 : 삭제버튼 안누름
        // 1 : 삭제버튼 누름
        const imgDelete = document.getElementById("imgDelete");

        if ( imgDelete.value == 0 ){
            
            // 1) 프로필 이미지를 기본 이미지로 변경하는 것
            document.getElementById("profile-image").setAttribute("src",contextPath + "/resources/images/logo-blue.png");

            // 2) input type="file"에 저장된 값(value)에 ""대입. -> 변경하기 버튼 동작 막기
            document.getElementById("input-image").value = "";

            imgDelete.value = 1; // 눌러짐 인식

        }
    
    });

}




// 배경 이미지
const inputBackground = document.getElementById("input-background");
// 배경 이미지 변경 ( 미리보기 )
if( inputBackground != null ){ // inputImage 가 화면에 존재 할 때

    // inputImage 이미지 선택 될 때, change이벤트 발생
    inputBackground.addEventListener("change", function(){

        if(this.files[0] != undefined ) { // 파일 선택 후 업로드가 성공했을때.

            const reader = new FileReader();

            reader.readAsDataURL(this.files[0]);


            reader.onload = function(e){

                const backGround = document.getElementById("back-ground");

                backGround.setAttribute("src",e.target.result);

                document.getElementById("bgDelete").value = 0;

            }
        }
    });
}


// 배경 삭제버튼
if(document.getElementById("delete-background") != null){


document.getElementById("delete-background").addEventListener("click", function(){

    // 0 : 안눌러짐
    // 1 : 눌러짐

    const bgDelete = document.getElementById("bgDelete");

    if(bgDelete.value == 0){ // 눌러지지 않은 경우

        // 1) 배경 이미지를 기본 이미지로 변경
        document.getElementById("back-ground").setAttribute("src",contextPath + "/resources/images/logo-blue.png");                 

        // 2) input type="file"에 저장된 값(value)에 "" 대입 
        document.getElementById("input-background").value = "";

        bgDelete.value = 1; // 눌러진걸로 인식
    }
});

}





const nameMsg = document.getElementById("nameMsg");
const memberName = document.getElementById("memberName");
const nameReg = /^[a-zA-Z0-9가-힣]{2,11}$/;// 이름 조건 

// 이름 유효성 검사 (입력)
memberName.addEventListener("input",function(){

    // 입력이 되지 않은 경우
    if(memberName.value.length > 11){
        nameMsg.innerText = "이름은 11글자 이내로 해주세요.";
        return;
    }

    if(!nameReg.test(memberName.value)){
        nameMsg.innerText = "이름은 2~11글자의 한글/영문/숫자만 사용해주세요.";
        return;
    }

    nameMsg.innerText = "*필수 입력사항입니다.";


});



// 이름 유효성 검사(제출 시)
function modValidate(){

    if ( memberName.value.length == 0 ) {
        Swal.fire({
                title: '이름을 입력해주세요.',
                width: 600,
                padding: '3em',
                color: 'black',
                confirmButtonColor: '#392eff',
                confirmButtonText: '확인'
              });
        memberName.focus(); 
        return false; 
    }

    if ( !nameReg.test(memberName.value) ) {
        Swal.fire({
            title: '이름은 2~11글자의 한글/영문/숫자만 사용해주세요.',
            width: 600,
            padding: '3em',
            color: 'black',
            confirmButtonColor: '#392eff',
            confirmButtonText: '확인'
          });
        memberName.focus(); 
        return false; 
    }


    return true;
}







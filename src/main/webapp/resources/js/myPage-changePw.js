
// 비밀번호 변경 유효성 검사 

function changePwValidate() {
    
    const regPW = /^[\w!@#_-]{6,15}/;
    const currentPw = document.getElementsByName("currentPw")[0];
    const newPw = document.getElementsByName("newPw")[0];
    const newPwConfirm = document.getElementsByName("newPwConfirm")[0];

    if(currentPw.value.trim().length == 0 ){
        alert("현재 비밀번호를 작성해주세요.")
        currentPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }
    if(newPw.value.trim().length == 0 ){
        alert("새비밀번호를 작성해주세요.")
        newPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }
    if(newPwConfirm.value.trim().length == 0 ){
        alert("새비밀번호 확인을 작성해주세요.")
        newPwConfirm.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }

    if(!regPW.test(currentPw.value)){
        alert("현재 비밀번호 조건이 맞지않습니다.")
        currentPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }
    if(!regPW.test(newPw.value)){
        alert("새비밀번호 조건이 맞지않습니다.")
        newPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }
    if(!regPW.test(newPwConfirm.value)){
        alert("newPwConfirm 확인 조건이 맞지않습니다.")
        currentPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }

    return true;

}



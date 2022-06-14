
// 비밀번호 변경 유효성 검사 

function changePwValidate() {
    
    const regPW = /^[\w!@#_-]{6,15}/;
    const currentPw = document.getElementById("currentPw");
    const newPw = document.getElementById("newPw");
    const newPwConfirm = document.getElementById("newPwConfirm");

    if(currentPw.value.trim().length == 0 ){
        wal.fire({
            title: '현재 비밀번호를 작성해주세요.',
            width: 600,
            padding: '3em',
            color: 'black',
            confirmButtonColor: '#392eff',
            confirmButtonText: '확인'
          });
        currentPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }
    if(newPw.value.trim().length == 0 ){
        wal.fire({
            title: '새비밀번호를 작성해주세요.',
            width: 600,
            padding: '3em',
            color: 'black',
            confirmButtonColor: '#392eff',
            confirmButtonText: '확인'
          });
        newPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }
    if(newPwConfirm.value.trim().length == 0 ){
        wal.fire({
            title: '새비밀번호 확인을 작성해주세요.',
            width: 600,
            padding: '3em',
            color: 'black',
            confirmButtonColor: '#392eff',
            confirmButtonText: '확인'
          });
        newPwConfirm.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }

    if(!regPW.test(currentPw.value)){
        wal.fire({
            title: '현재 비밀번호 조건이 맞지않습니다.',
            width: 600,
            padding: '3em',
            color: 'black',
            confirmButtonColor: '#392eff',
            confirmButtonText: '확인'
          });
        currentPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }
    if(!regPW.test(newPw.value)){
        wal.fire({
            title: '새비밀번호의 비밀번호 조건이 맞지않습니다.',
            width: 600,
            padding: '3em',
            color: 'black',
            confirmButtonColor: '#392eff',
            confirmButtonText: '확인'
          });
        newPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }
    if(!regPW.test(newPwConfirm.value)){
        wal.fire({
            title: 'newPwConfirm 확인 조건이 맞지않습니다.',
            width: 600,
            padding: '3em',
            color: 'black',
            confirmButtonColor: '#392eff',
            confirmButtonText: '확인'
          });
        currentPw.focus(); // 포커스를 맞춰줌
        return false; // 기본 이벤트 제거를 위해 false 반환
    }

    return true;

}



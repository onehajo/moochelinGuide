

// 얘는 이제 필요가 없음.
const btn = document.getElementById("followBtn") //id가 'btn'인 요소를 반환한다.
btn.addEventListener("click",function(){
  console.log(btn)

    if(btn.innerText == '팔로우' ){ //버튼의 텍스트값 확인
        this.innerText = '팔로우 취소'  // 텍스트를 unfollow로 변경
      }else{  // 반대일 경우 다시 변경
        this.innerText = '팔로우'
      }

});

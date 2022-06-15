const m = document.getElementsByClassName("message");
const messageContent = document.getElementById("messageContent");
const messageSend = document.getElementById("messageSend");
const close = document.getElementsByClassName("close")[0];
const messageNo = document.getElementsByName("messageNo");




// 팝업에서 보내기 버튼 클릭시 유효성검사
const messageC = document.getElementById("messageC");

function sendValidate(){

    if(messageC.value.trim().length==0){
        messageC.focus();
        return false;
    }
    return true;
}




// 메세지 팝업에 삭제버튼
const deleteMessageBtn = document.getElementById("deleteMessageBtn");

deleteMessageBtn.addEventListener("click",function(e){

    e.preventDefault();
	
	console.log(e);
/*    Swal.fire({
        title: '받은 쪽지를 삭제하시겠습니까?',
        text: "확인 버튼을 클릭하면 쪽지가 삭제됩니다.",
        icon: 'warning',
        iconColor: '#392eff',
        showCancelButton: true,
        confirmButtonColor: '#392eff',
        cancelButtonColor: 'rgb(116, 116, 123)',
        confirmButtonText: '확인',
        cancelButtonText: '취소'
        }).then((result) => {
            if (result.isConfirmed) {
                document.deletepop.submit(); 
                self.close();
            }
     	})*/
    
})

// 
function delvalidate(){

window.open(alert("으아ㅏㅏㅏㅏㅏㅏ"));
    //const delvaliText = confirm("삭제하시겠습니까?");

/*    if(delvaliText == true){
        document.deletepop.submit();
        self.close();

        return true;
      }
      else if(delvaliText == false){
        return false;
      }
*/
    return false;
}



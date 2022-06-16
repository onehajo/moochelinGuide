




// 팝업에서 보내기 버튼 클릭시
const messageC = document.getElementById("messageCsend");
const sendMessageBtn = document.getElementById("sendMessageBtn");

// if(sendMessageBtn!=null){
	
// 	sendMessageBtn.addEventListener("click",function(){

// 		// textarea 비어있는데 왜 else로 넘어가서 close됨?????
// 		if(messageC.innerText==""){
// 			alert("메시지 작성 후 보내기 버튼을 눌러주세요.");
// 			// Swal.fire({
//             //     title: '메시지 작성 후 보내기 버튼을 눌러주세요 !',
//             //     width: 600,
//             //     padding: '3em',
//             //     color: 'black',
//             //     confirmButtonColor: '#392eff',
//             //     confirmButtonText: '확인'
//             //   });

// 	        messageC.focus();
// 			e.preventDefault();

// 	    }else{
		
// 			document.sendForm.submit();
// 			self.close();
		
// 		}
	
// 	})
// }

function sendForm(){
	if(messageC.value.trim().length==0){
		
		Swal.fire({
			title: '메시지 작성 후 보내기 버튼을 눌러주세요 !',
			width: 600,
			padding: '3em',
			color: 'black',
			confirmButtonColor: '#392eff',
			confirmButtonText: '확인'
		});

		messageC.focus();
		return false;
	}else{
		self.close();
		return true;
	}
};





// 메세지 팝업에 삭제버튼
const deleteMessageBtn = document.getElementById("deleteMessageBtn");

if(deleteMessageBtn!=null){
	deleteMessageBtn.addEventListener("click",function(e){
	
		//와 prevent적용되네... 근데 swal안먹음
	    //e.preventDefault();
		
	    Swal.fire({
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
	     	})
	    
	})
}

// 
function delvalidate(){

open(alert("으아ㅏㅏㅏㅏㅏㅏ"));
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
    return true;
}



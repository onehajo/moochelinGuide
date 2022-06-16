// 팝업에서 보내기 버튼 클릭시
const messageC = document.getElementById("messageCsend");
const sendMessageBtn = document.getElementById("sendMessageBtn");

// 쪽지 발송 유효성 검사
function sendForm(){
    if(messageC.value.trim().length==0){
        
        Swal.fire({
            title: '메시지 작성 후 보내기 버튼을 눌러주세요 !',
            width: 350,
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

for(let i=0; i<count2; i++){

	const deleteMint2 = document.getElementsByClassName("mint2");
	const formmint2 = document.getElementsByClassName("formmint2");

	deleteMint2[i].addEventListener("click", function(e){
		
		e.preventDefault();

		Swal.fire({
			title: '받은 쪽지를 삭제하시겠습니까?',
			text: "확인 버튼을 클릭하면 쪽지가 삭제됩니다.",
			width: 340,
			heght:340,
			padding:10,
			icon: 'warning',
			iconColor: '#392eff',
			showCancelButton: true,
			confirmButtonColor: '#392eff',
			cancelButtonColor: 'rgb(116, 116, 123)',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
			}).then((result) => {
				if (result.isConfirmed) {
					 formmint2[i].submit();
					 self.close();
				}else{
					e.preventDefault();

				}
			 });


	});

}
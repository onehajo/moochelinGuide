const m = document.getElementsByClassName("message");
const messageContent = document.getElementById("messageContent");
const messageSend = document.getElementById("messageSend");
const close = document.getElementsByClassName("close")[0];
const messageNo = document.getElementsByName("messageNo");


for(let i=0; i<count1; i++){

	const delmint = document.getElementsByClassName("delmint");
	const delform = document.getElementsByClassName("delform");

	delmint[i].addEventListener("click", function(e){

		e.preventDefault();
	
		Swal.fire({
			title: '받은 쪽지를 삭제하시겠습니까?',
			text: "확인 버튼을 클릭하면 쪽지가 삭제됩니다.",
			width: 370,
			icon: 'warning',
			iconColor: '#392eff',
			showCancelButton: true,
			confirmButtonColor: '#392eff',
			cancelButtonColor: 'rgb(116, 116, 123)',
			confirmButtonText: '확인',
			cancelButtonText: '취소'
			}).then((result) => {
				if (result.isConfirmed) {
					 delform[i].submit();
				}else{
					e.preventDefault();
				}
			 })
	
	
	});

}
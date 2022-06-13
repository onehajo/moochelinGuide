const m = document.getElementsByClassName("message");
const messageContent = document.getElementById("messageContent");
const messageSend = document.getElementById("messageSend");
const close = document.getElementsByClassName("close")[0];
const messageNo = document.getElementsByName("messageNo");

//if(!messageContent.classList.contains('activeP')){
        //for(let i=0; i<m.length; i++){
        //m[i].addEventListener("click",function(){
            //messageSend.classList.remove('activeP');
            //messageContent.classList.add('activeP');
            //console.log(messageNo[i].value);
            
            //const messageNumber = messageNo[i].value;
            //const no = params.get("no");
            

            /*$.ajax({
                url : "detail",
                data : {"messageNumber": messageNumber},
                dataType: "json",
                success: function(messageDetail){
	
				document.getElementById("messageC").innerText = messageDetail.messageContent;
				},
                error: function(messageDetail){}
            });*/


            //const url ="detail?no="+messageNo[i].value;
            //const name ="message-confirm";
            //const option ="width = 400, height = 500, top = 100, left = 200, location = no";
            //window.open(url, name, option);


            
        //});
    //}        
//} 

//

(function(){
    $.ajax({
        url : "selectList",
        dataType: "json",
        success: function(messageList){

        },
        error: function(messageList){}
    });

})()







// 답장하기 누르면
function popupSend(){
    messageContent.classList.add('activeImportant');
    messageSend.classList.add('activePblock');
}

document.getElementById("sendMessagePop").addEventListener("click",function(){
	messageContent.classList.add('activeImportant');
    messageSend.classList.add('activePblock');
})



const sendMessageBtn = document.getElementById("sendMessageBtn");
// 메세지 팝업에 // 보내기 버튼 클릭
sendMessageBtn.addEventListener("click",function(){
    window.close();
})
// 메세지 팝업에 삭제버튼
const deleteMessageBtn = document.getElementById("deleteMessageBtn");
deleteMessageBtn.addEventListener("click",function(){
	confirm("쪽지를 삭제 하시겠습니까?")
    window.close();
})

    




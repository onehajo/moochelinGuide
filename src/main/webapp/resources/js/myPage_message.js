const m = document.getElementsByClassName("message");
const messageContent = document.getElementById("messageContent");
const messageSend = document.getElementById("messageSend");
const close = document.getElementsByClassName("close")[0];

if(!messageContent.classList.contains('activeP')){
        for(let i=0; i<m.length; i++){
        m[i].addEventListener("click",function(){
            messageSend.classList.remove('activeP');
            messageContent.classList.add('activeP');
        });
    }        
} 


function popupSend(){
    messageContent.classList.remove('activeP');
    messageSend.classList.add('activeP');
}

function closeMessage(){
    messageContent.classList.remove('activeP');
    messageSend.classList.remove('activeP');
}
    




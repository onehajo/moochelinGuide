const m = document.getElementsByClassName("message");
const messageContent = document.getElementById("messageContent");
const messageSend = document.getElementById("messageSend");
const close = document.getElementsByClassName("close")[0];
const messageNo = document.getElementsByName("messageNo");

if(!messageContent.classList.contains('activeP')){
        for(let i=0; i<m.length; i++){
        m[i].addEventListener("click",function(){
            //messageSend.classList.remove('activeP');
            //messageContent.classList.add('activeP');
            console.log(messageNo[i].value);
            
            const url ="detail?no="+messageNo[i].value;
            const name ="message-confirm";
            const option ="width = 400, height = 500, top = 100, left = 200, location = no";
            window.open(url, name, option);
            
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
    




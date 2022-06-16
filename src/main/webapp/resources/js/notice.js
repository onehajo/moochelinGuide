const carrot = document.getElementsByClassName("carrotdown");
const noticeArea = document.getElementsByClassName("notice2");
const area = document.getElementsByClassName("notice")[0];
const titleArea = document.getElementsByClassName("titleArea");
const noticeCArea = document.getElementsByClassName("noticeContent");

for(let i =1; i<noticeArea.length; i++){
    noticeCArea[i].style.display="none";
    carrot[i].innerHTML = "&#8743;";
}

for(let i=0; i<noticeArea.length; i++){
    titleArea[i].addEventListener("click",function(){
        if(noticeCArea[i].style.display=='none'){
            noticeCArea[i].style.display="block";
            carrot[i].innerHTML = "&#8744;";
        } else{
            noticeCArea[i].style.display="none";
            carrot[i].innerHTML = "&#8743;";
        }
        
  });
};


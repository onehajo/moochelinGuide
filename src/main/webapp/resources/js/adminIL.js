console.log("js 로드");

const optionList = document.getElementsByClassName("optionList")[0];
optionList.style.display = "none";
let view = 0;

document.getElementsByClassName("labelArea")[0].addEventListener("click",function(){
    
    if(view==0){
        optionList.style.display = "block";
        view= 1;
    } else{
        optionList.style.display = "none";
        view=0;
    }
});

$('html').click(function(e) {   
	if(!$(e.target).hasClass("labelArea")) {
		optionList.style.display = "none";
        view=0;
	}
}); 
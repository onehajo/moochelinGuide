console.log("js 로딩f");

function registValidate(){
    const textContent = document.getElementById("explain");
    
    console.log(textContent.value);
    if((textContent.value).trim().length==0){
        alert("내용을 입력해주세요");
        return false;
    }
    
    return true;
};
function registValidate(){
    const textContent = document.getElementById("explain");

    if(loginMemberNo==""){
        alert("로그인 후 이용해주세요");
        return false;
    }

    if((textContent.value).trim().length==0){
        alert("내용을 입력해주세요");
        textContent.focus();
        return false;
    }
    return true;
};

const inputImage = document.getElementById("imageFile");
const preview = document.getElementsByClassName("preview");
const deleteImage = document.getElementsByClassName("delete-Img");
const divImg = document.getElementsByClassName("img");
const imgArea = document.getElementsByClassName("imgArea")[0];
const imgUpload = document.getElementById("imageFile2");
var num = 0;
imgArea.style.display = "none";

    inputImage.addEventListener("change", function(){
        if(this.files[0] !=undefined){
            const reader = new FileReader();
            reader.readAsDataURL(this.files[0]);
            reader.onload = function(event){
                if(num==0){
                    preview[0].setAttribute("src",event.target.result);
                    imgArea.style.display = "block";
                    imgUpload.style.display="none";
                    num++;    
                } else{
                    alert("사진은 1장만 삽입할 수 있습니다");
                }
        }
    }
    });

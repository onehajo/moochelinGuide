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
const deleteImage = document.getElementsByClassName("delete-Img")[0];
const divImg = document.getElementsByClassName("img");
const imgArea = document.getElementsByClassName("imgArea")[0];
const imgUpload = document.getElementById("imageFile2");
const imageSt = document.getElementById("imageSt");


    inputImage.addEventListener("change", function(){
        if(preview[0]!=undefined){
            const reader = new FileReader();
            reader.readAsDataURL(this.files[0]);
            reader.onload = function(event){
                    preview[0].setAttribute("src",event.target.result);
                    imgArea.style.display = "block";
                    imgUpload.style.display="none";
                    imageSt.value = "2";
        }
    }
    });

deleteImage.addEventListener("click",function(){
   preview[0].removeAttribute("src");
   inputImage.value="";
   imgArea.style.display = "none";
    imgUpload.style.display="block";
    imageSt.value = "1";   
});
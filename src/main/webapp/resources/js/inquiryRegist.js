console.log("js 로딩1");

function registValidate(){
    const textContent = document.getElementById("explain");
    
    console.log(textContent.value);

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

const inputImage = document.getElementsByClassName("uploadfile");
const preview = document.getElementsByClassName("preview");
const deleteImage = document.getElementsByClassName("delete-Img");
const divImg = document.getElementsByClassName("img");
let num2 = 1;

for(let i=0; i<inputImage.length; i++){
    inputImage[i].addEventListener("change", function(){
        console.log("작동");
        if(preview[i] !=undefined){
            const reader = new FileReader();
            reader.readAsDataURL(this.files[0]);
            reader.onload = function(event){
                const area = document.getElementsByClassName("imgArea")[0];
              const newTag = document.createElement("div");
              const newImg = document.createElement("img");
              const newSpan = document.createElement("span");
              const newInput = document.createElement("input");
              newTag.setAttribute("class","img");
              newImg.setAttribute("class","preview");
              newSpan.setAttribute("class","delete-Img");
              
                newInput.setAttribute("type","file");
                newInput.setAttribute("id","uploadfile"+num2);
                newInput.setAttribute("class","uploadfile");
                newInput.setAttribute("name",num2);
                newInput.setAttribute("accept","image/*");
              document.getElementById("file-top").appendChild(newInput);

              document.getElementsByClassName("upload_btn")[0].setAttribute("for","uploadfile"+num2);
              if(num>0){
              area.appendChild(newTag);
              divImg[num].appendChild(newImg);
              divImg[num].appendChild(newSpan);
              deleteImage[num].innerHTML= "&times";
            }
              preview[num].setAttribute("src",event.target.result);
              num++;
              num2 ++;
              console.log(num);
        }
    }
    });
}
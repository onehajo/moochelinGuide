


$('.starRev span').click(function(){
    $(this).parent().children('span').removeClass('on');
    $(this).addClass('on').prevAll('span').addClass('on');
    return false;
  });



const loremIpsum = document.getElementById("lorem-ipsum")

fetch("https://baconipsum.com/api/?type=all-meat&paras=200&format=html")
    .then(response => response.text())
    .then(result => loremIpsum.innerHTML = result)
const modal = document.getElementById("modal")
function modalOn() {
    modal.style.display = "flex"
}
function isModalOn() {
    return modal.style.display === "flex"
}
function modalOff() {
    modal.style.display = "none"
}
const btnModal = document.getElementById("btn-modal")
btnModal.addEventListener("click", e => {
    modalOn()
})
const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modalOff()
})
modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modalOff()
    }
})
window.addEventListener("keyup", e => {
    if(isModalOn() && e.key === "Escape") {
        modalOff()
    }
})






//

// 코멘트 등록

const cmsave = document.getElementById("cm-save-btn");
const commentWrite = document.getElementById("comment-write");

cmsave.addEventListener("click",function(){ // 저장 버튼 클릭 이벤트

    // 로그인 여부 확인
    if(loginMemberNo == ""){
        alert("로그인 후 이용해주세요.");
        return;
    }

    // 내용 작성 여부 확인
    if(commentWrite.value.trim().lengh == 0 ){ // 미작성인 경우
        alert("코멘트를 작성한 후 저장해주세요!")

        commentWrite.value="";
        commentWrite.focus();
        return;
    }

    $.ajax({
        url : "insert",
        data : {"commentWrite" : commentWrite.value,
                "loginMemberNo" : loginMemberNo,
                "movieNo" : movieNo},
        type : "GET",
        success : function(result){
            
            if(result>0){
                alert("코멘트가 등록되었습니다.");

                commentWrite.value="";
            }else{
                alert("코멘트 등록에 실패했습니다.");
            }


        },

        error : function(req,status,error){
            console.log("코멘트 등록 실패")
            console.log(req.responseText);
        }


    })


});
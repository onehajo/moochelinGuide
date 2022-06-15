


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

const inputst = document.getAnimations("inputst")
const star05 = document.getElementById("star05")
const star10 = document.getElementById("star10")
const star15 = document.getElementById("star15")
const star20 = document.getElementById("star20")
const star25 = document.getElementById("star25")
const star30 = document.getElementById("star30")
const star35 = document.getElementById("star35")
const star40 = document.getElementById("star40")
const star45 = document.getElementById("star45")
const star50 = document.getElementById("star50")

star05.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "0.5";
    if(confirm(document.getElementById("inputst").innerHTML +"점을 주시겠어요?")){
        addRating();
        return;
    }else{
        false;
    }
})
star10.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "1.0";
    alert(document.getElementById("inputst").innerHTML);
})
star15.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "1.5";
    alert(document.getElementById("inputst").innerHTML);
})
star20.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "2.0";
    alert(document.getElementById("inputst").innerHTML);
})
star25.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "2.5";
    alert(document.getElementById("inputst").innerHTML);
})
star30.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "3.0";
    alert(document.getElementById("inputst").innerHTML);
})
star35.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "3.5";
    alert(document.getElementById("inputst").innerHTML);
})
star40.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "4.0";
    alert(document.getElementById("inputst").innerHTML);
})
star45.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "4.5";
    alert(document.getElementById("inputst").innerHTML);
})
star50.addEventListener("click",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "5.0";
    alert(document.getElementById("inputst").innerHTML);
})




star05.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "0.5";

})
star10.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "1.0";

})
star15.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "1.5";

})
star20.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "2.0";

})
star25.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "2.5";

})
star30.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "3.0";

})
star35.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "3.5";

})
star40.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "4.0";

})
star45.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "4.5";

})
star50.addEventListener("mouseover",function(){
    console.log("0.5");
    document.getElementById("inputst").innerHTML = "5.0";

})

function addRating(){
    // 로그인 여부 확인
    if(loginMemberNo == ""){
        alert("로그인 후 이용해주세요.");
        return;
    }

    $.ajax({
        url : "rating",
        data : {"inputst" : inputst.value,
                "loginMemberNo" : loginMemberNo,
                "movieNo" : movieNo},
        type : "GET",
        success : function(result){
            
            if(result>0){
                alert("별점이 등록되었습니다.");

                commentWrite.value="";
            }else{
                alert("별점 등록에 실패했습니다.");
            }


        },

        error : function(req,status,error){
            console.log("별점 등록 실패")
            console.log(req.responseText);
        }


    })
}
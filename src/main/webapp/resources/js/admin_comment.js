const searchBtn = document.getElementById("search-btn");
const query = document.getElementById("query");
const searchResult = document.getElementById("search-result");
const p = searchResult.firstElementChild;
const tbody = searchResult.firstElementChild.nextElementSibling.lastElementChild;

searchBtn.addEventListener("mouseup", function(){

    if(query.value.trim().length!=0){

        $.ajax({
            url : contextPath+"/admin/comment/search/title",
            data : {"query" : query.value},
            type : "GET",
            dataType : "JSON",
            success : function(movieList){
                if(movieList.length!=0){
                    console.log("영화 조회 성공");
                    console.log(movieList);
                    p.innerText = '"'+query.value+'"에 대한 코멘트 검색결과입니다. ';
                    tbody.innerHTML = "";

                    for(let movie of movieList){

                        console.log(movie.commentCount);

                        const td1 = document.createElement("td");
                        td1.innerText = movie.movieNo;

                        const td2 = document.createElement("td");
                        td2.innerText = movie.movieTitle;

                        const td3 = document.createElement("td");
                        td3.innerText = movie.releaseYear;

                        const td4 = document.createElement("td");
                        td4.innerText = movie.country;

                        const td5 = document.createElement("td");
                        td5.innerText = movie.commentCount;

                        const td6 = document.createElement("td");
                        td6.innerText = "";

                        const tr = document.createElement("tr");
                        tr.classList.add("selected");
                        tr.append(td1,td2,td3,td4,td5,td6);

                        tbody.append(tr);
                    }

                }else{
                    console.log("영화 조회 결과가 없습니다.");
                    p.innerText = '"'+query.value+'"에 대한 코멘트 검색결과가 없습니다. ';
                    tbody.innerHTML = "";
                }
            },
            error : function(request, status, error){
                console.log("AJAX 에러 발생");
                console.log("상태코드 : "+request.status); // 에러번호 404, 500 출력
            }
        });

    }else{
        Swal.fire({
            title: '검색어를 입력해주세요.',
            width: 600,
            padding: '3em',
            color: 'black',
            confirmButtonColor: '#392eff',
            confirmButtonText: '확인'
            });

    }

});

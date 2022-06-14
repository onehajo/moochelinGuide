const searchBtn = document.getElementById("search-btn");
const query = document.getElementById("query");
const searchResult = document.getElementById("search-result");

// 검색어 알려주는 p태그 생성
const p = document.createElement("p");

// 테이블 생성
const table = document.createElement("table");
table.setAttribute("border", "1px solid black");

searchBtn.addEventListener("click", function(){

    if(query.value.trim().length!=0){

        $.ajax({
            url : contextPath+"/admin/comment/search/title",
            data : {"query" : query.value},
            type : "GET",
            dataType : "JSON",
            success : function(movieList){

                p.innerText = '"'+query.value+'"에 대한 코멘트 검색결과 ( '+movieList.length+' )';

                const q = query.value;
                query.value = "";
                query.placeholder = q;

                table.innerHTML = "";

                if(movieList.length!=0){

                    const thead = document.createElement("thead");

                    const tr1 = document.createElement("tr");

                    const th1 = document.createElement("th");
                    th1.innerText = "영화코드";
                    th1.style.width = "100px";

                    const th2 = document.createElement("th");
                    th2.innerText = "영화제목";
                    th2.style.width = "400px";

                    const th3 = document.createElement("th");
                    th3.innerText = "개봉년도";
                    th3.style.width = "100px";

                    const th4 = document.createElement("th");
                    th4.innerText = "국가";
                    th4.style.width = "100px";

                    const th5 = document.createElement("th");
                    th5.innerText = "코멘트수";
                    th5.style.width = "100px";

                    const th6 = document.createElement("th");
                    th6.innerText = "기타";
                    th6.style.width = "100px";

                    tr1.append(th1,th2,th3,th4,th5,th6);

                    thead.append(tr1);

                    const tbody = document.createElement("tbody");

                    for(let movie of movieList){

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

                        const tr2 = document.createElement("tr");
                        tr2.classList.add("selected");
                        tr2.append(td1,td2,td3,td4,td5,td6);

                        tbody.append(tr2);
                    }

                    table.append(thead, tbody);

                    searchResult.append(p,table);

                    // 클릭한 행의 코멘트 조회
                    const select = document.getElementsByClassName("selected");
              
                    for(let i=0; i<select.length; i++){
                        select[i].addEventListener("click", function(){

                            const movieNo = select[i].firstElementChild.innerText;
                            console.log(i+"번째 요소 클릭함");
                            console.log(i+"번째 영화번호 : "+movieNo);

                            $.ajax({
                                url : contextPath+"/admin/comment/select/comment",
                                data : {"movieNo" : movieNo},
                                type : "GET",
                                dataType : "JSON",
                                success : function(cList){
                                    if(cList.length!=0){
                                        console.log("코멘트 조회 성공");
                                    }else{
                                        console.log("코멘트 조회 실패");
                                    }
                                },
                                error : function(request, status, error){
                                    console.log("AJAX 에러 발생");
                                    console.log("상태코드 : "+request.status); // 에러번호 404, 500 출력
                                }


                            });
                        });
                    }








                }else{
                    searchResult.append(p,table);
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


// 영화에 작성된 코멘트 조회, 삭제, 내용숨기기
// 코멘트에 내용 숨김여부 체크할 컬럼이 있어야할듯.............. ㅠㅠ
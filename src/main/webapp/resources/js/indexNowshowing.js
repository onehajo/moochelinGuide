






// 상영중인 영화 정보 노출
(function(){

    $.ajax({
        url: "movie/nowShowing",
        dataType: "json", 
        success: function(list){
		
            //console.log(list);
			const ul = document.getElementsByClassName("movie-list")[0];
            ul.innerHTML="";
			
			let num=0;
			for(let movie of list){
                const li = document.createElement("li");
                const a = document.createElement("a");
                a.setAttribute("herf","#");
                
                const divMovie = document.createElement("div");
                divMovie.setAttribute("class","movie");
                
                const divMovieTop = document.createElement("div");
                divMovieTop.setAttribute("class","movie-top");

                const divMoviePoster = document.createElement("div");
                divMoviePoster.setAttribute("class","movie-poster");

                const img = document.createElement("img");
                img.setAttribute("src",movie.posterImage); // 데이터 입력후 확인하기

                divMoviePoster.append(img);

                const divRanking = document.createElement("div");
                divRanking.setAttribute("class","ranking");
                num++
                divRanking.innerText=num; // 해당 데이터 없음, 순위 컬럼추가 후 다시 확인하기

                divMovieTop.append(divMoviePoster);
                divMovieTop.append(divRanking);

                const divMovieBottom = document.createElement("div");
                divMovieBottom.setAttribute("class","movie-bottom");

                const divMovieTitle = document.createElement("div");
                divMovieTitle.setAttribute("class","movie-title");
                divMovieTitle.innerText=movie.movieTitle // 데이터 입력후 확인하기

                const divMovieYC = document.createElement("div");
                divMovieYC.setAttribute("class","movie-year-contry");
                divMovieYC.innerText=movie.releaseYear+" ・ "+movie.country // 데이터 입력후 확인하기

                const divAvg = document.createElement("div");
                divAvg.setAttribute("class","average");
                
                const span1 = document.createElement("span");
                span1.innerText="평균"

                const svg = document.createElement("svg");
                svg.setAttribute("width","12");
                svg.setAttribute("height","10");
                svg.setAttribute("viewBox","0 0 12 10");
                svg.setAttribute("xmlns","http://www.w3.org/2000/svg");
                svg.setAttribute("fill","#555765");
                //svg.setAttribute("class","css-1g90l0x"); 필요없겠지?

                const path = document.createElement("path");
                path.setAttribute("fill-rule","evenodd");
                path.setAttribute("clip-rule","evenodd");
                path.setAttribute("d","M6 8.02L3.14233 9.91131C2.91094 10.0644 2.61352 9.84836 2.68767 9.58097L3.60334 6.27872L0.921531 4.14536C0.704379 3.97262 0.817982 3.62299 1.0952 3.61087L4.51878 3.46128L5.719 0.251483C5.81619 -0.00842059 6.18381 -0.00842094 6.281 0.251483L7.48122 3.46128L10.9048 3.61087C11.182 3.62299 11.2956 3.97262 11.0785 4.14536L8.39666 6.27872L9.31233 9.58097C9.38648 9.84836 9.08906 10.0644 8.85767 9.91131L6 8.02Z");

                svg.append(path);

                const span2 = document.createElement("span");
                span2.innerText="3.3 별점데이터 입력후 수정" // 데이터 입력후 수정-평균별점

                divAvg.append(span1);
                divAvg.append(svg);
                divAvg.append(span2);

                const divShowingInfo = document.createElement("div");
                divShowingInfo.setAttribute("class","showing-info");
                divShowingInfo.innerText="예매율 "+movie.ticketing+" ・ 누적 관객 "+movie.audience // 데이터 입력후 확인하기

                divMovieBottom.append(divMovieTitle);
                divMovieBottom.append(divMovieYC);
                divMovieBottom.append(divAvg);
                divMovieBottom.append(divShowingInfo);

                divMovie.append(divMovieTop);
                divMovie.append(divMovieBottom);
                a.append(divMovie);
                li.append(a);
                ul.append(li);

			}
		},
        error: function(){
            console.log("에러발생");
            console.log(request.responseText);
        }
    })

})();


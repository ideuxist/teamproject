let key = "90ad618fa3d2f888905f0b844cbb97df";
let posterBase_url = "https://image.tmdb.org/t/p/w500";
let popularityURL = `https://api.themoviedb.org/3/movie/popular?api_key=${key}&language=kr-KR&page=1`;
let list = ['영화 정보', '예매', '마이페이지', '상영관'];


fetch(popularityURL)
  .then(response => response.json())
  .then((res) => {
    console.log(res);
    // 데이터 위치 : res.results[n]....
    // 제목 : original_title
    // 인기도 : popularity
    // 포스터 : poster_path
    // 개봉일 : release_date
    // 점수 : vote_average
    // id : id
    // backdrop_path : backdrop_path

  
    // body
    // image -> a -> td -> tr -> table
    let tr = document.createElement('tr');
    let td = document.createElement('td');
    for(let i = 0; i < 4; i++){
      // poster 주소값
      let poster = posterBase_url + res.results[i].poster_path;
      let movie_id = res.results[i].id;
      let movie_title = res.results[i].original_title;


      // img 태그 생성 및 속성 값 설정
      let imgTag = document.createElement('img');
      let aTag = document.createElement('a');
      

      aTag.appendChild(imgTag);
      td.appendChild(aTag);
      tr.appendChild(td);
      table.appendChild(tr);
      

      imgTag.setAttribute('width', '300');
      imgTag.setAttribute('class', 'layer')
      aTag.href = '/src/main/webapp/do.html';
      console.log(movie_title);
      aTag.value = movie_title;
      imgTag.src = poster;
      
      
    }



    
  })
  .catch(error => console.log(error));


  
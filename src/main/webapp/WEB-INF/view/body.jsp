<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table tr{
		text-align: center;
	}
</style>
</head>
<body>
	<form action ="" method = "post">
	<table id ="table">
	</table>
	<script type="text/javascript">
		
		 let key = "90ad618fa3d2f888905f0b844cbb97df";
		 let posterBase_url = "https://image.tmdb.org/t/p/w500";
		 let popularityURL = "https://api.themoviedb.org/3/movie/popular?api_key=" + key + "&language=kr-KR&page=1";

		console.log(popularityURL);
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
	
		    let tr = document.createElement('tr');
		    let td = document.createElement('td');
	
		    // 메인 화면 포스터 생성
		    for(let i = 0; i < 4; i++){
		      // poster 주소값
		      let poster = posterBase_url + res.results[i].poster_path;
		      let movie_id = res.results[i].id;
		      let movie_title = res.results[i].original_title;
	
	
		      let imgTag = document.createElement('img');
		      let aTag = document.createElement('a');
		      
		      // image -> a -> td -> tr -> table
		      aTag.appendChild(imgTag);
		      td.appendChild(aTag);
		      tr.appendChild(td);
		      table.appendChild(tr);
		      
		      
		      // 속성값 부여
		      imgTag.setAttribute('width', '300');
		      imgTag.setAttribute('class', 'layer')
		      aTag.href = '../do.search';
		      aTag.value = movie_title;
		      console.log(aTag.value);
		      console.log(movie_title);
		      imgTag.src = poster;
		    }

		  })
		  .catch(error => console.log(error));
	</script>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
.seat {
	width: 30px;
	height: 30px;
}

.clicked {
	background-color: red;
	color: white;
}
</style>
</head>

<body>
	<!-- 상영가능일 불러오기 -->
	<form
		action="${pageContext.servletContext.contextPath}/screeningChoice" method="post">
		상영날짜선택 : <input type = "submit" value="상영일선택">
		           <input type = "hidden" name="choice" value="choiceDate"> <br>
		<br>
	</form>
	
	<!-- 해당 상영일 선택가능 영화 불러오기 -->
	<form action="${pageContext.servletContext.contextPath}/screeningChoice" method="post">
				<c:forEach items="${seeDate}" var="date">
					<input type="radio" name="selectedDate" value="${date.screeningStart }">${date.screeningStart }<br>
				</c:forEach>
		영화 선택 : <input type="submit" value="상영작보기">
						 <input type="hidden" name="choice" value="currentMovie">
	</form>
	
	<!-- 해당 상영일 선택영화 가능회차 불러오기 -->	
	<form action="${pageContext.servletContext.contextPath}/screeningChoice" method="post">
		<c:forEach items="${movieList}" var="movie">
			<input type="radio" name="seemovie" value="${movie.movieTitle}">${movie.movieTitle }(${selectedDate })<br>
			<input type="hidden" name="selectedDate" value="${selectedDate}">
			<br>
		</c:forEach>
		<br> 회차 선택 : <input type="submit" value="상영 회차 조회">
		<input type="hidden" name="choice" value="round">
	</form>
	
	<form action="" method="post">
		<c:forEach items="${all3}" var="round">
			<input type="radio" name="seeround" value=${round.round }>${round.round }회차<br>
			<br>
			<input type="hidden" name="date" value="${date }">
			<input type="hidden" name="movie" value="${movie }">
		</c:forEach>
		<br> 선택완료: <input type="submit" value="선택완료"><br>
		<br>
	</form>
	<hr>
	<hr>
	<form action="" method="post">
		상영일:<input type="text" name="date" value="${date }" readonly><br>
		<br> 상영영화:<input type="text" name="movie" value="${movie }"
			readonly><br>
		<br> 회차:<input type="text" name="round" value="${round }"
			readonly><br>
		<br> <input type="submit" value="좌석선택"><br>
		<br>
	</form>

	<div></div>
	<div class="seat-wrapper"></div>

</body>

<script>
	/* //start viewseat
	 let test = [];
	 let selectedSeats = new Array();
	 let selectedSeatsMap = [];
	 const seatWrapper = document.querySelector(".seat-wrapper");
	 let clicked = "";
	 let div = "";

	 for (let i = 0; i < 7; i++) {
	 div = document.createElement("div");
	 seatWrapper.append(div);
	 for (let j = 0; j < 7; j++) {
	 const input = document.createElement('input');
	 input.type = "button";
	 input.name = "seats"
	 input.classList = "seat";
	 //3중포문을 사용하지 않기위해 
	 mapping(input, i, j);
	 div.append(input);
	 input.addEventListener('click', function(e) {
	 console.log(e.target.value);
	 //중복방지 함수
	 selectedSeats = selectedSeats.filter((element, index) => selectedSeats.indexOf(element) != index);

	 //click class가 존재할때(제거해주는 toggle)
	 if (input.classList.contains("clicked")) {
	 input.classList.remove("clicked");
	 clicked = document.querySelectorAll(".clicked");
	 selectedSeats.splice(selectedSeats.indexOf(e.target.value), 1);
	 clicked.forEach((data) => {
	 selectedSeats.push(data.value);
	 });
	 //click class가 존재하지 않을때 (추가해주는 toggle)
	 } else {
	 input.classList.add("clicked");
	 clicked = document.querySelectorAll(".clicked");
	 clicked.forEach((data) => {
	 selectedSeats.push(data.value);
	 })
	 }
	 console.log(selectedSeats);
	 })
	 }
	 }

	 function mapping(input, i, j) {
	 if (i === 0) {
	 input.value = "A" + j;
	 } else if (i === 1) {
	 input.value = "B" + j;
	 } else if (i === 2) {
	 input.value = "C" + j;
	 } else if (i === 3) {
	 input.value = "D" + j;
	 } else if (i === 4) {
	 input.value = "E" + j;
	 } else if (i === 5) {
	 input.value = "F" + j;
	 } else if (i === 6) {
	 input.value = "G" + j;
	 }
	 } //end of viewseat */
</script>
<%@page import="co.movie.vo.ReserDate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form action="${pageContext.servletContext.contextPath}/reservation" method="post">
		상영날짜선택 : <input type="submit" name="seeDate" value="가능일보기" id = "datechoice"><br><br>
	</form>
	<form action="${pageContext.servletContext.contextPath}/reservation2" method="post">
			        <c:forEach items="${all}" var="date">
					<input type = "radio" name ="seedate" value="${date.date }">${date.date }<br><br>
					</c:forEach>
					<br>		
		영화 선택 : <input type="submit" name="movieTitle" value="상영작보기" id = "moviechoice"><br><br>
	</form>
	<form action="${pageContext.servletContext.contextPath}/reservation3" method="post">
			        <c:forEach items="${all2}" var="movie">
					<input type = "radio" name ="seemovie" value="${movie.title}">${movie.title }<br><br>
					<input type = "hidden" name = "date" value = "${seedate }">
					</c:forEach>
					<br>		
        회차 선택 : <input type="submit" value="상영 회차 조회">
	</form>
	<form action="${pageContext.servletContext.contextPath}/reservation4" method="post">
	<c:forEach items="${all3}" var="round">
					<input type = "radio" name ="seeround" value=${round.round }>${round.round }회차<br><br>
					<input type = "hidden" name = "date" value = "${date }">
                    <input type = "hidden" name = "movie" value = "${movie }">					
					</c:forEach>
					<br>		
	 선택완료: <input type="submit" value="선택완료"><br><br>
	</form>
	<hr><hr>
	<form  action="${pageContext.servletContext.contextPath}/reservation5" method="post">
			상영일:<input type = "text" name = "date" value="${date }" readonly><br><br>
			상영영화:<input type = "text" name = "movie" value="${movie }" readonly><br><br>
			회차:<input type = "text" name = "round" value="${round }" readonly><br><br>
	<input type="submit" value="좌석선택"><br><br>
	</form>
<div class="seat-wrapper"></div>

</body>

<script>
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
}


</script>
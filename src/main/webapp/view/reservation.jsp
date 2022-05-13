<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<form action="../reservation" method="post">
		예약 일시 : <input type="date" name="seeDate"><br><br> 
		영화 선택 : <input type="radio" name="movie" value="1">영화1
		         <input type="radio" name="movie" value="2">영화2
		         <input type="radio" name="movie" value="3">영화3<br><br> 
		회차 선택 : <input type = "radio" name="round" value="1">1회
		         <input type = "radio" name="round" value="2">2회
		         <input type = "radio" name="round" value="3">3회<br><br>     
		         <input type="submit" value="선택">
	</form>
</body>

</script>
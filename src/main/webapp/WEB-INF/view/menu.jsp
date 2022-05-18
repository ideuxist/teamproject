<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>메인화면입니다</title>
</head>
<body>


	<!-- Sidebar-->
	  <div class="border-end bg-white" id="sidebar-wrapper">
		<div class="sidebar-heading border-bottom bg-light">Start
			Bootstrap</div>
		<div class="list-group list-group-flush">
			  <a class="list-group-item list-group-item-action list-group-item-light p-3"
				href="${pageContext.request.contextPath}/view/">현재 상영작</a> 
			  <a class="list-group-item list-group-item-action list-group-item-light p-3"
				href="${pageContext.request.contextPath}/reservation/reservation.tiles">빠른 예매</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3"
				href="${pageContext.request.contextPath}/view/">마이페이지</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3"
				href="${pageContext.request.contextPath}/view/">예정 메뉴1</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3"
				href="${pageContext.request.contextPath}/view/">예정메뉴2</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3"
				href="${pageContext.request.contextPath}/board/listArticle.tiles">자유게시판</a>
		</div>
	</div>

</body>
</html>
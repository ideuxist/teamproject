<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login, logout</title>
	<style>
		#login{
			text-align: right;
		}
	</style>
</head>
<body>
	<%
	String id = (String)session.getAttribute("id");
	%>
	<div id = "login">
	<form action ="${pageContext.servletContext.contextPath}/login.do" method = "post">
		아이디 : <input type = "text" name = "id">
		비밀번호 : <input type = "text" name = "password">
		<input type ="submit" value ="로그인" >
	</form>
	<form action = "${pageContext.servletContext.contextPath}/member.view/join.jsp" method = "post">
		<input type = "submit" value = "회원가입">
	</form>
	</div>


	
	
</body>
</html>
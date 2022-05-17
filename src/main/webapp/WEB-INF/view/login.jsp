<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="${pageContext.servletContext.contextPath}/login.do" method = "post">
		아이디 : <input type = "text" name = "id">
		비밀번호 : <input type = "text" name = "password">
		<input type ="submit" value ="로그인" >
		<input type = "button" value = "회원가입">
	</form>
</body>
</html>
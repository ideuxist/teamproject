<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath }/memberFindId.do" method="post">
가입할 때 사용한 이메일 주소를 입력하세요<br>
<input type="email" name="email"> 
<input type="submit" value="확인">
</form>
</body>
</html>
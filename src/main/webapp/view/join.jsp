<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>회원가입 페이지입니다</h3>
  <form action="${pageContext.servletContext.contextPath }/memberInsert.do" method="post">
    이름 <input type="text" name="name"><br>
    아이디 <input type="text" name="id"><br>
   	비밀번호 <input type="password" name="passwd"><br>
   	<input type="submit" value="회원가입"><br> 
  </form>
  
</body>
</html>
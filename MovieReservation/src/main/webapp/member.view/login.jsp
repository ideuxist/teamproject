<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

</style>
<body>
  <h3>로그인 페이지입니다</h3>
  <h3>${error }</h3>
  <h3>${result }</h3>
  
  <form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="get">
  <input type="text" name="id" placeholder="아이디"><br>
  <input type="password" name="passwd" placeholder="비밀번호"><br>
  <input type="hidden" name="job" value="search">
  <input type="submit" value="로그인"><br>
  <input type="button" value="취소" onclick="location.href='../testIndex.jsp'">
  </form>
</body>
</html>
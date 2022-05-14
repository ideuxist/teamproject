<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 로그인 페이지만 세 개째 만드는 중 ㅎㅎ -->
<!-- 코드 중복 해결 필요함 -->
<!-- 처음에 로그인하고 그 아이디의 파라메터를 어떻게 계속 다른 곳들로 넘겨주지? -->
</head>
<body>
<h3>비번수정</h3>
<h3>정보 확인을 위해 한 번 더 로그인해 주세요</h3>
<h3>${error }</h3>
  <h3>${result }</h3>
  <form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="post">
  <input type="text" name="id" placeholder="아이디"><br>
  <input type="password" name="passwd" placeholder="비밀번호"><br>
  <input type="hidden" name="job" value="update">
  <input type="submit" value="로그인"><br>
  </form>

</body>
</html>
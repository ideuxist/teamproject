<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 마이페이지에서 예매내역 메뉴로 넘어갈 때 --!> 
<!-- movieHistory() sql문 where절에 들어갈 id 파라메터 가져와서 바로 리스트 뿌릴 방법을 못찾음 --!> 
<!-- id 파라메터 값을 받기 위해 로그인 한 번 더 시킴 -->
<!-- 비밀번호 변경은 개인정보니까 보안을 위해 한 번 더 로그인 시켜도 이해 가능 예매 내역을 위해 다시 로그인하는건 굳이? -->
<!-- 다른 방법 강구 필요 -->
<h3>예매내역확인</h3>
<h3>정보 확인을 위해 한 번 더 로그인해 주세요</h3>
<h3>${error }</h3>
  <h3>${result }</h3>
  <form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="post">
  <input type="text" name="id" placeholder="아이디"><br>
  <input type="password" name="passwd" placeholder="비밀번호"><br>
  <input type="hidden" name="job" value="history">
  <input type="submit" value="로그인"><br>
  </form>

</body>
</html>
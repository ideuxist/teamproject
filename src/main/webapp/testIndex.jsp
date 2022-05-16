<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index test</title>
<script type="text/javascript">
        
        // 로그아웃 담당 JSP로 이동
        function logout(){
            location.href="${pageContext.servletContext.contextPath }/view/logout.jsp";
        }
    </script>
</head>
<body>
<h3>임시메인입니다</h3>
<% 
String id = (String) session.getAttribute("id");
String pw = (String) session.getAttribute("pass");

out.print(id);

%>
<input type="button" value="로그아웃" onclick="logout()">
<a href="view/join.jsp">회원가입</a>
<a href="view/login.jsp">로그인</a>
<a href="view/mypage.jsp">마이페이지</a>
</body>
</html>
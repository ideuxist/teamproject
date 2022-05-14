<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<c:if test="${!empty result }"><h4>${result }</h4></c:if>
<c:if test="${!empty member }">
		<h4>환영합니다. ${member.name } 님!</h4>
		<h4>즐거운 시간 되세요!</h4>
	</c:if> 
<jsp:include page="booking.jsp"></jsp:include>
</body>
</html>
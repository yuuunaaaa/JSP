<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 1. 쿠키 객체 생성, 브라우저에 저장할 정보 1개당 쿠키 1개
	Cookie c1 = new Cookie("category", "운동");
	Cookie c2 = new Cookie("fav", "축구");
	
	// 2. 쿠키를 서버에 브라우저로 보낸다
	response.addCookie(c1);
	response.addCookie(c2);
%>
<hr>
브라우저에 쿠키 심음~~🍪🍪<br>
<a href="page02.jsp">쿠키 리스트 가지고 오기</a>
</body>
</html>
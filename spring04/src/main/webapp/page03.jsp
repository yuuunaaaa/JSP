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
	session.setAttribute("count", 100);
	session.setAttribute("user", "root");
%>
<hr>서버에 세션 등록함
<a href="page04.jsp">session 속성 가지고 오기</a>
</body>
</html>
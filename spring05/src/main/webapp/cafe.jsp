<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
공동구매할 물건<br>
<img src="resources/img/cinamoroll.ico"><br>
<% if(session.getAttribute("id") != null){ %>
	<a href="bbb"><button style="background: lightblue;">공동구매 참여</button></a>
<%} %>
</body>
</html>
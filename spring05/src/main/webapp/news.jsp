<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
뉴스 제목<br>
뉴스 내용<br>
<% if(session.getAttribute("id") != null){ %>
	<form action="aaa">
		댓글 : <input name="reply"><button style="background: lightblue;">댓글달기</button>
	</form>
<%} %>
</body>
</html>
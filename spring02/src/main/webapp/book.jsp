<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>북마크 페이지입니다.  </h3>
<hr color="blue">
<form action="insert3.multi" method="get">
	name : <input name="name"><br>
	url : <input name="url"><br>
	img : <input name="img"><br>
	<button type="submit">서버로 전송</button>
</form>
</body>
</html>
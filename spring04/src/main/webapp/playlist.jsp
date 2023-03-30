<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background : lightblue;
}
</style>

</head>
<body>
<a href="list5.multi">모든 음악 정보 가지고 오기</a>
<hr color="blue">

<h3>음악 등록 화면입니다. </h3>
<hr color="blue">
<form action="insert5.multi" method="get">
	id : <input name="id" value="1"><br>
	title : <input name="title"><br>
	artist : <input name="artist"><br>
	genre : <input name="genre"><br>
	img : <input name="img" type="file" ><br>
	<button type="submit">서버로 전송</button>
</form>
<hr color="blue">

<h3>음악 수정 화면입니다. </h3>
<hr color="blue">
<form action="update5.multi" method="get">
	id : <input name="id" value="1"><br>
	title : <input name="title"><br>
	<button type="submit">서버로 전송</button>
</form>
<hr color="blue">

<h3>음악 삭제 화면입니다. </h3>
<hr color="blue">
<form action="delete5.multi" method="get">
	id : <input name="id" value="1"><br>
	<button type="submit">서버로 전송</button>
</form>
<hr color="blue">

<h3>음악 검색 화면입니다. </h3>
<hr color="blue">
<form action="one5.multi" method="get">
	id : <input name="id" value="1"><br>
	<button type="submit">서버로 전송</button>
</form>
<hr color="blue">

<button type="button">먹통버튼(아무 기능이 없음)</button>
</body>
</html>
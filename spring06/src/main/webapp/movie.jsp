<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	$(function() { //body부분이 dom tree로 메모리에 준비가 되었을 때, 
		//입력값으로 넣은 함수를 실행해주세요.
		//alert("월컴...월요일~~~")
		$('#b2').click(function() {
			$.ajax({
				url : "movie",
				data : {
					title : $('#title').val(),
					price : $('#price').val()
				},
				success : function(x) {
					alert('computer요청 성공!' )
					alert(x)
					$('#result').append(x + "<br>")
				},
				error : function() {
					alert('computer요청 실패!')
				} //error
			}) //ajax
		})//b2
		$('#b3').click(function() {
			$.ajax({
				url : "fruit",
				success : function(x) {
					alert('fruit요청 성공!' )
					alert(x)
					$('#result').append(x + "<br>")
				},
				error : function() {
					alert('computer요청 실패!')
				} //error
			}) //ajax
		})//b3
		$('#b4').click(function() {
			$.ajax({
				url : "tour",
				success : function(x) {
					alert('tour요청 성공!' )
					alert(x)
					$('#result').append(x + "<br>")
				},
				error : function() {
					alert('tour요청 실패!')
				} //error
			}) //ajax
		})//b3
	}) //$
</script>
</head>
<body>
	영화 제목 : <input id="title"><br>
	영화 관람료 : <input id="price"><br>
	<hr color="lightblue">
	<input id="b2" type="button" value="영화 관람 확인">
	<input id="b3" type="button" value="과일 목록 가지고 오기">
	<input id="b4" type="button" value="여행 목록 가지고 오기">
	<br>
	<hr color="lightblue">
	<div id="result"></div>
</body>
</html>
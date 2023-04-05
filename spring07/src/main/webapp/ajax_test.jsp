<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	$(function() {
		$('#b1').click(function() {
			// 기존의 것 삭제
			$('#result').empty()
			$.ajax({
				url:"list5",
				success : function(x){
					$('#result').append(x)
				} // success
			})// ajax
		}) // b1
		
		$('#b2').click(function() {
			// 기존의 것 삭제
			$('#result').empty()
			$.ajax({
				url:"list6",
				data : {
					bbsno : 1
				},
				success : function(x){
					$('#result').append(x)
				} // success
			})// ajax
		}) // b2
		
		$('#b3').click(function() {
			// 기존의 것 삭제
			$('#result').empty()
			$.ajax({
				url:"list6",
				data : {
					bbsno : 10
				},
				success : function(x){
					$('#result').append(x)
				} // success
			})// ajax
		}) // b3
		
		$('#b4').click(function() {
			// 기존의 것 삭제
			$('#result').empty()
			$.ajax({
				url:"one5",
				data : {
					id : "apple"
				},
				success : function(x){
					$('#result').append(x)
				} // success
			})// ajax
		}) // b4
		
		$('#b5').click(function() {
			// 기존의 것 삭제
			$('#result').empty()
			$.ajax({
				url:"one6",
				data : {
					no : 1
				},
				success : function(x){
					$('#result').append(x)
				} // success
			})// ajax
		}) // b5
		
		$('#b6').click(function() {
			// 기존의 것 삭제
			$('#result').empty()
			$.ajax({
				url:"list7",
				success : function(x){
					$('#result').append(x)
				} // success
			})// ajax
		}) // b6
	}) // $
</script>
</head>
<body>
<button id="b1">bbs 리스트 가지고 오기</button>
<button id="b2">bbs 번호 1번 reply 리스트 가지고 오기</button>
<button id="b3">bbs 번호 10번 reply 리스트 가지고 오기</button>
<button id="b4">member id가 apple인사람의 정보 가지고 오기</button>
<button id="b5">bbs no가 1인사람의 정보 가지고 오기</button>
<button id="b6">member의 모든 리스트 가지고 오기</button>
<hr color="lightblue">
<div id="result" style="background: lightblue"></div>
</body>
</html>
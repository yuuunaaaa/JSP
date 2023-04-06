<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- content delivery network  : CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#b1').click(function() {
			$('#result').empty()
			$.ajax({
				url: "json3",
				dataType : "json",
				success: function(json) {
					no = json.no
					title = json.title
					content = json.content
					writer = json.writer
					table = "<table><tr><td>항목명</td><td>값</td></tr>" + 
					"<tr><td>no</td><td>" + no +"</td></tr>" + 
					"<tr><td>title</td><td>" + title +"</td></tr>" + 
					"<tr><td>content</td><td>" + content +"</td></tr>" + 
					"<tr><td>writer</td><td>" + writer +"</td></tr></table>"
					$('#result').append(table)
				} //success
			}) //ajax
		})//b1
		$('#b2').click(function() {
			$('#result').empty()
			$.ajax({
				url: "one22",
				data : {
					no:1
				},
				dataType : "json",
				success: function(json) {
					no = json.no
					content = json.content
					$('#result').append(no + " " + content + "<br>")
				} //success
			}) //ajax
		})//b2
		
		$('#b3').click(function() {
			$('#result').empty()
			$.ajax({
				url: "list55",
				dataType : "json",
				success: function(json) {//[{}, {id: "", name: "", pw : "", tel: ""}]
					no1 = json[1].no
					content1 = json[1].content
					$('#result').append("json배열 중 2번째 것>> " + no1 + " " + content1 + "<br>")
					
				} //success
			}) //ajax
		})//b2
	})//$
</script>

</head>
<body>
<button id="b1">컨트롤러에서 bbs JSON(text)을 받아오자.!</button>
<button id="b2">컨트롤러에서 bbs JSON(table)를 받아오자.!</button>
<button id="b3">컨트롤러에서 bbs JSONArray를 받아오자.!</button>
	
<hr color="lightblue">
<div id="result"></div>
</body>
</html>
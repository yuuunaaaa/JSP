<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#b1').click(function() {
			$('#result').empty()
			$.ajax({
				url:"json.jsp",
				success : function(json) {
					age1 = json.age
					name1 = json.name
					id1 = json.id
					$('#result').append(age1 + " " + name1 + " " + id1 + "<br>")
				}
			})
		})
		$('#b2').click(function() {
			$('#result').empty()
			$.ajax({
				url:"json2.jsp",
				success : function(json) {
					age1 = json[0].age
					name1 = json[0].name
					id1 = json[0].id
					$('#result').append(age1 + " " + name1 + " " + id1 + "<br>")
				}
			})
		})
		$('#b3').click(function() {
			$('#result').empty()
			$.ajax({
				url: "json3.jsp",
				dataType : "json",
				success: function(json) {
					weather = json.weather
					temp = json.temp
					humid = json.humid
					$('#result').append(weather + " " + temp + " " + humid + "<br>")
					if(weather == 'rain') {
						$('#result').append("<img src=resources/img/rain.png><br>")
					}else if(weather == 'sun'){
						$('#result').append("<img src=resources/img/sun.jpg><br>")
					}
				} //success
			}) //ajax
		})//b1
		$('#b4').click(function() {
			$('#result').empty()
			$.ajax({
				url:"json4.jsp",
				dataType : "json",
				success : function(json) {
					high1 = json[0].high
					low1 = json[0].low
					end1 = json[0].end
					
					high2 = json[1].high
					low2 = json[1].low
					end2 = json[1].end
					$('#result').append("어제 주가 : " + high1 + " " + low1 + " " + end1 + "<br>")
					$('#result').append("오늘 주가 : " + high2 + " " + low2 + " " + end2 + "<br>")
				}
			})
		})
	})
</script>
</head>
<body>
<button id="b1">JSON을 받아오자!</button>
<button id="b2">JSONArray를 받아오자!</button>
<button id="b3">JSON3을 받아오자!</button>
<button id="b4">JSONArray4를 받아오자!</button>
<hr color="lightblue">
<div id="result"></div>
</body>
</html>
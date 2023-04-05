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
		$('#result').empty()
		$.ajax({
			url : "list5",
			success : function(x) {
				$('#result').append(x)
			} // success
		})

		$('#b1').click(function() {
			$('#result').empty()
			$.ajax({
				url : "update5",
				data : {
					no : $('#no').val(),
					content : $('#content').val()
				},
				success : function(x) {
					alert('수정 완료!!')
					//document.location.reload()
					location.href="ajax_test2.jsp";
				}
			}) //ajax
		})//b1

		$('#b2').click(function() {
			// 기존의 것 삭제
			$('#result').empty()
			$.ajax({
				url : "delete5",
				data : {
					no : $('#no2').val()
				},
				success : function(x) {
					alert('삭제 완료!!')
					location.href="ajax_test2.jsp";
				} // success
			})// ajax
		}) // b2

		$('#b3').click(function() {
			// 기존의 것 삭제
			$('#result').empty()
			$.ajax({
				/* crossOrigin: true,
				url:'https://api.openweathermap.org/data/2.8/onecall?lat='+ lat +'&lon='+lon+'&exclude=hourly,daily,minutely&appid=43238037f8f84c1b9d70369513a425e6',
				dataType : 'json',
				success: function(x){
					console.log(x);
					$('#result').html("현재 위도 경도 "+x.lat+ " , " + x.lon+"<br>"+
							"날씨"+x.current.weather[0].description+"<br>"+
							"풍속"+x.current.wind_speed+"<br>"+
							"기온"+x.current.temp+"<br>"+
							"체감 온도"+x.current.feels_like+"<br>"+
							"구름"+x.current.clouds+"<br>")
				} */
				crossOrigin: true,
				url : "http://api.openweathermap.org/data/2.5/weather?q=+seoul&units=metric&lang=kr&appid=2a25bb895f4cc7dfbb15b1613c75175b",
				dataType: 'json',
				success : function(data) {
					console.log(data)
					$('#result').html("위치 : " + data.name + "<br>" +
							"날씨 : " + data.weather[0].description + "<br>" +
							"풍속 : " + data.wind.speed + "<br>" +
							"최고 기온 : " + data.main.temp_max + "<br>" +
							"최저 기온 : " + data.main.temp_min + "<br>" +
							"체감 온도 : " + data.name.feels_like + "<br>" +
							"구름 : " + data.clouds.all)
				} // success
			})// ajax
		}) // b3
	}) // $
</script>
</head>
<body>
	no :
	<input id="no">
	<br> content :
	<input id="content">
	<button id="b1">bbs 수정</button>
	<br>
	<hr color="lightblue">
	삭제할 no :
	<input id="no2">
	<button id="b2">bbs 삭제</button>
	<br>
	<hr color="lightblue">
	<button id="b3">날씨 알아오기</button>
	<br>
	<hr color="lightblue">
	<div id="result" style="background: lightblue">
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4adb0174731243b5ccf71f72664c9320"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#b1').click(
				function() {
					$('#result').empty()
					$.ajax({
						url : "jsonResponse3",
						dataType : "json",
						success : function(json) {
							id = json.id
							pw = json.pw
							name = json.name
							tel = json.tel
							table = "<table><tr><td>항목명</td><td>값</td></tr>"
									+ "<tr><td>id</td><td>" + id + "</td></tr>"
									+ "<tr><td>pw</td><td>" + pw + "</td></tr>"
									+ "<tr><td>name</td><td>" + name
									+ "</td></tr>" + "<tr><td>tel</td><td>"
									+ tel + "</td></tr></table>"
							$('#result').append(table)
						} //success
					}) //ajax
				})//b1
		$('#b2').click(
				function() {
					$('#result').empty()
					$.ajax({
						url : "jsonResponse4",
						dataType : "json",
						success : function(json) {
							id1 = json[0].id
							pw1 = json[0].pw
							name1 = json[0].name
							tel1 = json[0].tel //json에서 tel키로 값을 추출
							
							id2 = json[1].id
							pw2 = json[1].pw
							name2 = json[1].name
							tel2 = json[1].tel //json에서 tel키로 값을 추출
							
							id3 = json[2].id
							pw3 = json[2].pw
							name3 = json[2].name
							tel3 = json[2].tel //json에서 tel키로 값을 추출
							
							$('#result').append("json배열 중 1번째 것>> " + id1 + " " + pw1 +  " " + name1 +  " " + tel1 + "<br>")
							$('#result').append("json배열 중 2번째 것>> " + id2 + " " + pw2 +  " " + name2 +  " " + tel2 + "<br>")
							$('#result').append("json배열 중 3번째 것>> " + id3 + " " + pw3 +  " " + name3 +  " " + tel3 + "<br>")
							table = "<table><tr><td>항목명</td><td>1</td><td>2</td><td>3</td></tr>"
									+ "<tr><td>아이디</td><td>" + id1 + "</td><td>" + id2 + "</td><td>" + id3 + "</td></tr>"
									+ "<tr><td>패스워드</td><td>" + pw1 + "</td><td>" + pw2 + "</td><td>" + pw3 + "</td></tr>"
									+ "<tr><td>이름</td><td>" + name1 + "</td><td>" + name2 + "</td><td>" + name3 + "</td></tr>"
									+ "<tr><td>전화번호</td><td>" + tel1 + "</td>><td>" + tel2 + "</td>><td>" + tel3 + "</td></tr></table>"
							$('#result').append(table)
						} //success
					}) //ajax
				})//b2
		$('#b3').click(
				function() {
					$('#result').empty()
					$.ajax({
						url : "jsonResponse5",
						dataType : "json",
						success : function(json) {
							name = json.name
							latitude = json.latitude
							longitude = json.longitude
							var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
						    mapOption = { 
						        center: new kakao.maps.LatLng(latitude, longitude), // 지도의 중심좌표
						        level: 3 // 지도의 확대 레벨
						    };

							var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
							// 마커가 표시될 위치입니다 
							var markerPosition  = new kakao.maps.LatLng(latitude, longitude); 
	
							// 마커를 생성합니다
							var marker = new kakao.maps.Marker({
							    position: markerPosition
							});
	
							// 마커가 지도 위에 표시되도록 설정합니다
							marker.setMap(map);
						} //success
					}) //ajax
				})//b3
		$('#b4').click(
				function() {
					$('#result').empty()
					$.ajax({
						url : "jsonResponse6",
						dataType : "json",
						success : function(json) {
							
							coding = json.coding
							eat = json.eat
							rest = json.rest
							sleep = json.sleep
							
							google.charts.load('current', {'packages':['corechart']});
						    google.charts.setOnLoadCallback(drawChart);
						    function drawChart() {
						      var data = google.visualization.arrayToDataTable([
						          ['Task', 'Hours per Day'],
						          ['Coding',coding],
						          ['Eat',      eat],
						          ['Rest',rest],
						          ['Sleep',sleep]
						      ]);

						      var options = {
						          title: 'My Daily Activities',
						          is3D: true,
						      };

						      var chart = new google.visualization.PieChart(document.getElementById('map'));
						      chart.draw(data, options);
						      }
						    
						} //success
					}) //ajax
				})//b4
//구글 차트에 보낼 데이터(각 차트에 맞추어)를 json으로 받아 구글 차트에 json을 넣어, 차트를 표시해보세요.!
	})//$
</script>
</head>
<body>
	<button id="b1">jsonResponse3</button>
	<button id="b2">jsonResponse4</button>
	<button id="b3">jsonResponse5</button>
	<button id="b4">jsonResponse6</button>

	<hr color="lightblue">
	<div id="result"></div>
	<div id="map" style="width:100%;height:350px;"></div>
	<!-- <div id="piechart_3d" style="width: 900px; height: 500px;"></div> -->
</body>
</html>
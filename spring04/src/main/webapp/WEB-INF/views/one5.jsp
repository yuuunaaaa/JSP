<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background: lightblue;
}
td{
	width: 100px;
	text-align: center;
}
.top{
	background: black;
	color: white;
}
</style>
</head>
<body>
<!--  표현식(expression) --> 
음악 검색 완료<br>
<button onclick="location.href='playlist.jsp'">처음으로</button ><br>
<div class="container">                     
  <table class="table table-hover">
    <thead>
      <tr>
        <td class="top">id</td>
		<td class="top">title</td>
		<td class="top">artist</td>
		<td class="top">genre</td>
		<td class="top">img</td>
      </tr>
    </thead>
    <tbody>
		<tr>
			<td class="down">${bag.id}</td>
			<td class="down">
			
			<a href="one5.multi?no=${bag.id}">${bag.title}</a>
			
			</td>
			<td class="down">${bag.artist}</td>
			<td class="down">${bag.genre}</td>
			<td class="down"><img src="resources/playlistImg/${bag.img}"></td>
		</tr>
    </tbody>
  </table>
</div>
</body>
</html>
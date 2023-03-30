<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
게시판 처리 요청이 완료되었습니다.<br>
<!-- bag.getId()  -->
<%--model의 속성으로 전달받은 bag은 EL로 출력한다. --%>
<!-- EL: 속성으로 지정한 값 꺼내서 출력해주세요.!라는 의미! -->
<!-- 	for (String s : list) {
			
		}
 -->
<%-- <table>
<tr>
	<td class="top">id</td>
	<td class="top">name</td>
	<td class="top">url</td>
	<td class="top">img</td>
</tr>
<c:forEach items="${list}" var="bag" begin="0" end="10" step="2">

<tr>
	<td class="down">${bag.id}</td>
	<td class="down">
	
	<a href="on2.multi?no=${bag.id}">${bag.name}</a>
	
	</td>
	<td class="down">${bag.url}</td>
	<td class="down">${bag.img}</td>
</tr>
</c:forEach>
</table> --%>
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
      <c:forEach items="${list}" var="bag">

		<tr>
			<td class="down">${bag.id}</td>
			<td class="down">
			
			<a href="one5.multi?id=${bag.id}">${bag.title}</a>
			
			</td>
			<td class="down">${bag.artist}</td>
			<td class="down">${bag.genre}</td>
			<td class="down"><img src="resources/playlistImg/${bag.img}"></td>
		</tr>
		</c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
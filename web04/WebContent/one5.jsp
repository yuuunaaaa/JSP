<%@page import="multi.PlaylistVO"%>
<%@page import="multi.PlaylistDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id = request.getParameter("id"); 
    	
    	PlaylistDAO dao = new PlaylistDAO();
    	PlaylistVO bag2 = dao.one(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
당신이 검색을 원하는 id <%= id %>
<hr color="red">
 <table class="table table-warning table-striped">
 	<tr>
 		<td>음악 아이디</td>
 		<td><%= bag2.getId() %></td>
 	</tr>
 	<tr>
 		<td>음악 제목</td>
 		<td><%= bag2.getTitle() %></td>
 	</tr>
 	<tr>
 		<td>음악 아티스트</td>
 		<td><%= bag2.getArtist() %></td>
 	</tr>
 	<tr>
 		<td>음악 장르</td>
 		<td><%= bag2.getGenre() %></td>
 	</tr>
 	<tr>
 		<td>앨범 이미지</td>
 		<td>
 			<img src="playlistImg/<%= bag2.getImg()%>" width="150" height="150">
 		</td>
 	</tr>
 </table>
</body>
</html>
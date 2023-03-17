<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="multi.PlaylistVO"%>
<%@page import="multi.PlaylistDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	  	
    	PlaylistDAO dao = new PlaylistDAO();
    //5,6)dao가 리턴한 BbsVO가 들어간 ArrayList를 받는다. 
	
    	ArrayList<PlaylistVO> list = dao.list();
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
전체 음악 갯수 : <%= list.size() %>
<% if (list.size() == 0) {%>
<h3>등록된 음악이 없습니다.</h3>
<img src="img/empty.jpg" width=250 height="250">
<%} else{ %>
 <table class="table table-danger table-striped">
 <%} %>
 <tr>
 	<td>id</td>
 	<td>name</td>
 	<td>content</td>
 	<td>price</td>
 </tr>
<% 
	for(PlaylistVO bag2: list){
%>
 <tr>
 	<td><%= bag2.getId() %></td>
 	<td>
 	        <!-- one3.jsp?id=102 -->
 		<%= bag2.getId() %>"
			<%= bag2.getTitle() %>
 	</td>
 	<td><%= bag2.getArtist() %></td>
 </tr>
 <% } %>
 </table>
</body>
</html>
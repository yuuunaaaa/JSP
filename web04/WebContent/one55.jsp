<%@page import="java.util.ArrayList"%>
<%@page import="multi.PlaylistVO"%>
<%@page import="multi.PlaylistDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");

	PlaylistDAO dao = new PlaylistDAO();
	ArrayList<PlaylistVO> list = dao.one55(title);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	당신이 검색을 원하는 title
	<%=title%>
	<hr color="red">
	<table class="table table-warning table-striped">
		<tr>
			<td>음악 아이디</td>
			<td>음악 제목</td>
			<td>음악 아티스트</td>
		</tr>
		<%
			for (PlaylistVO bag2 : list) {
		%>
		<tr>
			<td><%=bag2.getId()%></td>
			<td><a href="one5.jsp?id=<%=bag2.getId()%>"> <%=bag2.getTitle()%>
			</a></td>
			<td><%=bag2.getArtist()%></td>
		</tr>
		<%
			} //for
		%>
	</table>
</body>
</html>
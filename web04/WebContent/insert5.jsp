<%@page import="multi.PlaylistDAO"%>
<%@page import="multi.PlaylistVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bag" class="multi.PlaylistVO"></jsp:useBean>
    <jsp:setProperty property="*" name="bag"/>
    <%PlaylistDAO dao = new PlaylistDAO();
    	dao.insert(bag);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
음악이 등록되었습니다.!!<br>
<!-- img src=img/shoes1.jpg -->
<img src="playlistImg/<%= bag.getImg() %>"   width=200  height=200>
</body>
</html>
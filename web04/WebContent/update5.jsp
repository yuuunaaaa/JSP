<%@page import="multi.PlaylistDAO"%>
<%@page import="multi.PlaylistVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1. 전달된 값 받아주세요.(request이용) -->
    <!-- 2. dao에게 값 전달.(DAO이용) 생략-->
    <!-- 3. 전달된 값을 출력하는 결과를 브라우저에 Html로 보내주세요.  -->
 <%
   //0. 클라이언트가 입력한 정보를 받아주세요.!
 	String id = request.getParameter("id"); 
 	String title = request.getParameter("title"); 
 	
 	//1. 받은 데이터를 dao에게 주기 위해서 가방을 만들어서 넣자.!
 	PlaylistVO bag = new PlaylistVO();
 	bag.setId(id);
 	bag.setTitle(title);
 	
 	//2. dao에게 가방을 전달하면서 insert해달라고 하자.!
 	PlaylistDAO dao = new PlaylistDAO();
 	dao.update(bag);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
작성한 id : <%= id %> <br>
작성한 title : <%= title %> <br>
</body>
</html>
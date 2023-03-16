<%@page import="multi.MemberDAO3"%>
<%@page import="multi.MemberVO"%>
<%@page import="multi.MemberDAO3"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//클라이언트가 입력한 No를 서버에서 받아주기(자바로!)
	// Car car = new Car();
	//HttpServletRequest request = new HttpServletRequest(); 
	//car.run();
	String id = request.getParameter("id"); //String, "100" 
	//JSP안에 만들어진 변수는 서버의 RAM에 저장되는 지역변수!

	//vo??? X
	//dao에게 no를 주면서 삭제해달라고 요청
	MemberDAO3 dao = new MemberDAO3();
	MemberVO bag2 = dao.one(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신이 검색을 원하는 아이디는
	<%=bag2.getId() %>
	검색한 이름 :
	<%=bag2.getName()%>
	<br> 검색한 비밀번호 :
	<%=bag2.getPw()%>
	<br> 검색한 전화번호 :
	<%=bag2.getTel()%>
	<br>
</body>
</html>
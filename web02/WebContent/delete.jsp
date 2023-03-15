<%@page import="multi.MemberDAO3"%>
<%@page import="multi.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String id = request.getParameter("id");
    
    MemberVO bag = new MemberVO();
    
    MemberDAO3 dao = new MemberDAO3();
    dao.delete(id);
    %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
탈퇴할 id : <%= id %>
</body>
</html>
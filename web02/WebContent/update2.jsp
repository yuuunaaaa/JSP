<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String no = request.getParameter("no");
    String contents = request.getParameter("contents");
    %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
당신이 수정을 원하는 번호는 <%= no %>
당신이 수정을 원하는 contents는 <%= contents %>
</body>
</html>
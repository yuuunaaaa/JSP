<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1. 전달된 값 받아주세요.(request 이용) -->
    <!-- 2. dao에게 값 전달.(DAO 이용) 생략 -->
    <!-- 3. 전달된 값을 출력하는 결과를 브라우저에 Html로 보내주세요. -->
    <%
    String no = request.getParameter("no");
    String title = request.getParameter("title");
    String name = request.getParameter("name");
    String content = request.getParameter("content");
    %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background: lime;
}
</style>
</head>
<body>
게시글 등록 요청되었음.
<hr color="red">
게시글 no : <%= no %> <br>
게시글 title : <%= title %> <br>
게시글 name : <%= name %> <br>
게시글 content : <%= content %> <br>
</body>
</html>
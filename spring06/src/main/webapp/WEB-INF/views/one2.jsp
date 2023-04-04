<%@page import="coim.multi.mvc06.BbsVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background: lightblue;
}
</style>
</head>
<body>
<a href="bbs.jsp">처음페이지로</a>
<a href="list2">게시물 전체 목록페이지</a>
<hr color="blue">

게시물검색 처리 요청이 완료되었습니다.
<br>
${bag.no}, ${bag.title}, 
${bag.content}, ${bag.writer}
<hr color="blue">
<hr color="blue">
댓글 달기 <input id="reply"><button id="b1">댓글 달기</button><br>
<hr color="blue">
<div id="result">
	<c:forEach items="${list}" var="bag">
	- ${bag.no}, ${bag.title}, ${bag.content}, ${bag.writer}
	</c:forEach>
</div>
</body>
</html>
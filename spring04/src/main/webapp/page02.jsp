<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
<% 
	Cookie[] cookies = request.getCookies();
%>
🍪쿠키🍪의 개수는 : <%= cookies.length %>
<hr>
<% 
	for (Cookie c : cookies) {
		if (!c.getName().equals("JSESSIONID")) {
			out.print(c.getName() + " : " + c.getValue() + "<br>");
		}
	}
%>
</body>
</html>
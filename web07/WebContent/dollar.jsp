<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    String d = request.getParameter("dollar");
    double dollar = Integer.parseInt(d);
    double result = dollar * 1283.30;
    %><%=result%>
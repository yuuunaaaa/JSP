<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//스크릿트릿
	JSONObject json3 = new JSONObject();
	json3.put("weather", "rain"); //{name:hong}
	json3.put("temp", 14.4);
	json3.put("humid", "96%");
	
	//out.print(json.toJSONString());
%><%= json3.toJSONString()%>
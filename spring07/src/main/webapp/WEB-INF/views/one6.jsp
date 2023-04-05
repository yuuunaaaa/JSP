<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
<tr>
	<td class="top">no</td>
	<td class="top">title</td>
	<td class="top">content</td>
	<td class="top">writer</td>
</tr>
<tr>
	<td class="down">${bag.no}</td>
	<td class="down">${bag.title}</td>
	<td class="down">${bag.content}</td>
	<td class="down">${bag.writer}</td>
</tr>
</table>
<%-- 
번호 : ${bag.no}<br>
제목 : ${bag.title}<br>
내용 : ${bag.content}<br>
작성자 : ${bag.writer}<br> --%>
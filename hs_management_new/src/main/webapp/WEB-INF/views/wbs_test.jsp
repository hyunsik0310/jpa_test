<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>근태관리 </title>
	
	
</head>
<body>

<h1>근태관리</h1>


<br>
<br>
<table border = "1" style= text-align:center >
	<c:forEach items="${wbs1}" var = "v">
	<tr>
		<td>사원번호</td>	
		<td colspan = "2">${v.u_no}</td>	
		<td>이름</td>	
		<td colspan = "2">${v.u_name}</td>	
	</tr>
	</c:forEach>
	<c:forEach items="${wbs3}" var = "v">
	<tr>
		<td>4월</td>	
		<td>현장명 : ${v.wp_name}</td>	
		<td colspan = "2">min : ${v.min_time}</td>
		<td colspan = "2">max : ${v.max_time}</td>
	</tr>
	</c:forEach>
	<tr style= "background-color : lightblue">
		<th>일자</th><th>시작시간</th><th>종료시간</th><th>휴식시간</th><th>근무여부</th><th>기타</th>
	</tr>
	<c:forEach items="${wbs2}" var = "v">
	<tr>
		<td>${v.date} </td>
		<td>${v.start_time} </td>
		<td>${v.end_time} </td>
		<td>${v.rest_time} </td>
		<td>${v.vacation_type} </td>
		<td>${v.memo} </td>
	</tr>
	</c:forEach>

</table>
<br>
<button type="button" >등록</button>
<button type="button" >출력</button>


</body>
</html>
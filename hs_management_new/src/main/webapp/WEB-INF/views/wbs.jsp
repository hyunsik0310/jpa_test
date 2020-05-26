<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>KIMSCHOOL ||  WBS</title>
</head>
<body>

<h1>${wbsinfovo.u_name}</h1>

<fieldset style="width: 300px;">
	<legend>
		KIMSCHOOL 勤怠管理
	</legend>

	<table border=1>
		<tr>
			<th style="background-color: lightblue;">社員名</th><td>${wbsinfo.u_name}</td>
		</tr>
		<tr>
			<th style="background-color: lightblue;">社員番号</th><td>${wbsinfo.u_no}</td>
		</tr>
	</table>

	<br>

	<table border=1>
		<tr>
			<th style="background-color: lightblue;">勤務日合計</th><td>17日</td>
		</tr>
			<c:set var = "sum" value = "0" />
		<c:forEach items="${wbsinfo.wbslist}" var = "wbs">
				<c:set var = "sum" value = "${sum + wbs.totaltime_h}"/>
		</c:forEach>	
		<tr>
			<th style="background-color: lightblue;">勤務時間合計</th>
				<td>
				<fmt:parseNumber  type="number" value="${sum/60}" integerOnly="true" />時間
				<c:out value = "${sum%60}" />分 
				</td>
		</tr>
	</table>
	<br>
	<table border=1>
		<tr>
			<th style="background-color: lightblue;">最低勤務時間</th><td>${wbsinfo.min_time}</td>
		</tr>
		<tr>
			<th style="background-color: lightblue;">最大勤務時間</th><td>${wbsinfo.max_time}</td>
		</tr>
	</table>
</fieldset>

<br>


<table border=1>

	<tr style="background-color: lightblue">
		<th>日付<th>開始時間</th><th>終了時間</th><th>合計時間</th><th>休日区分</th><th>メモ</th>
	</tr>
	<c:set var = "sum" value = "0" />
	<c:forEach items="${wbsinfo.wbslist}" var = "wbs">
		<tr>
			<td>${wbs.date}</td>
			<td>
				　${wbs.start_h}時${wbs.start_m}分　
			</td>
			<td>
				　${wbs.end_h}時${wbs.end_m}分　
			</td>
			<td>
				　${wbs.total_h}時間${wbs.total_m}分　
			</td>
	
			<td>
				<c:choose>
					<c:when test="${wbs.vacation_type == 0}">
					
					</c:when>
					<c:when test="${wbs.vacation_type == 1}">
					오전휴가
					</c:when>
					<c:when test="${wbs.vacation_type == 2}">
					오휴휴가
					</c:when>
					<c:when test="${wbs.vacation_type == 3}">
					종일휴가
					</c:when>
					<c:when test="${wbs.vacation_type == 4}">
					조퇴
					</c:when>
				</c:choose>
			</td>
			<td>${wbs.memo}　　　　　</td>
		</tr>
	</c:forEach>
			　　　　　
	

</table>

<br>
<input type = "button" value = "등록">

</body>
</html>


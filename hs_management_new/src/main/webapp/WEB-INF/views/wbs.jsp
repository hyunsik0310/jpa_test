<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>KIMSCHOOL ||  WBS</title>
</head>
<body>

<h1>${name}</h1>

<fieldset style="width: 300px;">
	<legend>
		KIMSCHOOL 勤怠管理
	</legend>

	<table border=1>
		<tr>
			<th style="background-color: lightblue;">社員名</th><td>${wbsinfo.u_name}</td>
		</tr>
		<tr>
			<th style="background-color: lightblue;">社員番号</th><td>${v.u_no}</td>
		</tr>
	</table>

	<br>

	<table border=1>
		<tr>
			<th style="background-color: lightblue;">勤務日合計</th><td>17日</td>
		</tr>
		<tr>
			<th style="background-color: lightblue;">勤務時間合計</th><td>134時間</td>
		</tr>
	</table>
	<br>

	<table border=1>
		<tr>
			<th style="background-color: lightblue;">最低勤務時間</th><td>${wbsinfovo.min_time}</td>
		</tr>
		<tr>
			<th style="background-color: lightblue;">最大勤務時間</th><td>${wbsinfovo.max_time}</td>
		</tr>
	</table>

</fieldset>

<br>


<table border=1>

	<tr style="background-color: lightblue">
		<th>日付<th>開始時間</th><th>終了時間</th><th>合計時間</th><th>休日区分</th><th>メモ</th>
	</tr>
	<c:forEach items="${wbsinfovo}" var = "v">
	<tr>
		<td>${wbsinfovo.date }</td>
		<td>
			${wbsinfovo.start_time}
		</td>
		<td>
			${wbsinfovo.end_time}
		</td>
		<td>${wbsinfovo.rest_time}</td>
		<td>${wbsinfovo.vacation_type}</td>
		<td>${wbsinfovo.memo}</td>
	</tr>
	</c:forEach>
</table>


<input type = "button" value = "등록">

</body>
</html>


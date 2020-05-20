<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>사원관리 시스템</title>
</head>
<body>
<h1>
	사원 로그인
</h1>

<form action ="wbslogincheck">
	사원번호 : <br>
	<input type = "text" name = "u_no"><br>
	비밀번호:<br>
	<input type = "password" name = "u_password"><br><br>
	<input type = "submit" value = "LOGIN">



</form>
<!-- 
<form action = "logincheck">
	ID : <br>
	<input type = "text" name = "id"><br>
	PASSWORD:<br>
	<input type = "password" name = "password"><br><br>
	<input type = "submit" value = "LOGIN">
</form> -->

<a href = "movereguser">Don't you have Account?</a><br>
<a href = "movefindpassword">Forgot your password?</a>

</body>
</html>

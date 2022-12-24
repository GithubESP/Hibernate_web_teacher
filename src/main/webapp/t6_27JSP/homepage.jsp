<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 傳送至SearchAllController-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁</title>
</head>
<body>
	<Form action="<c:url value='/SearchAllController'/>" method="POST" name="loginForm">
		 <input type="submit" value="點此進入"> 
	</Form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 傳送至SearchAllController-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增</title>
</head>
<body>
<h1>新增成功!!</h1>
	<Form action="<c:url value='/SearchAllController'/>" method="POST" name="loginForm">
		 <input type="submit" value="回文章列表"> 
	</Form>
</body>
</html>
	

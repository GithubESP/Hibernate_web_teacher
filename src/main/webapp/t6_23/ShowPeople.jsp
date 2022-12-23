<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<h2>會員資料清單</h2>
		<hr>
		<table border='1'>
			<tr>
				<th width='80'>編號</th>
				<th width='120'>暱稱</th>
				<th width='80'>年齡</th>
				<th width='80'>性別</th>
				<th width='140'>地址</th>
				<th width='150'>圖片</th>
				<th width='60'>刪除</th>
			</tr>
			<c:forEach var="bean" items="${peopleBeans}">
				<tr>
					<td align='center'><a href="<c:url value='/showPeopleControllersafe?id=${bean.userID}' />">${bean.userID}</a></td>
					<td align='center'><a href="<c:url value='/showPeopleControllersafe?id=${bean.userID}' />">${bean.name}</a></td>
					<td align='center'> ${bean.age} </td>
					<td align='center'>${bean.sex}</td>
					<td align='center'>${bean.address}</td>
					<td align='center'><img height='100' width='80'
						src="<c:url value='/toImages?id=${bean.userID}' />"></td>
					<td><a href="<c:url value='/removePeople.do?id=${bean.userID}' />">刪除</a></td>
				</tr>
			</c:forEach>
		</table>
		<p>
		<hr>
		<a href="<c:url value='/t6_23/UserSelect.jsp' />">回首頁</a>
	</div>
</body>
</html>
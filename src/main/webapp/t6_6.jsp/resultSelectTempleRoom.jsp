<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>123</title>
</head>
<body>
<div align='center'>
			<c:forEach var='tmpr' items="${tmpr}" varStatus="vs">
				<c:if test='${vs.first}'>
					<c:out escapeXml='false' value='<table border="1" >' />
					<tr>
						<th>編號</th>
						<th>地址</th>
						<th>單人房</th>
						<th>雙人房</th>
						<th>三人房</th>
						<th>四人房</th>
						<th>通鋪</th>
						
					</tr>
				</c:if>
				<tr>
					<td>${tmpr.templeId}</td>
					<td>${tmpr.address}</td>
					<td>${tmpr.singleroom}</td>
					<td>${tmpr.doubleroom}</td>
					<td>${tmpr.tripleroom}</td>
					<td>${tmpr.quadrupleroom}</td>
					<td>${tmpr.dormitoryroom}</td>
				</tr>
				<c:if test='${vs.last}'>
					<c:out escapeXml='false' value='</table>' />
				</c:if>
			</c:forEach>
	<br>
	<p />
	<hr>
</div>
</body>
</html>
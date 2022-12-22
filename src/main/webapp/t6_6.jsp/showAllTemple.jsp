<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢</title>
</head>
<body>

<div align='center'>
			<c:forEach var='tmp' items="${tmp}" varStatus="vs">
				<c:if test='${vs.first}'>
					<c:out escapeXml='false' value='<table border="1" >' />
					<tr>
						<th>編號</th>
						<th>寺廟名稱</th>
				 		<th>主祀神</th>
						<th>行政區</th>
						<th>地址</th>
						<th>登記別</th>
						<th>教別</th>
						<th>電話</th>
						<th>負責人</th>
						<th>其他</th>
						<th>X座標</th>
						<th>Y座標</th>
						<th>統一編號</th>
					</tr>
				</c:if>
				<tr>
					<td>${tmp.templeId}</td>
					<td>${tmp.templeName}</td>
		  			<td>${tmp.deitiesName}</td>
					<td>${tmp.administrative}</td>
					<td>${tmp.address}</td>
					<td>${tmp.register}</td>
					<td>${tmp.sect}</td>
					<td>${tmp.phone}</td>
					<td>${tmp.principal}</td>
					<td>${tmp.other}</td>
					<td>${tmp.WGS84X}</td>
					<td>${tmp.WGS84Y}</td>
					<td>${tmp.uniformnumbers}</td>
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
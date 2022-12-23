<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> 
form {
	margin: 0 auto;
	width: 400px;
}
</style>
</head>
<body>
<div align="RIGHT">
<a  href="http://localhost:8080/SecondServlet/index.html">回主頁</a>
<!--  ShowAllPeopleServlet  -->
<a href='<c:url value="/t6_23/controller/showPeople.do" />'>查詢資料(後臺用)</a>
<a href='<c:url value="/t6_23/InsertPeopleForm_23.jsp" />' >新增資料</a>
</div>
<div>
<form action="<c:url value='/userSelectControllersafe' />" method="POST">
		<table>
			<tr>
				<th colspan='2' align="center">
					<h1>搜尋</h1>
				</th>
				<th></th>
			</tr>
			<tr>
				<td width='160' align="RIGHT">輸入帳號或暱稱：</td>
				<td width='100' align="LEFT"><input type="text" name="userId"
					size="10"></td>
					<td colspan="2" align="LEFT"><button onclick="location.href='/userSelectControllersafe'">搜尋</button>
				</td>
			</tr>
		</table>
	</form>
</div><hr>
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
			</tr>
			<c:forEach var="bean" items="${peopleBeans}">
				<tr>
					<td align='center'><a href="<c:url value='/showPeopleControllersafe2?id=${bean.userID}' />">${bean.userID}</a></td>
					<td align='center'><a href="<c:url value='/showPeopleControllersafe2?id=${bean.userID}' />">${bean.name}</a></td>
					<td align='center'> ${bean.age} </td>
					<td align='center'>${bean.sex}</td>
					<td align='center'>${bean.address}</td>
					<td align='center'><img height='100' width='80'
						src="<c:url value='/toImages?id=${bean.userID}' />"></td>
				</tr>
			</c:forEach>
		</table>
		<p>
		<hr>
		<a
						href="javascript:history.back()">回上頁</a>
		<a href="<c:url value='/t6_23/UserSelect.jsp' />">回首頁</a>
	</div>
</body>
</html>
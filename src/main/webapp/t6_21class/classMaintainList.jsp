<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>查詢頁面</title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://kit.fontawesome.com/f7498d7580.js" crossorigin="anonymous"></script>

<style>
table,h1,div{
	text-align: center;
}
</style>
</head>

<body>
<c:set var="funcName" value="BMT" scope="session" />
<jsp:include page="/fragment/topMVC.jsp" />
	<header>
		<h1>課程列表</h1>
	</header>
	<table id="table_id" class="display">
		<thead>
			<tr>
				<th>課程編號</th>
				<th>課程名稱</th>
				<th>課程圖片</th>
				<th>課程老師</th>
				<th>課程價錢</th>
				<th>課程分類</th>
				<th>購物車</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bean" items="${classList}">
				<tr>
					<td>${bean.classId}</td>
					<td>${bean.className}</td>
        <td><img height='100' width='80'src="<c:url value='/controller/classImage?id=${bean.classId}' />"></td>					
     				<td>${bean.classTeacher}</td>
     				<td>${bean.classPrice}</td>
					<td>${bean.classCategory}</td>
					<td>
					<div style="display:inline">
           <a href="<c:url value='/ClassDelete.do?id=${bean.classId}'/>"><input type="submit" value="刪除"></a>
           <a href="<c:url value='/ClassPreUpdateServlet.do?classId=${bean.classId}'/>"><input type="submit" value="修改"></a>
				</div>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<script>
		
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
		
	</script>
</body>

<div><a href="<c:url value='/t6_21class/ClassInsert.jsp'/>"><input type="submit" value="新增紀錄"></a></div>
</html>
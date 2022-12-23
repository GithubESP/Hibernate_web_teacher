<%@page import="t6_21class.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
               "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>修改頁面</title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<link href="<c:url value='/css/style.css' />" rel="stylesheet"
	type="text/css" />

<script src="https://kit.fontawesome.com/f7498d7580.js"
	crossorigin="anonymous"></script>
<style>
table, h1 {
	text-align: center;
}
</style>
</head>

<body>
	<jsp:include page="/fragment/topMVC.jsp" />
	<center>

		<form id="form1" name="form1" method="post"
			action="<c:url value='/ClassInsertServlet.do'/>"
			enctype="multipart/form-data">

			<h1>課程列表</h1>

			<table id="table_id" class="display">
				<thead>
					<tr>
<!-- 						<th>課程編號</th> -->
						<th>課程名稱</th>
						<th>課程圖片</th>
						<th>課程老師</th>
						<th>課程價錢</th>
						<th>課程分類</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>

						

						<th><input type="text" name="name"
							value="${requestScope.name}" size="50"
							style="width: 100px; height: 45px" /> <br> <font
							color='red' size='-1'> ${ErrMsg.errclassName} </font></th>

						<th style="width: 200px; height: 50px"><input
							style="justify-content: center;" type="file" name="uploadFile"
							id="picture"> <br> <font color='red' size='-1'>
								${ErrMsg.errclassPicture} </font></th>


						<th><input name="teacher" class='InputClass' type="text"
							id="teacher" value="${requestScope.teacher}" size="50"
							style="width: 250px; height: 30px" max="15" min="1" /> <br>
							<font color='red' size='-1'> ${ErrMsg.errclassTeacher} </font></th>

						<th><input name="price" class='InputClass' type="text"
							id="price" value="${requestScope.price}" size="50"
							style="width: 250px; height: 30px"
							onkeyup="value=value.replace(/^(0+)|[^\d]+/g,'')" /> <br> <font
							color='red' size='-1'> ${ErrMsg.errclassPrice} </font></th>

						<th><input name="category" class='InputClass' type="text"
							id="category" value="${requestScope.category}" size="50"
							style="width: 250px; height: 30px" max="15" min="1" /> <br>
							<font color='red' size='-1'>${ErrMsg.errclassCategory}</font></th>

						<th><input name="classId" type="hidden" id="classId"
							value="${param.classId }>" /> <input type="submit" name="update"
							value="新增確認" /></th>

					</tr>
				</tbody>
			</table>

		</form>
		<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
		<script
			src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
		<script>
			$(document).ready(function() {
				$('#table_id').DataTable();
			});
		</script>
	</center>

</body>
</html>
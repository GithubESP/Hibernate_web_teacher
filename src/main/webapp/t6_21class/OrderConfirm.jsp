<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server 
response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance 
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>查詢頁面</title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<script src="https://kit.fontawesome.com/f7498d7580.js"
	crossorigin="anonymous"></script>
<style>
table, h1 {
	text-align: center;
}
</style>
<script type="text/javascript">
	function cancelOrder() {
		if (confirm("確定取消此份訂單 ? ")) {
			// 接收此資料的Servlet會使用 finalDecision 參數的值
			document.forms[0].finalDecision.value = "CANCEL";
			document.forms[0].action = "<c:url value='/ProcessOrder.do' />";
			document.forms[0].submit();
			return;
		} else {
			return;
		}
	}
	function reconfirmOrder() {
		var sa = $("#customerEmail").val();
		if (sa === "") {
			window.alert('email不能是空白');
			return;
		}
		if (confirm("確定送出此份訂單 ? ")) {
			// 接收此資料的Servlet會使用 finalDecision 參數的值
			document.forms[0].finalDecision.value = "ORDER";
			document.forms[0].action = "<c:url value='/ProcessOrder.do' />";
			document.forms[0].method = "POST";
			document.forms[0].submit();
			return;
		} else {
			return;
		}
	}
	
</script>
</head>

<body>
	<c:set var="funcName" value="CHE" scope="session" />
	<jsp:include page="/fragment/topMVC.jsp" />

	<h1>結帳總額</h1>
	</header>

	<h1>請確認以下信息</h1>
	<FORM action="<c:url value='/ProcessOrder.do' />" method="POST">

		<table id="table_id" class="display">
			<thead>
				<tr>
					<th>會員編號：</th>
					<th>客戶帳號：</th>
					<th>訂單日期：</th>
					<th>會員信箱:</th>
					<th>會員電話:</th>
					<th>訂單狀態:</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${LoginOK.memberId}</td>
					<td>${LoginOK.memberAccount}</td>
					<td><Input type="date" name="today"
						value="${today}" required></td>
					<td><Input type="email" name="customerEmail"
						value="${customerEmail}" required></td>
					<td><Input type="text" name="customerPhone"
						value="${customerPhone}" required></td>
					<td><Input type="text" name="orderStatus"
						value="${orderStatus}" required></td>
				</tr>
			</tbody>

			<thead>
				<tr>
					<th>課程名稱</th>
					<th>課程圖片</th>
					<th>課程數量</th>
					<th>課程價錢</th>
					<th>課程金額</th>
					<th>請再次確認</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="anEntry" items="${shoppingCart.getContent()}">
					<tr>
						<td>${anEntry.value.description}</td>
						<td><img height='100' width='80'
							src="<c:url value='/controller/classImage?id=${anEntry.value.classNumber}' />"></td>
						<td>${anEntry.value.quantity}</td>
						<td>${anEntry.value.unitPrice}</td>
						<td>${anEntry.value.unitPrice*anEntry.value.quantity}</td>

						<td><input type="hidden" name="finalDecision" value="">
							<input type="button" name="CancelBtn" value="取消訂單"
							onclick="cancelOrder();"> <input type="button"
							name="OrderBtn" value="確定送出" onclick="reconfirmOrder();">
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<td colspan='5' style='text-align: right'>總計金額：${shoppingCart.getSubtotal() }</td>

			<div></div style="float:center">

		</table>
	</FORM>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
	</script>
</body>

</html>
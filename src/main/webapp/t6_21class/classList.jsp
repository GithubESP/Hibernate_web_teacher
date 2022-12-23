<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
table,h1{
	text-align: center;
}
</style>
</head>

<body>
<c:set var="funcName" value="SHO" scope="session"/>
<jsp:include page="/fragment/topMVC.jsp" />

<c:choose>
   <c:when test="${shoppingCart.itemNumber > 0}">
      <!-- 購物車內有一項以上的商品 -->
      <c:set var="cartContent" value="購物車內有${shoppingCart.getItemNumber()}項商品"/>
   </c:when>
   <c:otherwise>
      <!-- 購物車內沒有商品 -->
      <c:set var="cartContent" value="您尚未購買任何商品"/>        
   </c:otherwise>
</c:choose>

         <span style="float:right;color:red"> 金額小計(OK): <c:out value="${shoppingCart.getSubtotal()}" default="0"/> 元</br>
         購入商品總數量:${shoppingCart.getQty()} </span>
	
	
	
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
                     <FORM  action="<c:url value='/BuyClassServlet.do?classId=${bean.classId}' />" 
                            method="POST">
                                購買數量:
                           <input type="text" name="qty" value="${qty}">
                       <!-- 這些隱藏欄位都會送到後端 -->
                       <Input type='hidden' name='classId' value='${classId}'>
                       <Input type='submit' value='加入購物車'>
                     </FORM>
    </td>
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

</html>
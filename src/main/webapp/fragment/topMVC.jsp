<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value='/css/eDM.css' />" rel="stylesheet"
	type="text/css" />
<script src="<c:url value='/javascript/jquery-1.9.1.js' />"></script>
<link href="<c:url value='/javascript/eDM.js' />" rel="stylesheet"
	type="text/css" />

<c:set var='debug' value='true' scope='application' />
<table class='menuOuter'>
	<tr height="48px">
<%--		<td width="60px" rowspan='2'><img width="60px" height="40px"
			src="<c:url value='/images/BookStore.gif' />"></td>--%>
		<td>
			<table class='menuInner'>
				<tr>
					<td class='menuData'>
						<div class='menu'></div>
					</td>
					
					<td class='menuData'>
						<div class='menu'>


							<a href="<c:url value='/index.jsp' />"> 商品查詢頁面 </a>

						</div>
					</td>
					
					
				
<%-- 					<td class='menuData'>
						<div class='menu'>

							<a href="<c:url value='/_04_ShoppingCart/ShowCartContent.jsp' />"> 
								結帳 </a>




						</div>
					</td>--%>
<%-- 					<td class='menuData'>
						<div class='menu'>

							<a href="<c:url value='/_05_orderProcess/orderList.do' />"> 
								訂單 </a>

						</div>
					</td>--%>
			</table>
	<tr>
		<td>
			<hr style="color: #f00; background-color: #f00; height: 2px;">
		</td>
	</tr>
</table>
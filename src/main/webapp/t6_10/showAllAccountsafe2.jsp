<%@page import="t6_10.bean.Account"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--     接棒ShowAllAccountController -->
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>查詢所有員工</title>
<link rel="stylesheet"
 href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
</head>
<body>
<table border="1">
<thead>
	<tr>
	<td>編號</td>
	<td>姓名</td>
	<td>密碼</td>
	<td>圖片</td>
<!-- 	<td>圖片</td> -->
	<td colspan="2">操作</td>
	</tr>
</thead>
<tbody>




  <c:forEach var="account" items="${accounts}">
<%-- 	<% --%>
<!-- // 	List<Account> accounts=(List<Account>)request.getAttribute("accounts"); -->
<!-- // 	for(Account account:accounts){ -->
<%-- 		%> --%>
	
<!-- 	<tr> -->
<%-- 	<td><%=account.getId() %></td> --%>
<%-- 	<td><%=account.getAccount() %></td> --%>
<%-- 	<td><%=account.getPassword() %></td> --%>
<%-- 	<td><%=account.getImage() %></td> --%>
		<tr>
	<td>${account.id}</td>
	<td>${account.account}</td>
	<td>${account.password}</td>
	<td><img height='100' width='80'src="<c:url value='/controller/toImage?id=${account.id}' />"></td>
<%-- 	<td>${account.getImage()}</td> --%>

<%-- 	<td><%=account.getSalary() %></td> --%>

<%-- 	<td><a href="<%=request.getContextPath()+"/removeAccountControllersafe?id="+account.getId() %>">刪除</a></td> --%>
<%-- 	<td><a href="<%=request.getContextPath()+"/showAccountControllersafe?id="+account.getId() %>">修改</a></td> --%>

	<td><a href=${request.getContextPath()}removeAccountControllersafe?id=${account.id}>刪除</a></td>
	<td><a href=${request.getContextPath()}showAccountControllersafe?id=${account.id}>修改</a></td>
	</tr>
<%-- 	<%  --%>
<!-- // 	} -->
<%-- 	%> --%>
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
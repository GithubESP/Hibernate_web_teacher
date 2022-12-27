<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="UTF-8">
<c:set var="AppName" value="${SYSTEM.systemName}" scope="application"/>
<title>${AppName}</title>
</head>
<body>
<!-- 設定變數funcName的值為"IND", top.jsp會使用此變數-->

<!-- 引入共同的頁首 -->
<jsp:include page="/fragment/topMVC.jsp" />


<%-- <form name="form1" method="post" action="<c:url value='/preCItem' />"> --%>
<!-- 	<input type="submit" name="Submit" value="輸入欲新增的商品"> -->
<!-- </form> -->

<!-- <form name="form2" method="post" action="ItemDelete.do"> -->
<!-- 	<input class='inputClass' type="text" name="id"> -->
<!-- 	<input type="submit" name="Submit" value="輸入欲刪除的商品ID"> -->
<!-- </form> -->

<!-- <form name="form3" method="post" action="preItemUpdate.do"> -->
<!-- 	<input class='InputClass' type="text" name="id"> -->
<!-- 	<input type="submit" name="Submit" value="輸入欲更改的商品ID"> -->
<!-- </form> -->

<form name="form4" method="post" action="<c:url value='ItemSelect.do'/>">
	<select name="type">
		<option value="pd_id">id</option>
		<option value="pd_name">name</option>
		<option value="pd_description">des</option>
	 </select>
	 <input class='InputClass' type="text" name="id">
	<input type="submit" name="Submit" value="商品查詢">
</form>


</body>
</html>
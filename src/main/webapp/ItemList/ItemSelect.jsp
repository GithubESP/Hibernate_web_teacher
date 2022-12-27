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
<c:forEach varStatus="vs" var="item" items="${select}">
	${item.getPd_id()}
	${item.getPd_name()}
	${item.getPd_description()}
	${item.getPd_price()}<br>
</c:forEach>


</body>
</html>
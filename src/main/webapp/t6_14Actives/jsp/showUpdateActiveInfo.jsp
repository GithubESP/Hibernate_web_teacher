<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改頁面</title>
</head>
<body>

		<form enctype="multipart/form-data" action="<c:url context='${pageContext.request.contextPath}' value='/updateActiveController'></c:url>" method="post">
		活動編號:<input  type="text" name="id" readonly value="${active.activeID}"><br/>
		活動名稱:<input required="required" type="text" name="name" value="${active.activeName}"><br/>
		活動圖片:<input required="required" type="file" name="img" value="${active.activeImg}"><br/>
		活動描述:<input required="required" type="text" name="description" value="${active.activeDescription}"><br/>
		活動開始時間:<input required="required" type="text" name="start" value="${active.activeStartDate}"><br/>
		活動結束時間:<input required="required" type="text" name="end" value="${active.activeEndDate}"><br/>
		活動地點:<input required="required" type="text" name="location" value="${active.activeLocation}"><br/>
		活動主辦單位:<input required="required" type="text" name="host" value="${active.activeHost}"><br/>
		<input type="submit" value="修改"/><br/>
		</form>
		</body>
		</html>
<%@ include file="footer.jsp" %>
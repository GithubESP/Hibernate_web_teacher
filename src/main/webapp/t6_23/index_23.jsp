<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='<c:url value="/EEIT56_23/InsertPeopleForm_23.jsp" />'>新增資料</a>
<p>
<!--  ShowAllPeopleServlet  -->
<a href='<c:url value="/showPeople.do" />'>查詢資料(後臺用)</a>
<p>
<a href='<c:url value="/EEIT56_23/UserSelect.jsp" />'>搜尋</a>
</body>
</html>
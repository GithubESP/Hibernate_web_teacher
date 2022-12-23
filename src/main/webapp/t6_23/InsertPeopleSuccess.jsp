<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="setInterval(countDown, 1000)">
<h1>歡迎 ${ peopleBean.name }!! 資料新增成功</h1>
年齡: ${ peopleBean.age }
性別: ${ peopleBean.sex }
地址: ${ peopleBean.address }
<hr>
<a href='<c:url value="/t6_23/UserSelect.jsp" />'>回首頁</a><br>
五秒鐘後自動回首頁<br>
<font id="num" size="7" face="impact">5</font>

<script>
		var sec = 5;		
		function countDown() {
			if (sec > 1) 
				num.innerHTML = --sec;
			else
				location = '<c:url value="/t6_23/UserSelect.jsp" />';
		}
	</script>
</body>
</html>
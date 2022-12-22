<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢房間</title>
</head>
<body>
<form name="ContralData" action=" <c:url value='/SelectTempleRoom.do'  />" method="POST">
			<tr>
					<td width="120" height="40">編號:</td>
					<td width="600" height="40" align="left"><input id='templeId' value="${tmp.templeId}"
						style="text-align: left" name="templeId" type="text" size="14">
				</tr>
    <label>查詢房型:</label>
    <label><input type="checkbox" name="room" value="tr.singleroom">單人房</label>
    <label><input type="checkbox" name="room" value="tr.doubleroom">雙人房</label>
    <label><input type="checkbox" name="room" value="tr.tripleroom">三人房</label>
    <label><input type="checkbox" name="room" value="tr.quadrupleroom">四人房</label>
    <label><input type="checkbox" name="room" value="tr.dormitoryroom">通鋪</label>
    <label><input type="submit" value="送出查詢"></label>
    	</form>
</body>
</html>
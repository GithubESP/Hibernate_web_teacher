<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改資料</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body>
	<form name="showMemberFormB" action="<c:url value=''  />" method="POST"
		enctype="multipart/form-data">
		<table border="1">
			<thead>
				<tr bgcolor='tan'>
					<th height="60" colspan="4" align="center"><h2>修改會員資料</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='tan'>
					<td width="120" height="40">帳號:</td>
					<td width="500" height="40" align="center" colspan="2"><span> ${bean.userID}</span></td>
					<td align='center' rowspan="4"><img height='100' width='120'
						src="<c:url value='/toImages?id=${bean.userID}' />"></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">暱稱:</td>
					<td width="500" height="40" align="left" colspan="2"><span>${bean.name}</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">年齡:</td>
					<td width="500" height="40" align="left" colspan="2"><span>${bean.age }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">性別:</td>
					<td width="500" height="40" align="left" colspan="2"><span>${bean.sex}</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">地址:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.address }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">星座:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.star }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">職業:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.profession }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">宗教:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.religion }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">收入:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.income }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">性取向:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.sex_in}</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">興趣:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.hobby }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">夢想:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.dream }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">個性:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.personality }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">感情狀況:</td>
					<td width="600" height="40" align="left" colspan="3"><span>${bean.emotion }</span></td>
				</tr>
				<tr bgcolor='tan'>
					<td width="120" height="40">自介:</td>
					<td width="600" height="40" align="left" colspan="3"><textarea
							name="introduction" id="comment1" cols="40" rows="5" readonly>${bean.introduction }</textarea></td>
				</tr>


				<tr bgcolor='tan'>
					<td height="50" colspan="4" align="center"><a
						href="javascript:history.back()">回上頁</a>
					<a href='<c:url value="/t6_23/UserSelect.jsp" />'>回首頁</a></td>
				</tr>
			</tbody>
		</table>
		<div style="color: #FF0000; display: inline">${ErrorMsg.exception}</div>
	</form>
</body>
</html>
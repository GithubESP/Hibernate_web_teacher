<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢</title>
<style>

 #map {
            height: 400px;
            width: 100%;
        }

form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body onload="javascript:document.insertMemberFormA.mId.focus();">
	<form name="ContralData" action=" <c:url value=''  />" method="POST">
		<table border="1">
<c:forEach var="tmp" items="${tmp}" >
			<thead>
				<tr bgcolor='lightblue'>
					<th height="60" colspan="2" align="center" ><h2>查詢結果</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">編號:</td>
					<td width="600" height="40" align="left"><input id='templeId' value="${tmp.templeId}"
						style="text-align: left" name="templeId" type="text" size="14">
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">寺廟名稱:</td>
					<td width="600" height="40" align="left"><input id='templeName' value= "${tmp.templeName}"
						style="text-align: left" name="templeName" type="text" size="14">
					</td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">主祀神:</td>
					<td width="600" height="40" align="left"><input name="deitiesName" value= "${tmp.deitiesName}"
						type="text" size="20"></td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">行政區:</td>
					<td width="600" height="40" align="left"><input name="administrative" value= "${tmp.administrative}"
						type="text" size="20"></td>
				</tr>
				
				<tr bgcolor='lightblue'>
					<td width="120" height="40">地址:</td>
					<td width="600" height="40" align="left"><input name="address" value= "${tmp.address}"
						type="text" size="20"></td>
				</tr>

				<tr bgcolor='lightblue'>
					<td width="120" height="40">登記別:</td>
					<td width="600" height="40" align="left"><input name="register" value= "${tmp.register}"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">教別:</td>
					<td width="600" height="40" align="left"><input name="sect" value= "${tmp.sect}"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">電話:</td>
					<td width="600" height="40" align="left"><input name="phone" value= "${tmp.phone}"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">負責人:</td>
					<td width="600" height="40" align="left"><input name="principal" value= "${tmp.principal}"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">其他:</td>
					<td width="600" height="40" align="left"><input name="other" value= "${tmp.other}"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">X座標:</td>
					<td width="600" height="40" align="left"><input name="wGS84X" value= "${tmp.WGS84X}"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">Y座標:</td> 
					<td width="600" height="40" align="left"><input name="wGS84Y" value= "${tmp.WGS84Y}"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='lightblue'>
					<td width="120" height="40">統一編號:</td>
					<td width="600" height="40" align="left"><input name="uniformnumbers" value= "${tmp.uniformnumbers}"
						type="text" size="14"></td>
				</tr>
				<tr bgcolor='lightblue'>
					<td height="50" colspan="2" align="center">
						<input value= "更改" type="submit" formaction="UpdateTempleData.do">
						<input value= "新增" type="submit" formaction="InsertTempleData.do">
						<input value= "刪除" type="submit" formaction="RemoveTemple.do">
						<input value= "回查詢" type="submit" formaction="./t6_6.jsp/FindTemple.jsp">
						<input value= "顯示所有資料" type="submit" formaction="SellectAllServlet.do">
						</td>
				</tr>
			</tbody>
		</c:forEach>
		</table>
	</form>
	
<div id="map">
<c:forEach var="tmp" items="${tmp}" >
    <script>
    	var y = ${tmp.WGS84Y}
    	var x = ${tmp.WGS84X}
        var map;
        var myMap = document.getElementById('map');
        //初始化地圖
        
        function initMap() {
            map = new google.maps.Map(myMap, {
                //地圖中心位置
                center: {
                    //緯度
                    lat:y,
                    //經度
                    lng:x
                },
                //縮放比
                zoom: 60
            });
        }
    </script>
    </c:forEach>
 </div>   
    <script src="https://maps.googleapis.com/maps/api/js?callback=initMap" async defer></script>
</body>
</html>
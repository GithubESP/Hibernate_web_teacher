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

<form id="form1" name="form1" method="post" 
       action="<c:url value='/ItemUpdate.do'/>"  enctype="multipart/form-data" >
        		商品名稱<input name="Pd_name" class='InputClass' type="text" id="title" 
               value="${Item.getPd_name()}" size="50" /><br>
              商品描述<input name="Pd_description" class='InputClass' type="text" id="title" 
               value="${Item.getPd_description()}" size="50" /><br>
               商品價格<input name="Pd_price" class='InputClass' type="text" id="title" 
               value="${Item.getPd_price()}" size="50" /><br>
               商品存貨<input name="Pd_qty" class='InputClass' type="text" id="title" 
               value="${Item.getPd_qty()}" size="50" /><br>
               商品圖片<input name="Pd_image" class='InputClass' type="file" id="title" 
                size="50" /><br>
               
               
               
               <input name="Pd_id" class='InputClass' type="hidden" id="title" 
               value="${Item.getPd_id()}" size="50" />
              
              
               <input type="submit" name="Submit" value="更改" />
              
</form>

</body>
</html>
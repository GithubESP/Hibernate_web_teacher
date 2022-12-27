<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>查詢頁面</title>
<link rel="stylesheet"
 href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css"/>
<script src="https://kit.fontawesome.com/f7498d7580.js" crossorigin="anonymous"></script>
<style>
table,h1{
 text-align: center;
}
</style>
</head>
<body>
<jsp:include page="/fragment/topMVC.jsp" />

<%-- <c:choose> --%>
<%--    <c:when test="${ShoppingCart.itemNumber > 0}"> --%>
<!--       購物車內有一項以上的商品 -->
<%--       <c:set var="cartContent" value="購物車內有${ShoppingCart.itemNumber}項商品"/> --%>
<%--    </c:when> --%>
<%--    <c:otherwise> --%>
<!--       購物車內沒有商品 -->
<%--       <c:set var="cartContent" value="您尚未購買任何商品"/> --%>
<%--    </c:otherwise> --%>
<%-- </c:choose> --%>




 <header>
  <h1>開運商品列表</h1>
 </header>
 <form name="form1" method="post" action="<c:url value='/preCItem' />">
	<input type="submit" name="Submit" value="輸入欲新增的商品">
</form>
 <table id="table_id" class="display">
  <thead>
   <tr>
    <th>商品編號</th>
    <th>商品名稱</th>
    <th>商品描述</th>
    <th>商品價格</th>
    <th>商品庫存</th>
    <th>照片</th>
    <th>操作</th>
   </tr>
  </thead>
<tbody>
   <c:forEach var="item" items="${select}">
    <tr>
     <td>${item.pd_id}</td>
     <td>${item.pd_name}</td>
<%--         <td><img height='100' width='80'src="<c:url value='/controller/classImage?id=' />"></td> --%>
         <td>${item.pd_description}</td>
         <td>${item.pd_price}</td>
         <td>${item.pd_qty}</td>
         <td><img width='80' 
        
     src="<c:url value='/controller/getimg?id=${item.pd_id}' />"></td>
     <td>
    	 <form name="form2" method="post" action="ItemDelete.do">
		<input class='inputClass' type="hidden" name="id" value="${item.pd_id}">
		<input type="submit" name="Submit" value="刪除此商品">
	</form>
	<form name="form3" method="post" action="preItemUpdate.do">
		<input class='InputClass' type="hidden" name="id" value="${item.pd_id}">
		<input type="submit" name="Submit" value="更改此商品細項">
	</form>
	</td>
     <td>
   	 	 
<%--                      <FORM  action="<c:url value='/BuyClassServlet.do' />"  --%>
<!--                             method="POST"> -->
<!--                                 購買數量: -->
<!--                         <select name='qty'> -->
<!--                            <option value="1">1</option> -->
<!--                            <option value="2">2</option> -->
<!--                            <option value="3">3</option> -->
<!--                            <option value="4">4</option> -->
<!--                            <option value="5">5</option> -->
<!--                            <option value="6">6</option> -->
<!--                            <option value="7">7</option> -->
<!--                            <option value="8">8</option> -->
<!--                            <option value="9">9</option> -->
<!--                            <option value="10">10</option> -->
<!--                        </select> -->
<!--                        這些隱藏欄位都會送到後端 -->
<%--                        <Input type='hidden' name='bookId' value='${entry.value.bookId}'> --%>
<%--                        <Input type='hidden' name='pageNo' value='${param.pageNo}'> --%>
<!--                        <label><i class="fa-solid fa-cart-shopping"></i><Input type='submit' value='加入購物車'> -->
<!--                        </label> -->
<!--                      </FORM> -->
    </td>
    </tr>
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
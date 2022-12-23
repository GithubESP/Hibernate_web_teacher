<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="header.jsp" %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
  <style>
    table {
      text-align: center;
    }
  </style>
</head>

<body>
  <header>
  </header>
  <div class="container">
    <h1>活動介紹</h1>
    <table id="table_id" class="display">
      <thead>
        <tr>
          <th>活動編號</th>
          <th>活動名稱</th>
          <th>活動圖片</th>
          <th>活動描述</th>
          <th>活動開始時間</th>
          <th>活動結束時間</th>
          <th>活動地點</th>
          <th>活動主辦單位</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="active" items="${actives}">
        <tr>
   <th scope="row">${active.activeID}</th>
      <td>${active.activeName}</td>
      <td><img height='100' width='80' src="<c:url  value='/toActiveImage?id=${active.activeID}'/>"></td>
      <td>${active.activeDescription}</td>
      <td>${active.activeStartDate}</td>
      <td>${active.activeEndDate}</td>
      <td>${active.activeLocation}</td>
      <td>${active.activeHost}</td>
      	<td><a href="<c:url context='${pageContext.request.contextPath}' value='/removeActiveController?id=${active.activeID}'></c:url>">刪除</a>&nbsp
	<a href="<c:url context='${pageContext.request.contextPath}' value='/showActiveController?id=${active.activeID}'></c:url>">修改</a></td>
        </tr>
         </c:forEach>
         <input type="button" value="新增" onclick="location.href='/Hibernate_web_teacher/t6_14Actives/jsp/addViewInfo.jsp'">
      </tbody>
    </table>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
  <script>
    $(document).ready(function () {
      $('#table_id').DataTable();
    });
  </script>
</body>

</html>
<%@ include file="footer.jsp" %>
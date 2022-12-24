<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>討論區</title>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
  <style>
    table {
      text-align: center;
    }
  </style>
</head>

<body>
  <header>
    <h1>討論區</h1>
  </header>
  <div class="container">
    <h1>文章列表</h1>
    <Form action="<c:url value='/JSP/AddPost.jsp'/>" method="POST" name="loginForm">
		 <input type="submit" value="新增文章"> 
	</Form>
    <table id="table_id" class="display">
      <thead>
        <tr>
          <th>編號</th>
          <th>標題</th>
          <th>貼文日期</th>
          <th>推</th>
          <th>噓</th>
          <th>操作</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="bean" items="${post}">
        <tr>
          <td>${bean.postId}</td>
          <td><a href="<c:url value='/ShowIDController?showid=${bean.postId}'/>">${bean.postTitle}</a></td>
          <td>${bean.postDate}</td>
          <td>${bean.postLike}</td>
          <td>${bean.postDislike}</td>
          <td><a href="<c:url value='/SearchIDController?searchid=${bean.postId}'/>">修改</a>&nbsp<a href="<c:url value='/DeleteController?delete=${bean.postId}'/>">刪除</a></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
  <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <script src="https://cdn.dat	atables.net/1.11.3/js/jquery.dataTables.min.js"></script>
  <script>
    $(document).ready(function () {
      $('#table_id').DataTable();
    });
  </script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
    <h1>修改文章</h1>
    <Form action="<c:url value='/SearchAllController'/>" method="POST" name="loginForm">
		<input type="submit" value="回文章列表"> 
	</Form>
    <table id="table_id" class="display">
      <thead>
        <tr>
          <th>編號</th>
          <th>標題</th>
          <th>貼文日期</th>
          <th>內容</th>
          <th>推</th>
          <th>噓</th>
          <th>留言</th>
          <th colspan="2">操作</th>
        </tr>
      </thead>
       
      <tbody>
      <Form action="<c:url value='/UpdateController'/>" method="POST" name="loginForm">
        <tr>
          <td><input type="text" name="postId" readonly="readonly" value="${post.postId}"></td>
          <td><input type="text" name="postTitle" required="required" value="${post.postTitle}"></td>
          <td><input type="text" name="postDate" required="required" value="${post.postDate}"></td>
          <td><input type="text" name="postContent" required="required" value="${post.postContent}"></td>
          <td><input type="text" name="postLike" value="${post.postLike}"></td>
          <td><input type="text" name="postDislike" value="${post.postDislike}"></td>
          <td><input type="text" name="postComment" value="${post.postComment}"></td>
          <td><input type="submit" value="完成"></td>
        </tr>
        </form>
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
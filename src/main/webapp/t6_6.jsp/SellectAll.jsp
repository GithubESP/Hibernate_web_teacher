<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>查詢頁面</title>
                    <link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
                    <script src="https://kit.fontawesome.com/f7498d7580.js" crossorigin="anonymous"></script>

                    <style>
                        table,
                        h1,
                        div {
                            text-align: center;
                        }
                    </style>
                </head>

                <body>
                    <c:set var="funcName" value="BMT" scope="session" />
                    <header>
                        <h1>資料列表</h1>
                    </header>
                    <table id="table_id" class="display">
                        <thead>
                            <tr>
                                <th>編號</th>
                                <th>寺廟名稱</th>
                                <th>主祀神</th>
                                <th>行政區</th>
                                <th>地址</th>
                                <th>登記別</th>
                                <th>教別</th>
                                <th>電話</th>
                                <th>負責人</th>
                                <th>其他</th>
                                <th>X座標</th>
                                <th>Y座標</th>
                                <th>統一編號</th>
                                <th>統一編號</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="tmp" items="${tmp}">
                                <tr>
                                    <td>${tmp.templeId}</td>
                                    <td>${tmp.templeName}</td>
                                    <td>${tmp.deitiesName}</td>
                                    <td>${tmp.administrative}</td>
                                    <td>${tmp.address}</td>
                                    <td>${tmp.register}</td>
                                    <td>${tmp.sect}</td>
                                    <td>${tmp.phone}</td>
                                    <td>${tmp.principal}</td>
                                    <td>${tmp.other}</td>
                                    <td>${tmp.WGS84X}</td>
                                    <td>${tmp.WGS84Y}</td>
                                    <td>${tmp.uniformnumbers}</td>
                                    <td>
                                        <div style="display:inline">
                                            <a href="<c:url value='/ClassDelete.do?id=${bean.classId}'/>"><input
                                                    type="submit" value="刪除"></a>
                                            <a
                                                href="<c:url value='/ClassPreUpdateServlet.do?classId=${bean.classId}'/>"><input
                                                    type="submit" value="修改"></a>
                                        </div>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
                    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
                    <script>

                        $(document).ready(function () {
                            $('#table_id').DataTable();
                        });

                    </script>
                </body>

                <div><a href="<c:url value='/class/ClassInsert.jsp'/>"><input type="submit" value="新增紀錄"></a></div>

                </html>
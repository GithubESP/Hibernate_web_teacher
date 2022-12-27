<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="https://kit.fontawesome.com/f7498d7580.js"
	crossorigin="anonymous"></script>


<c:set var='debug' value='true' scope='application' />

<table class='menuOuter' style="float: left">
	<tr height="48px">

		<div style="display: inline">
			<c:choose>

				<c:when test="${ funcName != 'BMT' }">
					<span> <a class="fa-solid fa-wrench"
						href="<c:url value='/controller/classListMaintainServlet' />">
							維護</a>
				</c:when>
				<c:otherwise>
                      維護
                </c:otherwise>
			</c:choose>
		</div>

		<div style="display: inline">
			<c:choose>
				<c:when test="${ funcName != 'SHO' }">

					<label> <a
						href="<c:url value='/controller/classShoppingList' />"><i
							class="fa-solid fa-cart-shopping"></i> 購物</a></label>

				</c:when>
				<c:otherwise>
                    購物
                </c:otherwise>
			</c:choose>
		</div>


		<div style="display: inline">
			<c:if test="${empty LoginOK}">
				<label> <a href="<c:url value='/login.jsp' />"><i
						class="fa-solid fa-right-to-bracket"></i> 登入</a></label>
			</c:if>
		</div>

		<div style="display: inline">
			<label><a href="<c:url value='/index.html' />"><i
					class="fa-sharp fa-solid fa-house"></i> 主頁</a> </label>

			<div style="display: inline">
				<c:choose>
					<c:when test="${ funcName != 'CHE' }">
						<label><a
							href="<c:url value='/t6_21class/ShowShoppingCartContent.jsp' />"><i
								class="fa-sharp fa-solid fa-bag-shopping"></i>結帳</a></label>

					</c:when>
					<c:otherwise>
                    結帳
                </c:otherwise>
				</c:choose>
			</div>

			<c:choose>
				<c:when test="${ ! empty LoginOK }">
					<label><a href="<c:url value='/t6_21class/logout.jsp' />"><i
							class="fa-solid fa-right-from-bracket"></i> 登出 </a></label>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<small>${pageContext.session.id}</small>
	</tr>
</table>
<hr>
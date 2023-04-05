<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<div>
		<h1>
			<c:choose>
				<c:when test="${member == null }">
					관리자 로그인이 되어있지 않은 상태입니다.
				</c:when>
				<c:otherwise>
					관리자 ${member.userId } 님이 로그인중입니다.
				</c:otherwise>
			</c:choose>
		</h1>

		<ul>
			<li>
				<a href="/admin/managerLoginPage">관리자모드 로그인</a>
			</li>
			<li>
				<a href="/admin/admindetail">관리자 페이지</a>
			</li>
			<li>
				<a href="/seller/mainpage">판매자 페이지</a>
			</li>
		</ul>
	</div>
</body>
</html>
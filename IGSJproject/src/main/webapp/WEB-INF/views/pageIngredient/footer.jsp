<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지 푸터</title>
<style type="text/css">
footer {
	display: block;
	transform : translateY(100%);
}

.footer-ul {
	list-style-type: none;
	padding-left: 10px;
}

.footer-ul > li {
	font-size: 12px;
	float: left;
}

.footer-ul > li > a {
	text-decoration: none;
	color: black;
}

.footer-ul > li > a::after {
	content: "|";
	margin: 0 4px;
}

.copyright {
	width: 98.9%;
	height: 40px;
	display: flex;
	justify-content: left;
	align-items: center;
	padding-left: 16px;
	background-color: black;
	color: white;
	font-size: 20px;
}
</style>
</head>
<body>
	<footer>
		<div>
			<div style="width: 100%; display: block;">
				<ul style="float: left;" class="footer-ul">
					<li>
						<a href="#">회사소개</a>
					</li>
					<li>
						<a href="#">공지사항</a>
					</li>
					<li>
						<a href="#">이벤트 공지</a>
					</li>
					<li>
						<a href="#">입점/제휴/대량구매</a>
					</li>
					<li>
						<a href="#">
							<b>개인정보처리방침</b>
						</a>
					</li>
					<li>
						<a href="#">영상정보처리기기 운영·관리방침</a>
					</li>
					<li>
						<a href="#">이용약관</a>
					</li>
					<li>
						<a href="#">로고 다운로드</a>
					</li>
					<li>
						<a href="http://localhost:8086">관리자</a>
					</li>
				</ul>
			</div>
		</div>
		<div></div>
		<div></div>
		<div class="copyright">FASHION WEB MAGAZINE / LIFE STYLE SELECT SHOP WWW.IPGOSALJA.COM</div>
	</footer>
</body>
</html>
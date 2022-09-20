<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Stellar by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>main</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">

						<!-- Introduction -->
							<section id="intro" class="main">
								<div class="spotlight">
									<div class="content">
										<header class="major">
											<h2>main</h2>
										</header>
										<c:choose>
											<c:when test="${member!=null }">
												<h2>HELLO , <a href="mypage.jsp">${member.name}</a> !&nbsp;&nbsp;:D</h2>
											</c:when>
											<c:when test="${member==null }">
												<h2>Guest님 안녕하세요 !&nbsp;&nbsp;:D</h2>
											</c:when>
										</c:choose>
										<div class="table-wrapper">
											<table>
												<thead>
													<tr>
														<th>num</th>
														<th>title</th>
														<th>writer</th>
														<th>cnt</tr>
												</thead>
												<tbody>
												<c:forEach var="b" items="${datas}">
													<tr>
														<td><a href="board.do?bid=${b.bid}">${b.bid}</a></td>
														<td>${b.title}</td>
														<td>${b.writer}</td>
														<td>${b.content}</td>
													</tr>
												</c:forEach>
												</tbody>
												<tfoot>
												<c:choose>
													<c:when test="${member==null }">
															<a href="login.jsp"><button type="button">로그인</button></a>
													</c:when>
													<c:when test="${member!=null}">
															<a href="logout.do"><button type="button">로그아웃</button></a>
															<a href="mypage.jsp"><button type="button">마이페이지</button></a>
															<a href="deleteM.do?mid=${member.mid}&mpw=${member.mpw}"><button type="button">회원탈퇴</button></a>
													</c:when>
												</c:choose>
												</tfoot>
											</table>

										</div>
									</div>
								</div>
							</section>

					</div>

				<!-- Footer -->
					<footer id="footer">
						<section>
							<h2>Aliquam sed mauris</h2>
							<p>Sed lorem ipsum dolor sit amet et nullam consequat feugiat consequat magna adipiscing tempus etiam dolore veroeros. eget dapibus mauris. Cras aliquet, nisl ut viverra sollicitudin, ligula erat egestas velit, vitae tincidunt odio.</p>
							<ul class="actions">
								<li><a href="generic.html" class="button">Learn More</a></li>
							</ul>
						</section>
						<section>
							<h2>Etiam feugiat</h2>
							<dl class="alt">
								<dt>Address</dt>
								<dd>1234 Somewhere Road &bull; Nashville, TN 00000 &bull; USA</dd>
								<dt>Phone</dt>
								<dd>(000) 000-0000 x 0000</dd>
								<dt>Email</dt>
								<dd><a href="#">information@untitled.tld</a></dd>
							</dl>
							<ul class="icons">
								<li><a href="#" class="icon brands fa-twitter alt"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon brands fa-facebook-f alt"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon brands fa-instagram alt"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon brands fa-github alt"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon brands fa-dribbble alt"><span class="label">Dribbble</span></a></li>
							</ul>
						</section>
						<p class="copyright">&copy; Untitled. Design: <a href="https://html5up.net">HTML5 UP</a>.</p>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>
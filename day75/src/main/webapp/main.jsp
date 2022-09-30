<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


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
								<!-- Nav -->
					<nav id="nav">
						<ul>
							<li><a href="#intro" class="active">Introduction</a></li>
							<li><a href="#first">First Section</a></li>
							<li><a href="main.do?lang=ko">한국어</a></li>
							<li><a href="main.do?lang=en">ENGLISH</a></li>
						</ul>
					</nav>
				<!-- Main -->
					<div id="main">

						<!-- Introduction -->
							<section id="intro" class="main">
								<div class="spotlight">
									<div class="content">
										<header class="major">
											<h2><spring:message code="message.header.h2"/></h2>
										</header>
										<c:choose>
											<c:when test="${member!=null }">
												<h2><spring:message code="message.user.h2"/> <a href="mypage.jsp">${member.name}</a> !&nbsp;&nbsp;:D</h2>
												<!--  검색 -->
												<form action="main.do" method="post">
												<table>
												<thead>
													<tr>
														<th><select name="searchCondition">
															<c:forEach var="v" items="${scMap}">
																<option value="${v.value}">${v.key}</option>
															</c:forEach>
														</select></th>
														<th><input type="text" name="searchContent" placeholder="검색어를 입력하세요"></th>
														<th><input type="submit" class="button" value="search"></th>
												</thead>
												</table>
												</form>
											</c:when>
											<c:when test="${member==null }">
												<h2>Guest님 안녕하세요 !&nbsp;&nbsp;:D</h2>
												<form action="main.do" method="post">
												<table>
												<thead>
													<tr>
														<th><select name="searchCondition">
															<c:forEach var="v" items="${scMap}">
																<option value="${v.value}">${v.key}</option>
															</c:forEach>
														</select></th>
														<th><input type="text" name="searchContent" placeholder="검색어를 입력하세요"></th>
														<th><input type="submit" class="button" value="search"></th>
												</thead>
												</table>
												</form>
											</c:when>
										</c:choose>
										<div class="table-wrapper">
											<table>
												<thead>
													<tr>
														<th>num</th>
														<th>title</th>
														<th>writer</th>
														<th>content</th>
														<th>date</th>
												</thead>
												<tbody>
												<c:forEach var="b" items="${datas}">
													<tr>
														<td><a href="board.do?bid=${b.bid}">${b.bid}</a></td>
														<td>${b.title}</td>
														<td>${b.writer}</td>
														<td>${b.content}</td>
														<td>${b.regdate}</td>
													</tr>
												</c:forEach>
												</tbody>
												<tfoot>
												<c:choose>
													<c:when test="${member==null }">
															<a href="login.do?lang=ko"><button type="button"><spring:message code="message.login.a"/></button></a>
													</c:when>
													<c:when test="${member!=null}">
															<a href="logout.do"><button type="button"><spring:message code="message.logout.a"/></button></a>
															<a href="mypage.jsp"><button type="button"><spring:message code="message.mypage.a"/></button></a>
															<a href="deleteM.do?mid=${member.mid}&mpw=${member.mpw}"><button type="button"><spring:message code="message.deleteM.a"/></button></a>
															<a href="boardForm2.jsp"><button type="button"><spring:message code="message.writeB.a"/></button></a>
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
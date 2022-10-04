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
		<title>board</title>
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
											<h2>board</h2>
										</header>
											<c:if test="${member!=null}">
												<a href="deleteB.do?bid=${data.bid}"><button type="button">글 삭제</button></a>
											</c:if>
										<div class="table-wrapper">
										<form action="updateB.do" method="post" enctype="multipart/form-data">
										<input type="hidden" value="${data.bid}" name="bid">
											<table>
												<thead>
													<tr>
														<th>title</th>
														<th>content</th>
														<th>writer</th>														
														<th>regdate</th>
														<th>file</th>
												</thead>
												<tbody>
													<tr>
														<td><input type="text" value="${data.title}" name="title"></td>
														<td><input type="text" value="${data.content}" name="content"></td>
														<td>${data.writer}</td>
														<td>${data.regdate}</td>
														<td><input type="file" name="uploadFile" onchange="loadFile(this)"><img alt="${data.fileName }" src="images/${data.fileName}"; id="preview" style="margin-top:1%;"/></td>
													</tr>
												</tbody>
												<tfoot>
													<tr>
														<td colspan="3"></td>
														<td><a href="main.do">go to main</a></td>
													</tr>
												</tfoot>
											</table>
											<button type="submit" >글 수정</button>
											</form>
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
	      <script type="text/javascript">
			   function loadFile(input){
			      // 여러개의 이미지를 읽을수도 있기 때문에 
			      if(input.files && input.files[0]){
			         var fr = new FileReader();
			         //파일리더로 일고 읽는게 완료되면  만들어준 아이디에 속성값을 지정하여 사용하겠다.
			         fr.onload=function(event){
			            document.getElementById('preview').src=event.target.result;
			         };
			         fr.readAsDataURL(input.files[0]);
			         // 이미지파일을 읽어 온다.
			      }
			      else{
			         document.getElementById('preview').src="";
			      }
			   }
			</script>
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
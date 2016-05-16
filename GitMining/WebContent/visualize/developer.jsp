<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="echarts.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/visualize/css/font.css" rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css"
	href="/visualize/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/visualize/css/templatemo-style.css">
<link rel="stylesheet" type="text/css" href="/visualize/css/style.css">
<title>Developer</title>
</head>

<body>
	<%@include file="/visualize/common/navigation.jsp"%>
	
	<div id="section1">
		<header id="header-area" class="intro-section">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 text-center">
						<div class="header-content">
							<h1>Developer</h1>
							<h4>Do you want to learn more about your
							favorite developer?</h4>
						</div>
					</div>
				</div>
			</div>
		</header>
	</div>

	<br />
	<br />
	<br />
	<form action="/Developer" method="post">
		<input type="text" placeholder="Developer..." maxlength="255"
			style="position: absolute; left: 50%; margin-left: -300px;
			width: 500px; height: 50px">
		<input id="search" type="submit" value="search"
			style="position: absolute; left: 50%; margin-left: 200px;
			 width: 100px; height: 50px" />
	</form>
	<br />
	<br />
	<br />

	<div id="section2">
		<%
			int section = 3;
			for (int i = 0; i < section; ++i) {
		%>
		<section id="feature-area" class="about-section">
			<div class="container">
				<%
					for (int j = 0; j < 3; ++j) {
				%>
				<div class="row text-center inner">
					<div class="col-sm-4">
						<div class="feature-content">
							<a class="First-Commend"
								href="http://www.gitmining.net/
							GithubVisualization/repository/content?id=8393">paperclip</a>
							<p class="feature-content-description">Easy file attachment
								management for ActiveRecord</p>
							<p>developer : thoughtbot</p>
							<p>Star : 144</p>
							<p>Fork : 222</p>
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</section>
		<%
		}
	%>
	</div>


	<br />
	<br />

	<!-- 	<div class="container"> -->
<!-- 		<section class="col-md-12 "> -->
<!-- 			<div class="col-lg-6 col-md-6 col-md-push-6 content" id="relation"> -->
<!-- 				<img src="/visualize/img/relation.png" alt="Member Relationship" -->
<!-- 					class="tm-image"> -->
<!-- 			</div> -->
<!-- 			<div class="col-lg-6 col-md-6 col-md-pull-6 content" id="map"> -->
<!-- 				<img src="/visualize/img/map.png" alt="World Map" class="tm-image"> -->
<!-- 			</div> -->
<!-- 		</section> -->

<!-- 		<section class="col-md-12 content" id="clients"> -->
<!-- 			<div class="col-lg-6 col-md-6 content-item"></div> -->
<!-- 			<div class="col-lg-6 col-md-6 content-item background flexbox"></div> -->
<!-- 		</section> -->
<!-- 	</div> -->

	<%@include file="/visualize/common/footer.jsp" %>

	<script src="/visualize/js/echarts.min.js"></script>
	<script src="/visualize/js/jquery.min.js"></script>
	<script src="/visualize/js/bootstrap.min.js"></script>
	<script src="/visualize/js/jquery-1.11.2.min.js"></script>
	<script src="/visualize/js/jquery.scrollUp.min.js"></script>
	<script src="/visualize/js/parallax.js-1.3.1/parallax.js"></script>
	<script>
		// HTML document is loaded. DOM is ready.
		$(function() {

			// Parallax
			$('.intro-section').parallax({
				imageSrc : '/visualize/img/bg-1.jpg',
				speed : 0.2
			});
			
			// jQuery Scroll Up / Back To Top Image
			$.scrollUp({
				scrollName : 'scrollUp', // Element ID
				scrollDistance : 300, // Distance from top/bottom before showing element (px)
				scrollFrom : 'top', // 'top' or 'bottom'
				scrollSpeed : 1000, // Speed back to top (ms)
				easingType : 'linear', // Scroll to top easing (see http://easings.net/)
				animation : 'fade', // Fade, slide, none
				animationSpeed : 300, // Animation speed (ms)		        
				scrollText : '', // Text for element, can contain HTML		        
				scrollImg : true
			// Set true to use image		        
			});

			// ScrollUp Placement
			$(window).on(
					'scroll',
					function() {

						// If the height of the document less the height of the document is the same as the
						// distance the window has scrolled from the top...
						if ($(document).height() - $(window).height() === $(
								window).scrollTop()) {

							// Adjust the scrollUp image so that it's a few pixels above the footer
							$('#scrollUp').css('bottom', '80px');

						} else {
							// Otherwise, leave set it to its default value.
							$('#scrollUp').css('bottom', '30px');
						}
					});
		});
	</script>
</body>
</html>